/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;

import java.io.IOException;

import Projeto.Janelas.SugereCampinaAplication;
import Projeto.acoes.CentralizaJanela;



/**
 *
 * @author laerton
 */
public class Run {
    private static SugereCampinaAplication programa;
	
	public static void main(String[] args) throws IOException {
		programa = new SugereCampinaAplication();
		programa.setVisible(true);
                CentralizaJanela.centralizaJanela(programa);
	}
}
