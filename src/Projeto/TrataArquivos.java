package Projeto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**
 * Classe mãe abstrata para extrair dados de arquivos
 * @author Isaque e Laerton
 */
public abstract class TrataArquivos {

	private String nomeDoArquivo; // Por endereco completo
	protected FileReader arquivoLido;
	protected String[] linhaCabecalho; 
	/**
	 * Construtor da classe TrataArquivos
	 * @param String - Recebe o nome de um arquivo dado pelo usuário
	 * @throws IOException - Arquivo não encontrado
	 */
	public TrataArquivos(String nomeDoArquivo) throws IOException {
		this.nomeDoArquivo = nomeDoArquivo;
		}

	protected void fecharArquivo() throws IOException {
			arquivoLido.close();
	}

	/**
	 * Verifica se um arquivo existe, pode ser lido e pode-se escrever
	 *
	 * @param File
	 *            - Recebe um arquivo
	 * @return boolean - Retorna true se os três requisitos forem satisfeitos
	 */
	public boolean arquivoExisteLeEscreve(File arquivo) {
		return arquivo.exists() && arquivo.canRead() && arquivo.canWrite();
	}
	/**
	 * Método para pegar a primeira linha do arquivo
	 * @return String[] - Primeira linha do arquivo
	 */
	public String[] getLinhaCabecalho() {
		return linhaCabecalho;
	}
        /**
         * 
         * @return Retorna o nome do arquivo  
         */
        public String getNomeDoArquivo(){
            return nomeDoArquivo;
        }
        
	protected void lerArquivo() throws IOException {
			arquivoLido = new FileReader(nomeDoArquivo);
                       
	}
	/**
	 * Extrair os dados dos usuários do arquivo que será recebido em ManipulaPesquisa ou ManipulaRestaurante
	 * @return HashMap - Informações extraídas do arquivo
	 * @throws IOException - Arquivo não encontrado
	 */
	public abstract HashMap<String, String[]> recolheDados() throws IOException;

}
