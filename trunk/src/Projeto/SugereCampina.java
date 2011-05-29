package Projeto;

import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SugereCampina {
	private Map opinioes;
	private Map estabelecimentos;
	private String[] notasGlobais;
	private String[] mediasGlobais;
	private ManipulaPesquisa mOpinioes;
	private ManipulaRestaurante mEstabelecimentos;
	private String novoUsuario;
	private String[] novasPreferencias;

	public SugereCampina(ManipulaPesquisa mOpinioes,
			ManipulaRestaurante mEstabelecimentos) throws IOException {
		this.mOpinioes = mOpinioes;
		this.mEstabelecimentos = mEstabelecimentos;
		opinioes = mOpinioes.recolheDados();
		estabelecimentos = mEstabelecimentos.recolheDados();
		mediasGlobais = new String[estabelecimentos.size()];
		notasGlobais = new String[estabelecimentos.size()];

	}

	public void addPreferencia(int index ,String valor ){
		
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
        public void criarPerfil(String novoUsuario) throws Exception {
			if (!(verificaUsuario(novoUsuario))) {
				throw new Exception("Usuario nao existe");
			}
			this.novoUsuario = novoUsuario;
			novasPreferencias = new String[estabelecimentos.size()];
			Arrays.fill(novasPreferencias, "0");
		}

	@SuppressWarnings("unchecked")
public ArrayList<String> getEstabelecimentos() {
	String[] linhaCabecalho = mOpinioes.getLinhaCabecalho();
	ArrayList<String> listaEstabelecimentos = new ArrayList<String>();
	for (int i = 2; i < linhaCabecalho.length; i++) {
		listaEstabelecimentos.add(linhaCabecalho[i]);
	}

	return listaEstabelecimentos;

}

	public String[] getMediasGlobais() throws Exception {
		coletaMedias();
		return mediasGlobais;
	}
	
	public String[] getNotasGlobais() throws Exception {
		coletaMedias();
		return notasGlobais;
	}

	public String[] getOpinioes (String usuario){
		return(String[]) opinioes.get(usuario);
	}

	public Set getPerfis(){
            return opinioes.keySet();
        }
    

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

	public Integer[] notasUsuario(String usuario) throws IOException {
		Integer[] notas = new Integer[estabelecimentos.size()];
		String[] linhaLeitura = (String[]) opinioes.get(usuario);
		for (int i = 2; i < linhaLeitura.length; ++i) {
			String nota = (linhaLeitura[i].split(":")[0].replace(" ", ""));
			notas[i - 2] = Integer.valueOf(nota);
		}
		return notas;
	}
	public String[] recomendacoes (Integer[] minhasNotas, int r) throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(minhasNotas, r);
		
		for (int i = 0; i < recomendacoesInternas.length; i++) {
                        StringBuilder linha = new StringBuilder();
                        Formatter fm = new Formatter(linha);
                        fm.format("%3d° lugar -  %s", (i + 1), recomendacoesInternas[i].split(":")[1]);
			recomendacoesInternas[i] =  linha.toString();
			
		}
		return recomendacoesInternas;
	}

        public String[] recomendacoes (String usuario, int r) throws Exception {
		String[] recomendacoesInternas = geraRecomendacoes(usuario, r);

		for (int i = 0; i < recomendacoesInternas.length; i++) {
                        StringBuilder linha = new StringBuilder();
                        Formatter fm = new Formatter(linha);
                        fm.format("%3d° lugar -  %s", (i + 1), recomendacoesInternas[i].split(":")[1]);
			recomendacoesInternas[i] =  linha.toString();

		}
		return recomendacoesInternas;
	}
        
        private String[] geraRecomendacoes(Integer[] minhasNotas, int r) throws Exception {
		if (r < 0){
			throw new Exception("Nao deve ser informado numero negativo.");
		}

		String[] semelhantes = usuariosSemelhantes(minhasNotas);

		//Verifica se o usuario nao notas zero
		if (!(Arrays.toString(minhasNotas).contains("0"))) {
			return null;
		}


		//Recolhe as notas do usuario atual para comparar com outro usuario.
		//Integer[] minhasNotas = notasUsuario(usuario);
		ArrayList<String> recomendacoes = new ArrayList<String>();
		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		String usuarioSemelhante;
		int contador = 0;

		do {
			//Coletando o nome do usuario com maior semelhanca pela ordem
			usuarioSemelhante = semelhantes[contador].split(":")[1];

			//Coletando as notas do usuario semenhante
			Integer[] notasUsuarioSemelhante = notasUsuario(usuarioSemelhante);
			recomendacoesPorUsuario.clear();
			for (int i = 0; i < minhasNotas.length; i++) {
				//Confere se a nota do restaurante n para usuario atual e zero e para o semelhante e positiva
				//Segunda verificacacao e para saber se o restaurante atual nao ja esta na lista
				if ((minhasNotas[i] == 0  ) && (!(recomendacoes.toString().contains(getEstabelecimentos().get(i))))) {
					recomendacoesPorUsuario.add(notasUsuarioSemelhante[i] + ":"+ getEstabelecimentos().get(i) + ":" + usuarioSemelhante);
					//recomendacoes.add(notasUsuarioSemelhante[i] + ":"+ getEstabelecimentos().get(i) + ":" + usuarioSemelhante);
				}
			}
			contador += 1;
			if (recomendacoesPorUsuario.size()> 0){
				Ordena.bubbleSortDec(recomendacoesPorUsuario);
				recomendacoes.addAll(recomendacoesPorUsuario);
			}

		} while ((recomendacoes.size() < r) && (contador < semelhantes.length) && (Integer.valueOf(semelhantes[contador].split(":")[0]) > 0)); //Problema ta aqui.


		String[] recomendacoesAuxiliar = recomendacoes.toString().replace("[", "").replace("]", "").split(",");
		//Ordena.bubbleSortDec(recomendacoesAuxiliar);

		contador = 0;
		if (r < recomendacoesAuxiliar.length){
			String[] recomendacoesDefinitivas = new String[r];
			for (int i = 0; i < r; ++i) {
				recomendacoesDefinitivas[i] = recomendacoesAuxiliar[i];
			}
			return recomendacoesDefinitivas;
		}
		return recomendacoesAuxiliar;
	}

	private String[] geraRecomendacoes(String usuario, int r) throws Exception {
		if (r < 0){
			throw new Exception("Nao deve ser informado numero negativo.");
		}
		
		String[] semelhantes = usuariosSemelhantes(usuario);
		
		//Verifica se o usuario nao tem niguem semelhante
		if (!(Arrays.toString(notasUsuario(usuario)).contains("0"))
				|| Integer.valueOf(semelhantes[0].split(":")[0]) <= 0) {
			return null;
		}
		
		
		//Recolhe as notas do usuario atual para comparar com outro usuario.
		Integer[] minhasNotas = notasUsuario(usuario);
		ArrayList<String> recomendacoes = new ArrayList<String>();
		ArrayList<String> recomendacoesPorUsuario = new ArrayList<String>();
		String usuarioSemelhante;
		int contador = 0;
		
		do {
			//Coletando o nome do usuario com maior semelhanca pela ordem
			usuarioSemelhante = semelhantes[contador].split(":")[1];
			
			//Coletando as notas do usuario semenhante
			Integer[] notasUsuarioSemelhante = notasUsuario(usuarioSemelhante);
			recomendacoesPorUsuario.clear();
			for (int i = 0; i < minhasNotas.length; i++) {
				//Confere se a nota do restaurante n para usuario atual e zero e para o semelhante e positiva 
				//Segunda verificacacao e para saber se o restaurante atual nao ja esta na lista
				if ((minhasNotas[i] == 0 && notasUsuarioSemelhante[i] > 0 ) && (!(recomendacoes.toString().contains(getEstabelecimentos().get(i))))) {
					recomendacoesPorUsuario.add(notasUsuarioSemelhante[i] + ":"+ getEstabelecimentos().get(i) + ":" + usuarioSemelhante);	
					//recomendacoes.add(notasUsuarioSemelhante[i] + ":"+ getEstabelecimentos().get(i) + ":" + usuarioSemelhante);
				}
			}
			contador += 1;
			if (recomendacoesPorUsuario.size()> 0){
				Ordena.bubbleSortDec(recomendacoesPorUsuario);
				recomendacoes.addAll(recomendacoesPorUsuario);
			}
			
		} while ((recomendacoes.size() < r) && (contador < semelhantes.length) && (Integer.valueOf(semelhantes[contador].split(":")[0]) > 0)); //Problema ta aqui.
		
		
		String[] recomendacoesAuxiliar = recomendacoes.toString().replace("[", "").replace("]", "").split(",");
		//Ordena.bubbleSortDec(recomendacoesAuxiliar);
	
		contador = 0;
		if (r < recomendacoesAuxiliar.length){
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

        private String[] usuariosSemelhantes(Integer[] minhasNotas) throws Exception {
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
	
	public boolean verificaUsuario(String usuario) {
		return opinioes.keySet().contains(usuario);
	}

}
