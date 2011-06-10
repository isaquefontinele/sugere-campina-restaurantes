/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

/**
 * 
 * @author laerton
 */
public class SugerePorPerfil extends SugereCampina {
    /**
     * Esta classe trata as pesquisa de sugestões de estabelecimentos por meio de comparações de perfis 
     * @param usuarios Objeto do tipo Usuarios
     * @param estabelecimentos Objeto do tipo Estabelecimentos
     * @throws IOException Exception lançado pelos objetos Usuarios e Estabelecimentos
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
		String[] semelhantes = super.usuariosSemelhantes(minhasNotas);
        	if (!(Arrays.toString(minhasNotas).contains("0"))
				|| Integer.valueOf(semelhantes[0].split(":")[0]) <= 0) {
			return null;
		}
        	ArrayList<String> recomendacoes = new ArrayList<String>();
		String usuarioSemelhante;
		int contador = 0;

		do {
			usuarioSemelhante = semelhantes[contador].split(":")[1];

			Integer[] notasUsuarioSemelhante = super
					.notasUsuario(usuarioSemelhante);
			recomendacoes.addAll(comparacaoDeNotasEAdiciona(minhasNotas,
					notasUsuarioSemelhante, recomendacoes, usuarioSemelhante));
			contador += 1;

		} while ((recomendacoes.size() < r) && (contador < semelhantes.length)
				&& (Integer.valueOf(semelhantes[contador].split(":")[0]) > 0));

		String[] recomendacoesAuxiliar = recomendacoes.toString()
				.replace("[", "").replace("]", "").split(",");
		contador = 0;
		if (r < recomendacoesAuxiliar.length) {
			String[] recomendacoesDefinitivas = new String[r];
			for (int i = 0; i < r; ++i) {
				recomendacoesDefinitivas[i] = recomendacoesAuxiliar[i];
			}
			return recomendacoesDefinitivas;
		}

		return recomendacoesAuxiliar;
	}

	private ArrayList<String> comparacaoDeNotasEAdiciona(Integer[] minhasNotas,
			Integer[] notasUsuarioSemelhante, ArrayList<String> recomendacoes,
			String usuarioSemelhante) {
		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		// recomendacoesPorUsuario.clear();
		for (int i = 0; i < minhasNotas.length; i++) {
			// Confere se a nota do restaurante n para usuario atual e zero
			// e para o semelhante e positiva
			// Segunda verificacacao e para saber se o restaurante atual nao
			// ja esta na lista
			if ((minhasNotas[i] == 0 && notasUsuarioSemelhante[i] > 0)
					&& (!(recomendacoes.toString()
							.contains(super.listaEstabelecimentos().get(i))))) {
				recomendacoesPorUsuario.add(notasUsuarioSemelhante[i]
						+ ":"
						+ super.getEstabelecimentos().getEstabelecimentos()
								.get(i) + ":" + usuarioSemelhante);

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
	public String[] recomendacoes(Integer[] minhasNotas, int r)
			throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(minhasNotas, r);
		if (recomendacoesInternas != null) {
			for (int i = 0; i < recomendacoesInternas.length; i++) {
				StringBuilder linha = new StringBuilder();
				Formatter fm = new Formatter(linha);
				fm.format("%3d° lugar -  %s", (i + 1),
						recomendacoesInternas[i].split(":")[1]);
				recomendacoesInternas[i] = linha.toString();

			}
		}
		return recomendacoesInternas;
	}

}
