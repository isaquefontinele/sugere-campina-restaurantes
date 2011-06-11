/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.TratamentosArquivos;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Projeto.acoes.Ordena;

/**
 * Está classe trata das informações de cada usuário alimentado pelo mapa em seu
 * construtor.
 * 
 * @author Laerton Marques de Figueiredo
 */
public class Usuarios {
	private Map<String, String[]> opinioes;
	private Map<String, Integer[]> opinioesInteiros;
	private Map<String, Integer> notasPositivas;

	/**
	 * Este metodo cria um objeto do tipo usuários.
	 * 
	 * @param opinioes
	 *            Mapa contendo como chave os perfis e Values Array de String
	 *            com os votos de cada perfil.
	 */
	public Usuarios(Map<String, String[]> opinioes) {
		this.opinioes = opinioes;
		criaOpinioesInteiros();
	}
	
	
	private void criaOpinioesInteiros(){
		opinioesInteiros = new  HashMap();
		notasPositivas = new  HashMap();
		Iterator<String> it = (Iterator) this.opinioes.keySet().iterator();
		int nota;
		String user;
		while(it.hasNext()){
			user = it.next();
			int contaNotaPositiva = 0;
			String[] minhasOpinioes = opinioes.get(user);
		 	Integer[] minhasNotasInteiros = new Integer[minhasOpinioes.length -2];
			for (int i = 2; i < minhasOpinioes.length; i++) {
				nota = Integer.valueOf((minhasOpinioes[i].split(":")[0].replace(" ", "")));
				minhasNotasInteiros[i-2] = nota;
				
				if (nota == 0){
					contaNotaPositiva +=1;
				}
			}
			
			notasPositivas.put(user, contaNotaPositiva);
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
	public int numeroNotas(String usuario) {
		
		return notasPositivas.get(usuario);
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
	 * Metodo cria uma Array de string contendo em ordem decrescente os nomes
	 * dos perfis mais semelhantes as notas informadas
	 * 
	 * @param minhasNotas
	 *            Array de notas para comparação
	 * @return Array de String
	 * @throws Exception
	 *             Não é permitido lista vazia ou null.
	 */
	public ArrayList<String> usuariosSemelhantes(Integer[] minhasNotas) throws Exception {
		if (minhasNotas == null) {
			throw new Exception("Não é permitido notas null.");
		}
		if (minhasNotas.length == 0) {
			throw new Exception("Não é permitido lista vazia.");
		}
		ArrayList<String> usuariosSemelhantes = new ArrayList<String>();
		Iterator usuarios = opinioes.keySet().iterator();
		while (usuarios.hasNext()) {
			int soma = 0;
			String outroUsuario = (String) usuarios.next();
			Integer[] notasOutroUsuario = notasUsuario(outroUsuario);
			for (int i = 0; i < minhasNotas.length; ++i) {
				soma += minhasNotas[i] * notasOutroUsuario[i];
			}
			if (soma > 0 ){
				usuariosSemelhantes.add(soma + ":" + outroUsuario);
			}
		}
		if (usuariosSemelhantes.size()> 0){
			Ordena.bubbleSortDec(usuariosSemelhantes);
		}
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
