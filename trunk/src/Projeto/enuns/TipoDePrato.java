/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.enuns;

/**
 *
 * @author laerton
 */
public enum TipoDePrato {
    SELF_SERVICE ("Self service"), A_AL_CARTE("A al carte"), PRATO_FEITO("Prato feito");
    
    String tipo;

	private TipoDePrato(String tipo) {
		this.tipo = tipo;
	}
    
	public String getTipo (){
		return tipo;
	}

	
}
