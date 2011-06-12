package Projeto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author laerton
 */
public enum TiposDeFiltros {
	PALAVRA_CHAVE(
			"<html>Exibe nos sistemas de sugestões somente os estabelecimentos que não contém o termo informado. Este filtro pode ser aplicado mais de uma vez em série.</html>","Palavra-chave"), 
			ENDEREÇO("<html>Exibe nos sistemas de sugestões todos os estabelecimentos que estiverem em seu endereço o termo referenciado. Este filtro pode ser aplicado mais de uma vez em série.</html>","Endereço"),
			TIPO_DE_REFEIÇÃO("<html>Exibe nos sistemas de sugestões todos os estabelecimentos que sirvam o tipo de prato selecionado. Este filtro só pode ser aplicado uma vez.</html>","Tipo de refeição" );
	String tipo;
	String rotulo;

	private TiposDeFiltros(String tipo, String rotulo) {
		this.tipo = tipo;
		this.rotulo = rotulo;
	}
	
	public String getTipo (){
		return tipo;
	}
	
	public String getRotulo(){
		return rotulo;
	}
}
