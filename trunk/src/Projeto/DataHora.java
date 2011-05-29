/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author laerton
 */
public class DataHora {


    public static String getDateHora() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
