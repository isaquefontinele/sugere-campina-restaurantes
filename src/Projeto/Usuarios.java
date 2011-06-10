/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Está classe trata das informações de cada usuário alimentado pelo mapa em seu
 * construtor.
 * 
 * @author Laerton Marques de Figueiredo
 */
public class Usuarios {
	private Map<String, String[]> opinioes;
	private Map<String, Integer[]> opinioesInteiros;

	/**
	 * Este metodo cria um objeto do tipo usuários.
	 * 
	 * @param opinioes
	 *            Mapa contendo como chave os perfis e Values Array de String
	 *            com os votos de cada perfil.
	 */
	public Usuarios(Map<String, String[]> opinioes) {
		this.opinioes = opinioes;
		opinioesInteiros = new  HashMap();
		Iterator<String> it = (Iterator) this.opinioes.keySet().iterator();
		String user;
		while(it.hasNext()){
			user = it.next();
			String[] minhasOpinioes = opinioes.get(user);
			Integer[] minhasNotasInteiros = new Integer[minhasOpinioes.length -2];
			for (int i = 2; i < minhasOpinioes.length; i++) {
				minhasNotasInteiros[i-2] = Integer.valueOf((minhasOpinioes[i].split(":")[0].replace(" ", "")));
			}
			opinioesInteiros.put(user, minhasNotasInteiros);
			
		}
	}

	/**
	 * Pega os nomes dos usuários
	 * 
	 * @return Set - Nomes dos usuários do arquivo
	 */
	public Set getUsuarios() {
		return opinioes.keySet();
	}

	/**
	 * Metodo que mostra a quantidade de notas disponíveis por usuario.
	 * 
	 * @return Retorna um inteiro >= 0
	 */
	public int numeroNotas() {
		if ((getUsuarios().toArray()).length > 0) {
			@SuppressWarnings("element-type-mismatch")
			String[] linha = opinioes.get((getUsuarios().toArray())[0]);
			return (linha.length - 2);
		}
		return 0;
	}

	/**
	 * Coleta as notas de um determinado usuário e as retorna em forma de Array
	 * de Integer
	 * 
	 * @param String
	 *            - Nome do usuário
	 * @return Integer[] com as notas do usuário recebido
	 * @throws IOException
	 *             - Lança a Excessão de linhaLeitura()
	 */

	public Integer[] notasUsuario(String usuario) {
//		Integer[] notas = new Integer[numeroNotas()];
//		String[] linhaLeitura = (String[]) opinioes.get(usuario);
//		for (int i = 2; i < linhaLeitura.length; ++i) {
//			String nota = (linhaLeitura[i].split(":")[0].replace(" ", ""));
//			notas[i - 2] = Integer.valueOf(nota);
//		}
		//System.out.println(Arrays.toString(opinioesInteiros.get(usuario)));
		return opinioesInteiros.get(usuario);
	}

	/**
	 * Pega as Opiniões de um determinado usuário
	 * 
	 * @param String
	 *            - Nome do usuário
	 * @return String[] - Opiniões do usuário
	 */
	public String[] getOpinioes(String usuario) {
		return (String[]) opinioes.get(usuario);
	}

	/**
	 * Metodo cria uma Arry de string contendo em ordem decrescente os nomes dos
	 * perfis mais semelhantes ao do usuario informado
	 * 
	 * @param usuario
	 *            Nome do usuário para comparação
	 * @return Array de String
	 * @throws Exception
	 *             Não é permitido usuarios null ou em branco.
	 */
	public String[] usuariosSemelhantes(String usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("Não pode ser informado usuario null.");
		}
		if (usuario.equals("")) {
			throw new Exception("Não pode ser informado usuario ''.");
		}
		
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

	/**
	 * Metodo cria uma Array de string contendo em ordem decrescente os nomes
	 * dos perfis mais semelhantes as notas informadas
	 * 
	 * @param minhasNotas
	 *            Array de notas para comparação
	 * @return Array de String
	 * @throws Exception
	 *             Não é permitido lista vazia ou null.
	 */

	public String[] usuariosSemelhantes(Integer[] minhasNotas) throws Exception {
		if (minhasNotas == null) {
			throw new Exception("Não é permitido notas null.");
		}

		if (minhasNotas.length == 0) {
			throw new Exception("Não é permitido lista vazia.");
		}
		String[] usuariosSemelhantes = new String[opinioes.size()];

		int contador = 0;
		Iterator usuarios = opinioes.keySet().iterator();

		while (usuarios.hasNext()) {
			int soma = 0;
			String outroUsuario = (String) usuarios.next();
			Integer[] notasOutroUsuario = notasUsuario(outroUsuario);

			for (int i = 2; i < minhasNotas.length; ++i) {
				soma += minhasNotas[i - 2] * notasOutroUsuario[i - 2];
			}

			usuariosSemelhantes[contador] = soma + ":" + outroUsuario;
			contador += 1;
		}
		Ordena.bubbleSortDec(usuariosSemelhantes);
		return usuariosSemelhantes;
	}

	/**
	 * Verifica se usuário já está cadastrado
	 * 
	 * @param String
	 *            - Nome do usuário
	 * @return boolean - true se o usuário já está cadastrado
	 */
	public boolean verificaUsuario(String usuario) {
		return opinioes.keySet().contains(usuario);
	}
}
