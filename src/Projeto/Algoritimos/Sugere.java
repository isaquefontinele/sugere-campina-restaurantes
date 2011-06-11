package Projeto.Algoritimos;


import java.io.IOException;
import java.util.ArrayList;

import Projeto.TratamentosArquivos.Estabelecimentos;
import Projeto.TratamentosArquivos.Usuarios;

/**
 * Classe com os algoritmos de recomendações
 * 
 * @author Isaque e Laerton
 * 
 */
public class Sugere {
	
	private Usuarios usuarios;
	private Estabelecimentos estabelecimentos;

	/**
	 * Construtor da Classe SugereCampina
	 * 
	 * @param Objeto
	 *            do tipo TrataArquivoOpinioes
	 * @param Objeto
	 *            do tipo TrataArquivoEstabelecimento
	 * @throws IOException
	 *             - Arquivo inválido
	 */
	
	public Sugere(Usuarios usuarios, Estabelecimentos estabelecimentos)
			throws IOException {

		this.usuarios = usuarios;
		this.estabelecimentos = estabelecimentos;

	}
	protected int getNumeroDeNotasUsuarios(String usuario) {
		return usuarios.numeroNotas(usuario);
	}
        /**
         * 
         * @return Objeto do tipo Usuario 
         */

	public Usuarios getUsuarios() {
		return usuarios;
	}
        /**
         * 
         * @return Objeto do tipo Estabelecimento 
         */

	public Estabelecimentos getEstabelecimentos() {
		return estabelecimentos;
	}
        
        /**
         * 
         * @param notas Recebe um array de inteiros para analise
         * @return Uma lista de usuarios em ordem decrescente de semelhantes
         * @throws Exception 
         */

	public ArrayList<String> usuariosSemelhantes(Integer[] notas) throws Exception {
		return usuarios.usuariosSemelhantes(notas);
	}
        /**
         * 
         * @param usuario
         * @return
         * @throws Exception 
         */

	public Integer[] notasUsuario(String usuario) {
		return usuarios.notasUsuario(usuario);
	}
        
        public ArrayList<String> listaEstabelecimentos(){
           return estabelecimentos.getEstabelecimentos();
        }
        

}
