/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Classe para pegar a data e a hora do sistema
 * @author Laerton e Isaque
 */
public class DataHora {

	/**
	 * Pega a data e a hora do sistema
	 * @return String - Data e hora do sistema
	 */
    public static String getDateHora() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
