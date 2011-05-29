package Projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class ManipulaRestaurante extends ManipulacaoDeDados {

	public ManipulaRestaurante(String nomeDoArquivo) throws IOException {
		super(nomeDoArquivo);
		
	}

	@Override
	public HashMap recolheDados() throws IOException {
		BufferedReader leitor;
		String linha;
		HashMap mapa = null;
			
			super.lerArquivo();
			leitor = new BufferedReader(super.arquivoLido);
			mapa = new HashMap <String , String[]>();
			super.linhaCabecalho = leitor.readLine().split(";");
			while ((linha = leitor.readLine()) != null){
				String[] dadosLinha = linha.split(";");
				String chave = dadosLinha[0];
				mapa.put(chave, dadosLinha);
			}
			super.fecharArquivo();
			return mapa;
		
	}

}
