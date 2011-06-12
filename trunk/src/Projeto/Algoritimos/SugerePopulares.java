package Projeto.Algoritimos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import Projeto.TratamentosArquivos.Estabelecimentos;
import Projeto.TratamentosArquivos.Usuarios;
import Projeto.acoes.Ordena;

/**
 * 
 * @author Laerton Marques e Isaque.
 */
public class SugerePopulares extends Sugere {
	private String[] notasGlobais;

	/**
	 * Esta classe trata a manipulação de informações de opiniões de cada perfil
	 * por usuário exibindo uma lista por popularidade.
	 * 
	 * @param usuarios
	 *            Objeto do tipo Usuarios
	 * @param estabelecimentos
	 *            Objeto do tipo Estabelecimentos
	 * @throws IOException
	 *             Exception lançado pelos objetos Estabelecimentos e Ususarios.
	 */
	public SugerePopulares(Usuarios usuarios, Estabelecimentos estabelecimentos)
			throws IOException {
		super(usuarios, estabelecimentos);
		notasGlobais = new String[super.getEstabelecimentos()
				.getEstabelecimentos().size()];

	}

	private void coletaMedias() throws Exception {
		ArrayList<String> listaEstabelecimentos = super.getEstabelecimentos()
				.getEstabelecimentos();
		Double[] notas = new Double[listaEstabelecimentos.size()];
		Iterator<String> it = super.getUsuarios().getUsuarios().iterator();// opinioes.values().iterator();

		while (it.hasNext()) {
			String[] linha = super.getUsuarios()
					.getOpinioes((String) it.next());
			for (int i = 0; i < (linha.length - 2); i++) {
				if (notas[i] == null) {
					notas[i] = Double.valueOf((linha[i + 2].split(":"))[0]);
				} else {
					notas[i] += Double.valueOf((linha[i + 2].split(":"))[0]);
				}
			}

		}

		for (int i = 0; i < notas.length; i++) {
			notasGlobais[i] = notas[i] + ": " + listaEstabelecimentos.get(i);

		}

		Ordena.bubbleSortDec(notasGlobais);

	}

	private String[] mostraNotasGlobais() throws Exception {
		coletaMedias();
		return notasGlobais;
	}

	/**
	 * Algoritmo que retorna o nome dos restaurantes, pela ordem de popularidade
	 * 
	 * @param int com a quantidade de restaurantes pedida pelo usuário
	 * @return String[] - Nome dos restaurantes
	 * @throws Exception
	 *             - Lança a excessão de mostraNotasGlobais()
	 */

	public String[] maisPopulares(int numeroRecomendacoes) throws Exception {
		String[] lista = mostraNotasGlobais();
		String[] retorno = new String[numeroRecomendacoes];
		for (int i = 0; i < numeroRecomendacoes; i++) {
			StringBuilder linha = new StringBuilder();
			Formatter fm = new Formatter(linha);
			fm.format("%3d° lugar -  %s", (i + 1), lista[i].split(":")[1]);
			retorno[i] = linha.toString();
		}
		return retorno;
	}

}
