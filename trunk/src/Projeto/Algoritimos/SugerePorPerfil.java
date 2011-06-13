/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.Algoritimos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;

import Projeto.TratamentosArquivos.Estabelecimentos;
import Projeto.TratamentosArquivos.Usuarios;
import Projeto.acoes.Mensagem;
import Projeto.acoes.Ordena;

/**
 * 
 * @author laerton
 */
public class SugerePorPerfil extends Sugere {
	/**
	 * Esta classe trata as pesquisa de sugestões de estabelecimentos por meio
	 * de comparações de perfis
	 * 
	 * @param usuarios
	 *            Objeto do tipo Usuarios
	 * @param estabelecimentos
	 *            Objeto do tipo Estabelecimentos
	 * @throws IOException
	 *             Exception lançado pelos objetos Usuarios e Estabelecimentos
	 */
	public SugerePorPerfil(Usuarios usuarios, Estabelecimentos estabelecimentos)
			throws IOException {
		super(usuarios, estabelecimentos);
	}

	private String[] geraRecomendacoes(Integer[] minhasNotas, int r)
			throws Exception {
		if (r < 0) {
			throw new Exception("Nao deve ser informado numero negativo.");
		}

		ArrayList<String> semelhantes = super.usuariosSemelhantes(minhasNotas);

		if (semelhantes.size() != 0) {
			if (!(Arrays.toString(minhasNotas).contains("0"))
					|| Integer.valueOf(semelhantes.get(0).split(":")[0]) <= 0) {
				return null;
			}
		} else {
			return null;
		}

		ArrayList<String> recomendacoesInternas = new ArrayList<String>();
		ArrayList<String> temporario = null;
		String usuarioSemelhante;
		int faltam = r, qTemporario, qRecomenda;

		Iterator<String> it = (Iterator<String>) semelhantes.iterator();
		while (it.hasNext()) {
			usuarioSemelhante = it.next().split(":")[1];
			Integer[] notasUsuarioSemelhante = super
					.notasUsuario(usuarioSemelhante);
			temporario = comparacaoDeNotasEAdiciona(minhasNotas,
					notasUsuarioSemelhante, recomendacoesInternas,
					usuarioSemelhante);

			qTemporario = temporario.size();
			if (faltam < qTemporario) {
				for (int i = 0; i < qTemporario - faltam; i++) {

					temporario.remove(qTemporario - (i + 1));
				}
			}
			recomendacoesInternas.addAll(temporario);
			qRecomenda = recomendacoesInternas.size();
			faltam = r - qRecomenda;

			if (qRecomenda == r) {
				break;
			}

		}
		if (!(recomendacoesInternas.isEmpty())) {
			String[] recomendacoesAuxiliar = recomendacoesInternas.toString()
					.replace("[", "").replace("]", "").split(",");
			return recomendacoesAuxiliar;
		}
		return null;
	}

	private ArrayList<String> comparacaoDeNotasEAdiciona(Integer[] minhasNotas,
			Integer[] notasUsuarioSemelhante, ArrayList<String> recomendacoes,
			String usuarioSemelhante) {

		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		String estabelecimentoAtual;
		for (int i = 0; i < minhasNotas.length; i++) {
			if (minhasNotas[i] == 0) {
				if (notasUsuarioSemelhante[i] > 0) {
					estabelecimentoAtual = super.listaEstabelecimentos().get(i);
					if (!(recomendacoes.toString()
							.contains(estabelecimentoAtual))) {
						if (super.getFiltroAtivo()) {
							if ((super
									.contemEstabecimento(estabelecimentoAtual))) {
								recomendacoesPorUsuario
										.add(notasUsuarioSemelhante[i]
												+ ":"
												+ super.listaEstabelecimentos()
														.get(i));
								
							}
						} else {
							recomendacoesPorUsuario
									.add(notasUsuarioSemelhante[i]
											+ ":"
											+ super.listaEstabelecimentos()
													.get(i));
						}
					}
				}
			}
		}
		if (recomendacoesPorUsuario.size() > 0) {
			try {
				Ordena.bubbleSortDec(recomendacoesPorUsuario);
			} catch (Exception ex) {
				Mensagem.exibirMensagem(ex.getMessage());
			}
		}
		return recomendacoesPorUsuario;
	}

	/**
	 * Recebe as notas de um usuário e retorna os restaurantes em forma de
	 * ranking numerado
	 * 
	 * @param Integer
	 *            [] - notasDoUsuario
	 * @param int - Quantidade de indicações pedidas pelo usuário
	 * @return String[] - Recomendações em forma de ranking numerado
	 * @throws Exception
	 *             - Lança excessão de geraRecomendacoes()
	 */
	public String[] recomendacoes(Integer[] minhasNotas,
			int numeroDeRecomendacoes) throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(minhasNotas,
				numeroDeRecomendacoes);

		if (recomendacoesInternas != null) {

			if (recomendacoesInternas.length > 0) {

				for (int i = 0; i < recomendacoesInternas.length; i++) {
					StringBuilder linha = new StringBuilder();
					Formatter fm = new Formatter(linha);
					fm.format("%3d° lugar -  %s", (i + 1),
							recomendacoesInternas[i].split(":")[1]);

					recomendacoesInternas[i] = linha.toString();

				}
			} else {

				return null;
			}
		}

		return recomendacoesInternas;
	}

}
