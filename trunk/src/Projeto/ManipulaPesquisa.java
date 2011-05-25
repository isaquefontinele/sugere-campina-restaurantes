package Projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ManipulaPesquisa extends ManipulacaoDeDados {

	public ManipulaPesquisa(String nomeDoArquivo) throws IOException {
		super(nomeDoArquivo);

	}

	@Override
	public HashMap recolheDados() throws IOException {
		BufferedReader leitor;
		String linha;
		HashMap mapa = null;
		int contador = 0;
		try {

			super.lerArquivo();
			leitor = new BufferedReader(super.arquivoLido);
			mapa = new HashMap<String, String[]>();
			super.linhaCabecalho = leitor.readLine().split(";");
			while ((linha = leitor.readLine()) != null) {
				String[] dadosLinha = linha.split(";");
				String chave = dadosLinha[1];
				if (chave.equals("")){
					chave = "Anonimo" + String.valueOf(contador);
					dadosLinha[1] = chave;
					++contador; 
				}
				mapa.put(chave, dadosLinha);
			}
			super.fecharArquivo();
		} finally {
			return mapa;
		}
	}

	public void gravarDados() {

	}

}
