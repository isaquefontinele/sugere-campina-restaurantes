package Projeto;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public abstract class ManipulacaoDeDados {

	private String nomeDoArquivo; // Por endereco completo
	protected FileReader arquivoLido;
	private Mensagem mensagem = new Mensagem();
	protected String[] linhaCabecalho; 
	
	public ManipulacaoDeDados(String nomeDoArquivo) throws IOException {
		this.nomeDoArquivo = nomeDoArquivo;
		}

	protected void lerArquivo() throws IOException {
		try {
			arquivoLido = new FileReader(nomeDoArquivo);
		} catch (IOException ex) {
			mensagem.exibirMensagem(ex.getMessage());
		}
	}

	protected void fecharArquivo() throws IOException {
		try{
			arquivoLido.close();
		}
		catch (IOException ex) {
			mensagem.exibirMensagem(ex.getMessage());
		}
		
	}
	
	public String[] getLinhaCabecalho() {
		return linhaCabecalho;
	}

	public abstract HashMap recolheDados() throws IOException;

}
