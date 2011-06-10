/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;



/**
 *
 * @author Laerton e Isaque
 */
public class AcoesEmJanelas implements Runnable {
    private Usuarios usuarios;
    private Estabelecimentos estabelecimentos;
    private SugereCampina sugere;
    private SugerePopulares populares;
    private SugerePorPerfil porPerfil;
    private Integer[] notaRemovida = new Integer[2];
    /**
     * Classe que cuida de metodos especificos das janelas do programa 
     * @param sugere Objeto do tipo sugere
     */
    public AcoesEmJanelas(SugereCampina sugere){
        this.sugere = sugere;
        usuarios = sugere.getUsuarios();
        estabelecimentos = sugere.getEstabelecimentos();
        try {
            montaSugeres();
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
    }

    private void montaSugeres() throws IOException{
        	populares = new SugerePopulares(usuarios,estabelecimentos);
        	porPerfil = new SugerePorPerfil(usuarios,estabelecimentos);
    }
    /**
     * 
     * @return Retorna um Array de String contedo a lista de estbelecimentos mais populares 
     *  
     */
    public String[] getMaisPopulares() {
        String[] lista = null;
        try {
             lista = populares.maisPopulares(estabelecimentos.getEstabelecimentos().size());
        } catch (Exception ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
        return lista;
    }
    /**
     * 
     * @param quantidade Quantidade de opiniões a serem retornadas
     * @return Array de string contendo a lista de estabelecimentos por popularidade somente a quantidade solicitada
     * @throws Exception Não é permitido quantidades invalidas ou < 0
     */
    public String[] getMaisPopulares(Integer quantidade) throws Exception{
        return populares.maisPopulares(quantidade);
    }
    /**
     * 
     * @param notas Recebe um Array de Inteiros com as notas 
     * @param quantidade Quantidade de opiniões a serem retornadas
     * @return Array de string contendo a lista de estabelecimentos por perfil somente a quantidade solicitada
     * @throws Exception Não é permitido quantidades invalidas ou < 0
     */
    public String[] getPorPerfil(Integer[] notas, Integer quantidade) throws Exception{
        return porPerfil.recomendacoes(notas,quantidade);
    }
    
    /**
     * 
     * @param usuario Nome de um usuários. 
     * @param quantidade Quantidade de opiniões a serem retornadas
     * @return Array de string contendo a lista de estabelecimentos por perfil somente a quantidade solicitada
     * @throws Exception Não é permitido quantidades invalidas ou < 0
     */
    
    public String[] getPorPerfil(String usuario, Integer quantidade) throws Exception{
        Integer[] notas = notasUsuario(usuario);
        return porPerfil.recomendacoes(notas,quantidade);
    }
    /**
     * 
     * @param usuario Recebe um String com o nome do usuário.
     * @return retorna um Array de inteiros com as notas do usuário informado
     */
    private Integer[] notasUsuario(String usuario){
        return usuarios.notasUsuario(usuario);
    } 
    
    private  String quantidadeEstabelecimentos (){
        return  String.valueOf( estabelecimentos.getEstabelecimentos().size());
    }
    
    protected  String mensagemIndicacoes() {
		String resposta = null;
		boolean sair = true;
		do {

			resposta = Mensagem.caixaDeEntrada("Quantas indicações deseja?");
			if (resposta != null) {
                                if  (resposta.matches("^[a-zA-ZÃ�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*$")){
                                    Mensagem.exibirMensagem("Deve ser informado somente números.");
                                }else{
                                    if (resposta.equals("") || Integer.valueOf(resposta) <= 0) {
                                    	Mensagem.exibirMensagem("Quantidade inválida");
                                    } else {
					sair = false;
                                    }
                            }
			} else {
				sair = false;
			}

		} while (sair);
		return resposta;
	}
    
    /**
     * Cria uma Array duplo de String contendo informações de estabelecimentos e seu respectivo voto dado por um determinado usuário
     * @param nomeUsuario String contendo o nome do usuario
     * @return Array duplo de String 
     */

        public String[][] povoaTabelaVotos(String nomeUsuario) {
		ArrayList<String> listaEstabelecimentos = estabelecimentos.getEstabelecimentos();
		String voto;
		String[][] itensTabela = new String[listaEstabelecimentos.size()][2];
		if (usuarios.verificaUsuario(nomeUsuario)) {
			String[] opinioes = usuarios.getOpinioes(nomeUsuario);
			for (int i = 0; i < listaEstabelecimentos.size(); i++) {
				itensTabela[i][0] = listaEstabelecimentos.get(i);
				voto = opinioes[i + 2].split(":")[0].trim();
				itensTabela[i][1] = (voto.contains("-") ? voto : " " + voto)
						+ " : " + opinioes[i + 2].split(":")[1].trim();
			}
		} else {
			for (int i = 0; i < listaEstabelecimentos.size(); i++) {
				itensTabela[i][0] = listaEstabelecimentos.get(i);
				itensTabela[i][1] = "0: Não conheço";
			}
		}
		return itensTabela;
	}
        /**
         * Exibe a janela com todas informações de um novo perfil 
         * @param sugere Objeto do tipo sugere
         * @param janela1 Objeto do tipo JanelaAquivo
         */
 public void acionaNovoPerfil(SugereCampina sugere, JanelaArquivo janela1) {
    	String resposta = null;
    	boolean sair = false;
    	do{
    		resposta = Mensagem.caixaDeEntrada("Digite o nome do novo usuário:");
    		if (resposta !=null){
    			if (resposta.equals("")){
    				Mensagem.exibirMensagem("Não é possível criar usuário em branco.");
    			}else{
    				if(usuarios.verificaUsuario(resposta)){
    					Mensagem.exibirMensagem("Usuário já cadastrado.");
    				}else{
    					sair = true;
    				}
    			}

    		}else{
    			sair = true;
    		}
    	}while(!(sair));

    	if (resposta != null){
    	JanelaNovoPerfil janelaNovoPerfil = new JanelaNovoPerfil(resposta, sugere, janela1);
        janelaNovoPerfil.setVisible(true);
    	CentralizaJanela.centralizaJanela(janelaNovoPerfil);
    	}

    }
 /**
  * Este metodo povoa um combobox com a lista de perfis existente
  * @param jComboPerfil Objeto do tipo JComboBox 
  */
 public void montaComboPerfis(JComboBox jComboPerfil){
    Object[] perfisInterno =  usuarios.getUsuarios().toArray();
    	Arrays.sort(perfisInterno);
    	jComboPerfil.removeAllItems();
        for (int i = 0; i < perfisInterno.length; i++) {
        	jComboPerfil.addItem(perfisInterno[i].toString());
		}
 }
 
 private Integer[] removeNota(Integer posicao, Integer[] notas){
     if (notas[posicao]> 0){
         notaRemovida[0] = posicao;
         notaRemovida[1] = notas[posicao];
         notas[posicao] = 0;
     }
     return notas;
 }
 
 private Integer[] retornaNota(Integer[] notas){
     if (notaRemovida[0]!=0){
        notas[notaRemovida[0]] = notaRemovida[1]; 
     }
     return notas;
 }
 
 private boolean contemEmPopulares(String estabelecimento, Integer quantidade) throws Exception{
     if (Arrays.toString(populares.maisPopulares(quantidade)).contains(estabelecimento)){
          return true;
     }
     return  false;
 }
 
 private boolean contemEmPorPerfil(String estabelecimento, Integer quantidade, Integer[] notas) throws Exception{
     
     if (Arrays.toString(porPerfil.recomendacoes(notas, quantidade)).contains(estabelecimento)){
          return true;
     }
   return  false;
 }
 
 private String comparaRecomendacoes(Integer quantidade) throws Exception{
     if (quantidade < 0){
         throw new Exception("Não é permitido quantidade negativa");
     }
     
     String estabelecimento = null;
     Double contadorPerfil = 0.0, contadorPopular = 0.0, contador = 0.0;
     Set conjuntoUsuarios =  usuarios.getUsuarios();
     
     JanelaBarra janelaBarra = new JanelaBarra();
     janelaBarra.setValorMaximoBarra(conjuntoUsuarios.size());
     janelaBarra.setValorPosicao(0);
     janelaBarra.setVisible(true);
     CentralizaJanela.centralizaJanela(janelaBarra);
     ArrayList<String> listaEstabelecimetos = estabelecimentos.getEstabelecimentos();
     Iterator<String> it = conjuntoUsuarios.iterator();
     while(it.hasNext()){
         String nomeUsuario = it.next();
         Integer[] notas = notasUsuario(nomeUsuario);
         janelaBarra.setValorPosicao(janelaBarra.getValorPosicao()+1);
         for (int i = 0; i < notas.length; i++) {
             
             if (notas[i] > 0){
                 estabelecimento = listaEstabelecimetos.get(i);
                 contador +=1;
                 notas = removeNota(i, notas);
                 contadorPopular += (contemEmPopulares(estabelecimento, quantidade))?1:0;
                 contadorPerfil += (contemEmPorPerfil(estabelecimento, quantidade, notas))?1:0;
                 notas = retornaNota(notas);
             }
         }
     }
     janelaBarra.dispose();
     return "Apos a analise conclui-se que para uma pesquisa de " + quantidade + ((quantidade==1)?" opininão ":" opininões " )
            + "obtevi:"+ "\nPor popularidade: " + ((contadorPopular*100)/contador) + "% de acertos.\n"
             + "Por perfil: " + ((contadorPerfil*100)/contador) + "% de acertos";
 }

    @Override
    public void run() {
        String resposta = mensagemIndicacoes();
        if (resposta != null){
        try {
            Mensagem.exibirMensagem(comparaRecomendacoes(Integer.valueOf(resposta)));
        } catch (Exception ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
    }
    }
    
    protected void threadComparaRecomendacoes(){
        AcoesEmJanelas metodo = new AcoesEmJanelas(sugere);
        Thread thered = new Thread(metodo);
        thered.start();
    }
}

        


