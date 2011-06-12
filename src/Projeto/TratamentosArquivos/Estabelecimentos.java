/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.TratamentosArquivos;

import Projeto.TratamentosArquivos.TrataArquivoEstabelecimento;
import Projeto.acoes.Mensagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 *
 * @author laerton
 */
public class Estabelecimentos {
    private HashMap<String,String[]> estabelecimentos;
    private TrataArquivoEstabelecimento arq;
    private HashSet<String> tiposPratos;
    /**
     * Classe trata das informações de estabelecimentos obtido pelo objeto TrataArquivosEstabelecimentos recebido em seu construtor
     * @param arq Objeto do tipo TrataArquivosEstabelecimentos.
     */
    public Estabelecimentos(TrataArquivoEstabelecimento arq){
        this.arq = arq;
        tiposPratos = new HashSet<String>();
        try {
            this.estabelecimentos = this.arq.recolheDados();
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
        //geraSetRefeicoes();
        
    }
//    private void geraSetRefeicoes(){
//        java.util.Iterator<String> it = (java.util.Iterator<String>) estabelecimentos.keySet().iterator();
//        while(it.hasNext()){
//        	String informacao =  estabelecimentos.get(it.next())[2];
//        	tiposPratos.add(informacao);
//        }
//
//    }
    
//    /**
//     * Metdodo que baseado nos estabeleciemntos recebido do arquivo de entrada retorna quais tipos de refeicões estão disponíveis.
//     * @return Array de String contendo os tipos de refeicões servidas.
//     */
//
//    public String[] getTiposDeRefeicoes(){
//    	String[] lista = new String[tiposPratos.size()];
//    	java.util.Iterator<String> it = (java.util.Iterator<String>) tiposPratos.iterator();
//    	int contador = 0;
//    	while(it.hasNext()){
//
//    		lista[contador]= it.next();
//    		contador +=1;
//    	}
//
//        return lista;
//    }
        /**
	 * Gera um ArrayList com o nome dos Restaurantes
	 * @return ArrayList - Nomes dos estabelecimentos
	 */
    public ArrayList<String> getEstabelecimentos (){
        return arq.getcolunaInicial();
    }
    /**
     * 
     * @param estabelecimento String contendo o nome do estabelecimento
     * @return String contendo o tipo de estbelecimento
     */
    public String getTipoEstabelecimento(String estabelecimento){
        
        return this.estabelecimentos.get(estabelecimento)[2];
    }
    /**
     * 
     * @param estabelecimento String contendo o nome do estabelecimento
     * @return String contendo o endereço de estbelecimento
     */
    public String getEndereco(String estabelecimento){
        return this.estabelecimentos.get(estabelecimento)[1]; 
    }
    
    
    
}
