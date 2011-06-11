package Projeto.TratamentosArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Classe filha de TrataArquivos que manipula e guarda em objetos os dados
 * dos usuários
 * 
 * @author Isaque e Laerton
 * 
 */
public class TrataArquivoOpinioes extends TrataArquivos {
	/**
	 * Construtor da classe TrataArquivoOpinioes
	 * 
	 * @param String
	 *            - Nome do arquivo a ser lido
	 * @throws IOException
	 *             - Arquivo não encontrado
	 */
	public TrataArquivoOpinioes(String nomeDoArquivo) throws IOException {
		super(nomeDoArquivo);

	}
        /**
         * 
         * @return mapa de informações do perfis dos usuários
         * @throws IOException para a abertura e fechamento do arquivo 
         */
	@Override
	public HashMap<String, String[]> recolheDados() throws IOException {
		BufferedReader leitor;
		String linha;
		HashMap<String, String[]> mapa = null;
		int contador = 0;

		super.lerArquivo();
		leitor = new BufferedReader(super.arquivoLido);
		mapa = new HashMap<String, String[]>();
		super.linhaCabecalho = leitor.readLine().split(";");
		while ((linha = leitor.readLine()) != null) {
			String[] dadosLinha = linha.split(";");
			String chave = dadosLinha[1];
			if (chave.equals("")) {
				chave = "Anonimo" + String.valueOf(contador);
				dadosLinha[1] = chave;
				++contador;
			}
			mapa.put(chave, dadosLinha);
		}
		super.fecharArquivo();
		return mapa;

	}


	/**
	 * Adiciona um novo usuário ao arquivo de usuários cadastrados
	 * 
	 * @param String
	 *            - Nome do arquivo onde será gravado o novo usuário
	 * @param String
	 *            - Informações do usuário a ser gravadas no arquivo
	 * @throws IOException
	 *             - Arquivo: não encontrado, Não pode ser lido, Não pode
	 *             Escrever
	 */
	public void appendLinha(String linha) throws IOException {
		try {
			File arquivo = new File(super.getNomeDoArquivo());
			if (arquivoExisteLeEscreve(arquivo)) {
				BufferedWriter escrever = (new BufferedWriter(new FileWriter(
						arquivo, true)));
				escrever.append(linha);
				escrever.close();

			} else {
				throw new IOException("Problema no arquivo");
			}
		} catch (IOException ex) {
			throw new IOException("Arquivo não encontrado");
		}

	}

}
