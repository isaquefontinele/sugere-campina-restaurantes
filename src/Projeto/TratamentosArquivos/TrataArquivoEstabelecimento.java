package Projeto.TratamentosArquivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe filha de TrataArquivos que manipula e guarda em objetos os dados dos restaurantes
 * @author Isaque
 *
 */
public class TrataArquivoEstabelecimento extends TrataArquivos {
    private ArrayList<String> colunaInicial;
        /**
	 * Construtor da classe TrataArquivos
	 * @param String - Nome do arquivo a ser lido
	 * @throws IOException - Arquivo não encontrado
	 */
	public TrataArquivoEstabelecimento(String nomeDoArquivo) throws IOException {
		super(nomeDoArquivo);
                colunaInicial = new ArrayList<String>();
		
	}
        /**
         * 
         * @return mapa de informações do perfis dos usuários
         * @throws IOException para a abertura e fechamento do arquivo 
         */
	@Override
	public HashMap<String,String[]> recolheDados() throws IOException {
		BufferedReader leitor;
		String linha;
		HashMap<String,String[]> mapa = null;
			
			super.lerArquivo();
			leitor = new BufferedReader(super.arquivoLido);
			mapa = new HashMap <String , String[]>();
			super.linhaCabecalho = leitor.readLine().split(";");
			while ((linha = leitor.readLine()) != null){
				String[] dadosLinha = linha.split(";");
				String chave = dadosLinha[0];
                                colunaInicial.add(chave);
                                mapa.put(chave, dadosLinha);
			}
			super.fecharArquivo();
			return mapa;
		
	}

        public ArrayList<String> getcolunaInicial(){
            return colunaInicial;
        }


}
