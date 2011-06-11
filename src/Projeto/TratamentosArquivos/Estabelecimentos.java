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

/**
 *
 * @author laerton
 */
public class Estabelecimentos {
    private HashMap<String,String[]> estabelecimentos;
    private TrataArquivoEstabelecimento arq;
    /**
     * Classe trata das informações de estabelecimentos obtido pelo objeto TrataArquivosEstabelecimentos recebido em seu construtor
     * @param arq Objeto do tipo TrataArquivosEstabelecimentos.
     */
    public Estabelecimentos(TrataArquivoEstabelecimento arq){
        this.arq = arq;
        try {
            this.estabelecimentos = this.arq.recolheDados();
        } catch (IOException ex) {
            Mensagem.exibirMensagem(ex.getMessage());
        }
        
    }
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
