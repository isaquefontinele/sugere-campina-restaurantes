package Projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SugereCampina {
	private Map opinioes;
	private Map estabelecimentos;
	private Map mediasGlobais;
	private String[] mediasG;
	private ManipulaPesquisa mOpinioes;
	private ManipulaRestaurante mEstabelecimentos;

	public SugereCampina(ManipulaPesquisa mOpinioes,
			ManipulaRestaurante mEstabelecimentos) throws IOException {
		this.mOpinioes = mOpinioes;
		this.mEstabelecimentos = mEstabelecimentos;
		opinioes = mOpinioes.recolheDados();
		estabelecimentos = mEstabelecimentos.recolheDados();
		mediasGlobais = new HashMap<String, Double>();
		mediasG = new String[estabelecimentos.size()];
	}

	private void coletaMedias() {
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
			// mediasGlobais.put(estabelecimentos.get(i),
			// notas[i]/opinioes.size());
			mediasG[i] = (notas[i] / opinioes.size() + ": " + estabelecimentos
					.get(i));
		}
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

	public String[] getMediasGlobais() {
		coletaMedias();
		return mediasG;
	}

	private Integer[] notasUsuario(String usuario) throws IOException {
		Integer[] notas = new Integer[estabelecimentos.size()];

		String[] linhaLeitura = (String[]) opinioes.get(usuario);

		for (int i = 2; i < linhaLeitura.length; ++i) {
			String nota = (linhaLeitura[i].split(":")[0].replace(" ", ""));
			notas[i - 2] = Integer.valueOf(nota);
		}
		return notas;
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

	public String[] recomendacoes (String usuario, int R) throws Exception{
		String[] semelhantes = usuariosSemelhantes(usuario);
		if (!(Arrays.toString(notasUsuario(usuario)).contains("0")) || Integer.valueOf(semelhantes[0].split(":")[0]) <= 0){
			return null;
		}
		ArrayList<String> recomendacoes = new ArrayList<String>();
		
		String[] recomendacoesDefinitivas = new String[R];
		Integer[] minhasNotas = notasUsuario(usuario);
		
		String usuarioSemelhante;
		
		int contador = 0;
		do {
			System.out.println(recomendacoes.size());
			usuarioSemelhante = semelhantes[contador].split(":")[1];
			Integer[] notasUsuarioSemelhante = notasUsuario(usuarioSemelhante);
			
			for (int i = 0; i < minhasNotas.length; i++) {
				if (minhasNotas[i] == 0 && notasUsuarioSemelhante[i] > 0 && !(recomendacoes.contains(getEstabelecimentos().get(i)))){
					
					recomendacoes.add(notasUsuarioSemelhante[i] + ":" + getEstabelecimentos().get(i));
				}
			}
			contador += 1;
			
		} while (recomendacoes.size() < R || contador >= semelhantes.length);
			
		String[] recomendacoesAuxiliar = recomendacoes.toString().replace("[", "").replace("]", "").split(",");
		Ordena.bubbleSortDec(recomendacoesAuxiliar);
		
		if (recomendacoesAuxiliar.length > R){
			for (int i = 0; i < recomendacoesDefinitivas.length; i++) {
				recomendacoesDefinitivas[i] = recomendacoesAuxiliar[i];
			}
		}
		else {
			recomendacoesDefinitivas = recomendacoesAuxiliar;
		}
	
		
		return recomendacoesDefinitivas;
	}
}
