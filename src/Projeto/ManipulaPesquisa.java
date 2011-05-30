package Projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
/**
 * Classe filha de ManipulacaoDeDados que manipula e guarda em objetos os dados dos usuários
 * @author Isaque e Laerton
 *
 */
public class ManipulaPesquisa extends ManipulacaoDeDados {
	/**
	 * Construtor da classe ManipulaPesquisa
	 * @param String - Nome do arquivo a ser lido
	 * @throws IOException - Arquivo não encontrado
	 */
	public ManipulaPesquisa(String nomeDoArquivo) throws IOException {
		super(nomeDoArquivo);

	}

	@Override
	public HashMap recolheDados() throws IOException {
		BufferedReader leitor;
		String linha;
		HashMap mapa = null;
                String zeros = "";
		int contador = 0;
		

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
//                        if (String.valueOf(contador).length() > 1){
//                            for (int i = 0; i < String.valueOf(contador).length() ; i++) {
//                                zeros += "0";
//                            }
//                        }
//
//                        Set chaves = mapa.keySet();
//
//                        String [] linhaTemporaria = (String[]) mapa.get("Anonimo1");
//                        mapa.keySet().remove("Anonimo1");
//                        mapa.put("Anonimo01", linhaTemporaria);

			return mapa;
		
	}
	/**
	 * Verifica se um arquivo existe, pode ser lido e pode-se escrever
	 * @param File - Recebe um arquivo
	 * @return boolean - Retorna true se os três requisitos forem satisfeitos
	 */
    public boolean arquivoExisteLeEscreve(File arquivo) {
		return arquivo.exists() && arquivo.canRead() && arquivo.canWrite();
	}
    /**
     * Adiciona um novo usuário ao arquivo de usuários cadastrados
     * @param String - Nome do arquivo onde será gravado o novo usuário
     * @param String - Informações do usuário a ser gravadas no arquivo
     * @throws IOException - Arquivo: não encontrado, Não pode ser lido, Não pode Escrever
     */
	public void appendUsuario(String linha) throws IOException {
		try {
			File arquivo = new File(super.getNomeDoArquivo());
			if (arquivoExisteLeEscreve(arquivo)) {
				BufferedWriter escrever = (new BufferedWriter(new FileWriter(arquivo,true)));
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
