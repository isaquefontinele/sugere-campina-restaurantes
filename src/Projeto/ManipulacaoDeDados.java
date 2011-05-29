package Projeto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class ManipulacaoDeDados {

	private String nomeDoArquivo; // Por endereco completo
	protected FileReader arquivoLido;
	private Mensagem mensagem = new Mensagem();
	protected String[] linhaCabecalho; 
	
	public ManipulacaoDeDados(String nomeDoArquivo) throws IOException {
		this.nomeDoArquivo = nomeDoArquivo;
		}

	protected void fecharArquivo() throws IOException {
			arquivoLido.close();
	}

	public String[] getLinhaCabecalho() {
		return linhaCabecalho;
	}

        public String getNomeDoArquivo(){
            return nomeDoArquivo;
        }
	protected void lerArquivo() throws IOException {
			arquivoLido = new FileReader(nomeDoArquivo);
                       
	}

	public abstract HashMap recolheDados() throws IOException;

}
