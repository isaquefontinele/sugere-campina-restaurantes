package Projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Classe com os algoritmos de recomendações
 * @author Isaque e Laerton
 * 
 */
public class SugereCampina {
	private Map<String, String[]> opinioes, estabelecimentos;
	private String[] notasGlobais, mediasGlobais;
	private ManipulaPesquisa mOpinioes;
	private ManipulaRestaurante mEstabelecimentos;
	private String novoUsuario;


	/**
	 * Construtor da Classe SugereCampina
	 * @param Objeto do tipo ManipulaPesquisa
	 * @param Objeto do tipo ManipulaRestaurante
	 * @throws IOException - Arquivo inválido
	 */
	public SugereCampina(ManipulaPesquisa mOpinioes,
			ManipulaRestaurante mEstabelecimentos) throws IOException {
		this.mOpinioes = mOpinioes;
		this.mEstabelecimentos = mEstabelecimentos;
		opinioes = mOpinioes.recolheDados();
		estabelecimentos = mEstabelecimentos.recolheDados();
		mediasGlobais = new String[estabelecimentos.size()];
		notasGlobais = new String[estabelecimentos.size()];
		

	}


	private void coletaMedias() throws Exception {
		ArrayList<String> estabelecimentos = getEstabelecimentos();
		Double[] notas = new Double[estabelecimentos.size()];

		java.util.Iterator it = opinioes.values().iterator();

		while (it.hasNext()) {
			String[] linha = (String[]) it.next();
			for (int i = 0; i < (linha.length - 2); i++) {
				if (notas[i] == null) {
					notas[i] = Double.valueOf((linha[i + 2].split(":"))[0]);
				} else {
					notas[i] += Double.valueOf((linha[i + 2].split(":"))[0]);
				}
			}

		}

		for (int i = 0; i < notas.length; i++) {
			notasGlobais[i] = notas[i] + ": " + estabelecimentos.get(i);
			mediasGlobais[i] = (notas[i] / opinioes.size() + ": " + estabelecimentos
					.get(i));
		}

		Ordena.bubbleSortDec(notasGlobais);
		Ordena.bubbleSortDec(mediasGlobais);

	}

	/**
	 * Gera um ArrayList com o nome dos Restaurantes
	 * @return ArrayList - Nomes dos estabelecimentos
	 */
	public ArrayList<String> getEstabelecimentos() {
		String[] linhaCabecalho = mOpinioes.getLinhaCabecalho();
		ArrayList<String> listaEstabelecimentos = new ArrayList<String>();
		for (int i = 2; i < linhaCabecalho.length; i++) {
			listaEstabelecimentos.add(linhaCabecalho[i]);
		}

		return listaEstabelecimentos;

	}
	/**
	 * Pega as Médias Globais
	 * @return String[] - Médias Globais
	 * @throws Exception - Lanca a excessão de coletaMedias()
	 */
	public String[] getMediasGlobais() throws Exception {
		coletaMedias();
		return mediasGlobais;
	}
	/**
	 * Pega as Notas Globais
	 * @return String[] - Notas Globais
	 * @throws Exception - Lança a excessão de coletaMedias()
	 */
	public String[] getNotasGlobais() throws Exception {
		coletaMedias();
		return notasGlobais;
	}
	/**
	 * Pega as Opiniões de um determinado usuário
	 * @param String - Nome do usuário
	 * @return String[] - Opiniões do usuário
	 */
	public String[] getOpinioes(String usuario) {
		return (String[]) opinioes.get(usuario);
	}
	/**
	 * Pega os nomes dos usuários
	 * @return Set - Nomes dos usuários do arquivo
	 */
	public Set getPerfis() {
		return opinioes.keySet();
	}
	/**
	 * Algoritmo que retorna o nome dos restaurantes, pela ordem de popularidade 
	 * @param int com a quantidade de restaurantes pedida pelo usuário
	 * @return String[] - Nome dos restaurantes
	 * @throws Exception - Lança a excessão de getNotasGlobais()
	 */
	public String[] maisPopulares(int numeroRecomendacoes) throws Exception {

		String[] lista = getNotasGlobais();
		String[] retorno = new String[numeroRecomendacoes];
		for (int i = 0; i < numeroRecomendacoes; i++) {
			StringBuilder linha = new StringBuilder();
			Formatter fm = new Formatter(linha);
			fm.format("%3d° lugar -  %s", (i + 1), lista[i].split(":")[1]);
			retorno[i] = linha.toString();
		}
		return retorno;
	}
	/**
	 * Coleta as notas de um determinado usuário e as retorna em forma de Array de Integer
	 * @param String - Nome do usuário
	 * @return Integer[] com as notas do usuário recebido
	 * @throws IOException - Lança a Excessão de linhaLeitura()
	 */
	public Integer[] notasUsuario(String usuario) throws IOException {
		Integer[] notas = new Integer[estabelecimentos.size()];
		String[] linhaLeitura = (String[]) opinioes.get(usuario);
		for (int i = 2; i < linhaLeitura.length; ++i) {
			String nota = (linhaLeitura[i].split(":")[0].replace(" ", ""));
			notas[i - 2] = Integer.valueOf(nota);
		}
		return notas;
	}
	/**
	 * Recebe as notas de um usuário e retorna os restaurantes em forma de ranking numerado
	 * @param Integer[] - notasDoUsuario
	 * @param int - Quantidade de indicações pedidas pelo usuário
	 * @return String[] - Recomendações em forma de ranking numerado
	 * @throws Exception - Lança excessão de geraRecomendacoes()
	 */
	public String[] recomendacoes(Integer[] minhasNotas, int r)	throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(minhasNotas, r);

