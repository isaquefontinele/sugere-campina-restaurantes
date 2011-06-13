package Projeto.acoes;

import Projeto.TratamentosArquivos.Estabelecimentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.text.html.HTMLDocument.Iterator;
/**
 * Classe responsável pela ordenação dos dados através do algoritmo Bubble Sort
 * @author Laerton
 *
 */
public class Ordena {
	/**
	 * Recebe um Array de string com as notas dos usuários, que será ordenado pelas notas correspondentes
	 * @param String[] - Notas dos usuários
	 * @throws Exception - Notas inválidas, Array Vazio
	 */
	 public static void bubbleSort(String[] valores) throws Exception {
		 	if (valores.length == 0){
		 		throw new Exception("Não é permitido um array vazio.");
		 	}
		 	
		 	if (!(valores[0].contains(":"))){
		 		throw new Exception("Tem que haver ':' (dois pontos), separando os dois campos.");
		 	}
		 	
		 	if (valores[0].split(":")[0].matches("^[a-zA-ZÃ�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*$")){
		 		throw new Exception("No primeiro campo só podem haver caracteres numéricos.");
		 	}
		 	
	        for (int i = valores.length; i >= 1; i--) {
	            for (int j = 1; j < i; j++) {
	            	if (Double.valueOf(valores[j-1].split(":")[0]) > Double.valueOf(valores[j].split(":")[0])) { 
	            		String aux = valores[j];
	            		valores[j] = valores[j-1];
	            		valores[j-1] = aux;
	                }
	            }
	        }
	   
	    }
	 /**
	  * Recebe um ArrayList com as notas dos usuários, que será ordenado pelas notas correspondentes
	  * @param String[] - Notas dos usuários
	  * @throws Exception - Notas inválidas, Array Vazio
	  */
	 public static void bubbleSort(ArrayList<String> valores) throws Exception {
		 	if (valores.size() == 0){
		 		throw new Exception("Não é permitido um array vazio.");
		 	}
		 	
		 	if (!(valores.get(0).contains(":"))){
		 		throw new Exception("Tem que haver ':' (dois pontos), separando os dois campos.");
		 	}
		 	
		 	if (valores.get(0).split(":")[0].matches("^[a-zA-ZÃ�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*$")){
		 		throw new Exception("No primeiro campo só podem haver caracteres numéricos.");
		 	}
		 	
	        for (int i = valores.size(); i >= 1; i--) {
	            for (int j = 1; j < i; j++) {
	            	if (Double.valueOf(valores.get(j-1).split(":")[0]) > Double.valueOf(valores.get(j).split(":")[0])) { 
	            		String aux = valores.get(j);
	            		valores.set(j, valores.get(j-1));
	            		valores.set(j-1, aux);
	                }
	            }
	        }
	   
	    }
	 /**
	  * Recebe um Array de string com as notas dos usuários, que será ordenado pelas notas correspondentes em ordem decrescente
	  * @param String[] - Notas dos usuários
	  * @throws Exception - Notas inválidas, Array Vazio
	  */
         public static void bubbleSortDec(String[] valores) throws Exception {
		 	if (valores.length == 0){
		 		throw new Exception("Não é permitido um array vazio.");
		 	}
		 	
		 	if (!(valores[0].contains(":"))){
		 		throw new Exception("Tem que haver ':' (dois pontos), separando os dois campos.");
		 	}
		 	
		 	if (valores[0].split(":")[0].matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
		 		throw new Exception("No primeiro campo só podem haver caracteres numéricos.");
		 	}
		 	
	        for (int i = valores.length; i >= 1; i--) {
	            for (int j = 1; j < i; j++) {
	            	if (Double.valueOf(valores[j-1].split(":")[0]) < Double.valueOf(valores[j].split(":")[0])) { 
	            		String aux = valores[j];
	            		valores[j] = valores[j-1];
	            		valores[j-1] = aux;
	                }
	            }
	        }
	   
	    }

	 /**
	  * Recebe um ArrayList com as notas dos usuários, que será ordenado pelas notas correspondentes em ordem decrescente
	  * @param String[] - Notas dos usuários
	  * @throws Exception - Notas inválidas, Array Vazio
	  */
	 public static void bubbleSortDec(ArrayList<String> valores) throws Exception {
		 	if (valores.size() == 0){
		 		throw new Exception("Não é permitido um array vazio.");
		 	}
		 	
		 	if (!(valores.get(0).contains(":"))){
		 		throw new Exception("Tem que haver ':' (dois pontos), separando os dois campos.");
		 	}
		 	
		 	if (valores.get(0).split(":")[0].matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
		 		throw new Exception("No primeiro campo só podem haver caracteres numéricos.");
		 	}
		 	
	        for (int i = valores.size(); i >= 1; i--) {
	            for (int j = 1; j < i; j++) {
	            	if (Double.valueOf(valores.get(j-1).split(":")[0]) < Double.valueOf(valores.get(j).split(":")[0])) { 
	            		String aux = valores.get(j);
	            		valores.set(j, valores.get(j-1));
	            		valores.set(j-1, aux);
	                }
	            }
	        }
	   
	
	 }

        
	private static String[] ordenaPorOrdemAlfabetica(String[] strings) {

		String stringsOrdenadas[] = new String[strings.length];

		Arrays.sort(strings);

		stringsOrdenadas = strings.clone();
		return stringsOrdenadas;
	}

	
	private static String[] retiraSubstring(String[] strings, String separador) {

		String stringsFormatadas[] = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {
			String string = strings[i];

			int indiceDoSeparador = string.indexOf(separador);

			String novaString = string.substring(indiceDoSeparador + 1, string.length());
			novaString = novaString.trim();

			stringsFormatadas[i] = novaString;

		}

		return stringsFormatadas;
	}

	/**
	 * Ordena as sugestoes de restaurante afabeticamente.
	 * Retira a ordenaçao de colocaçao para ordenar pela ordem alfabetica.
	 *
	 * @param strings Um array de strings contendo as informacoes dos restaurantes.
	 * @return A array com o nome dos restaurantes ordenados pela ordem alfabetica.
	 */

	public static String[] ordenaSugestoesAlfabeticamente(String[] strings) {
		String separador = "-";
                return ordenaPorOrdemAlfabetica(retiraSubstring(strings, separador));
	}

	public static String[] ordenaTipoDePrato(String[] lista, Estabelecimentos estabelecimentos){
            String[] novaLista = new String[(lista.length + estabelecimentos.getTiposDeRestaurantes().size())];
            HashSet<String> tiposDePratos = estabelecimentos.getTiposDeRestaurantes();
            java.util.Iterator<String> it = (java.util.Iterator<String>)tiposDePratos.iterator();
            String estabelecimentoAtual;
            
            int contador = 0;
            while (it.hasNext()){
                novaLista[contador] = it.next();
                contador +=1;
            }
            
            for (int i = (tiposDePratos.size()); i < novaLista.length; i++) {
                
            	estabelecimentoAtual = lista[i - (tiposDePratos.size())].split("-")[1].replaceFirst("  ", "");
            	System.out.println(estabelecimentoAtual);
                novaLista[i] = estabelecimentos.getTipoEstabelecimento(estabelecimentoAtual) + ":" + estabelecimentoAtual;
            }
            Arrays.sort(novaLista);
            for (int i = 0; i < novaLista.length; i++) {
				if (novaLista[i].contains(":")){
					novaLista[i]= " * " + novaLista[i].split(":")[1];
				}else{
					novaLista[i]= "Tipo de prato: " + novaLista[i];
				}
			}
            return novaLista;
        }
}
