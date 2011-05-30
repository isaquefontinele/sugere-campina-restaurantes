package Projeto;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**
 * Classe mãe abstrata para extrair dados de arquivos
 * @author Isaque e Laerton
 */
public abstract class ManipulacaoDeDados {

	private String nomeDoArquivo; // Por endereco completo
	protected FileReader arquivoLido;
	private Mensagem mensagem = new Mensagem();
	protected String[] linhaCabecalho; 
	/**
	 * Construtor da classe ManipulacaoDeDados
	 * @param String - Recebe o nome de um arquivo dado pelo usuário
	 * @throws IOException - Arquivo não encontrado
	 */
	public ManipulacaoDeDados(String nomeDoArquivo) throws IOException {
		this.nomeDoArquivo = nomeDoArquivo;
		}

	protected void fecharArquivo() throws IOException {
			arquivoLido.close();
	}
	/**
	 * Método para pegar a primeira linha do arquivo
	 * @return String[] - Primeira linha do arquivo
	 */
	public String[] getLinhaCabecalho() {
		return linhaCabecalho;
	}

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
	public abstract HashMap recolheDados() throws IOException;

}