		for (int i = 0; i < recomendacoesInternas.length; i++) {
			StringBuilder linha = new StringBuilder();
			Formatter fm = new Formatter(linha);
			fm.format("%3d° lugar -  %s", (i + 1), recomendacoesInternas[i]
					.split(":")[1]);
			recomendacoesInternas[i] = linha.toString();

		}
		return recomendacoesInternas;
	}
	/**
	 * Recebe o nome de um usuário e retorna os restaurantes em forma de ranking numerado
	 * @param String - Nome do usuário
	 * @param int - Quantidade de indicações pedida pelo usuário
	 * @return String[] - Recomendações em forma de ranking numerado
	 * @throws Exception - Lança excessão de geraRecomendacoes()
	 */
	public String[] recomendacoes(String usuario, int r) throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(usuario, r);

		for (int i = 0; i < recomendacoesInternas.length; i++) {
			StringBuilder linha = new StringBuilder();
			Formatter fm = new Formatter(linha);
			fm.format("%3d° lugar -  %s", (i + 1), recomendacoesInternas[i]
					.split(":")[1]);
			recomendacoesInternas[i] = linha.toString();

		}
		return recomendacoesInternas;
	}

	private String[] geraRecomendacoes(Integer[] minhasNotas, int r) throws Exception {
		if (r < 0) {
			throw new Exception("Nao deve ser informado numero negativo.");
		}

		String[] semelhantes = usuariosSemelhantes(minhasNotas);

		// Verifica se o usuario nao notas zero
		if (!(Arrays.toString(minhasNotas).contains("0"))
				|| Integer.valueOf(semelhantes[0].split(":")[0]) <= 0) {
			return null;
		}
		
		
		// Recolhe as notas do usuario atual para comparar com outro usuario.
		// Integer[] minhasNotas = notasUsuario(usuario);
		ArrayList<String> recomendacoes = new ArrayList<String>();
		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		String usuarioSemelhante;
		int contador = 0;

		do {
			// Coletando o nome do usuario com maior semelhanca pela ordem
			usuarioSemelhante = semelhantes[contador].split(":")[1];

			// Coletando as notas do usuario semenhante
			Integer[] notasUsuarioSemelhante = notasUsuario(usuarioSemelhante);
			recomendacoesPorUsuario.clear();
			for (int i = 0; i < minhasNotas.length; i++) {
				// Confere se a nota do restaurante n para usuario atual e zero
				// e para o semelhante e positiva
				// Segunda verificacacao e para saber se o restaurante atual nao
				// ja esta na lista
				if ((minhasNotas[i] == 0 && notasUsuarioSemelhante[i] > 0)
						&& (!(recomendacoes.toString()
								.contains(getEstabelecimentos().get(i))))) {
					recomendacoesPorUsuario.add(notasUsuarioSemelhante[i] + ":"
							+ getEstabelecimentos().get(i) + ":"
							+ usuarioSemelhante);
					// recomendacoes.add(notasUsuarioSemelhante[i] + ":"+
					// getEstabelecimentos().get(i) + ":" + usuarioSemelhante);
				}
			}
			contador += 1;
			if (recomendacoesPorUsuario.size() > 0) {
				Ordena.bubbleSortDec(recomendacoesPorUsuario);
				recomendacoes.addAll(recomendacoesPorUsuario);
			}

		} while ((recomendacoes.size() < r) && (contador < semelhantes.length)
				&& (Integer.valueOf(semelhantes[contador].split(":")[0]) > 0)); 

		String[] recomendacoesAuxiliar = recomendacoes.toString().replace("[",
				"").replace("]", "").split(",");
		// Ordena.bubbleSortDec(recomendacoesAuxiliar);

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

	private String[] geraRecomendacoes(String usuario, int r) throws Exception {
		if (r < 0) {
			throw new Exception("Nao deve ser informado numero negativo.");
		}

		String[] semelhantes = usuariosSemelhantes(usuario);

		// Verifica se o usuario nao tem niguem semelhante
		if (!(Arrays.toString(notasUsuario(usuario)).contains("0"))
				|| Integer.valueOf(semelhantes[0].split(":")[0]) <= 0) {
			return null;
		}

		// Recolhe as notas do usuario atual para comparar com outro usuario.
		Integer[] minhasNotas = notasUsuario(usuario);
		ArrayList<String> recomendacoes = new ArrayList<String>();
		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		String usuarioSemelhante;
		int contador = 0;

		do {
			// Coletando o nome do usuario com maior semelhanca pela ordem
			usuarioSemelhante = semelhantes[contador].split(":")[1];

			// Coletando as notas do usuario semenhante
			Integer[] notasUsuarioSemelhante = notasUsuario(usuarioSemelhante);
			recomendacoesPorUsuario.clear();
			for (int i = 0; i < minhasNotas.length; i++) {
				// Confere se a nota do restaurante n para usuario atual e zero
				// e para o semelhante e positiva
				// Segunda verificacacao e para saber se o restaurante atual nao
				// ja esta na lista
				if ((minhasNotas[i] == 0 && notasUsuarioSemelhante[i] > 0)
						&& (!(recomendacoes.toString()
								.contains(getEstabelecimentos().get(i))))) {
					recomendacoesPorUsuario.add(notasUsuarioSemelhante[i] + ":"
							+ getEstabelecimentos().get(i) + ":"
							+ usuarioSemelhante);
					// recomendacoes.add(notasUsuarioSemelhante[i] + ":"+
					// getEstabelecimentos().get(i) + ":" + usuarioSemelhante);
				}
			}
			contador += 1;
			if (recomendacoesPorUsuario.size() > 0) {
				Ordena.bubbleSortDec(recomendacoesPorUsuario);
				recomendacoes.addAll(recomendacoesPorUsuario);
			}

		} while ((recomendacoes.size() < r) && (contador < semelhantes.length)
				&& (Integer.valueOf(semelhantes[contador].split(":")[0]) > 0)); 

		String[] recomendacoesAuxiliar = recomendacoes.toString().replace("[",
				"").replace("]", "").split(",");
		// Ordena.bubbleSortDec(recomendacoesAuxiliar);

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

	private String[] usuariosSemelhantes(String usuario) throws Exception {
		String[] usuariosSemelhantes = new String[opinioes.size() - 1];
		Integer[] minhasNotas = notasUsuario(usuario);
		int contador = 0;
		Iterator usuarios = opinioes.keySet().iterator();

		while (usuarios.hasNext()) {
			int soma = 0;
			String outroUsuario = (String) usuarios.next();
			if (outroUsuario.equals(usuario))
				continue;
			Integer[] notasOutroUsuario = notasUsuario(outroUsuario);

			for (int i = 2; i < notasUsuario(usuario).length; ++i) {
				soma += minhasNotas[i - 2] * notasOutroUsuario[i - 2];
			}

			usuariosSemelhantes[contador] = soma + ":" + outroUsuario;
			contador += 1;
		}
		Ordena.bubbleSortDec(usuariosSemelhantes);

		return usuariosSemelhantes;
	}

	private String[] usuariosSemelhantes(Integer[] minhasNotas)
			throws Exception {
		String[] usuariosSemelhantes = new String[opinioes.size()];

		int contador = 0;
		Iterator usuarios = opinioes.keySet().iterator();

		while (usuarios.hasNext()) {
			int soma = 0;
			String outroUsuario = (String) usuarios.next();
			Integer[] notasOutroUsuario = notasUsuario(outroUsuario);

			for (int i = 2; i < minhasNotas.length; ++i) {
				soma += minhasNotas[i - 2] * notasOutroUsuario[i - 2];
			}

			usuariosSemelhantes[contador] = soma + ":" + outroUsuario;
			contador += 1;
		}
		Ordena.bubbleSortDec(usuariosSemelhantes);
		return usuariosSemelhantes;
	}

	/**
	 * Verifica se usuário já está cadastrado
	 * @param String - Nome do usuário
	 * @return boolean - true se o usuário já está cadastrado
	 */
	public boolean verificaUsuario(String usuario) {
		return opinioes.keySet().contains(usuario);
	}

}
