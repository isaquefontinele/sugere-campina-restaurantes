package Projeto;

public class Ordena {
	 public static void bubbleSort(String[] valores) throws Exception {
		 	if (valores.length == 0){
		 		throw new Exception("Nao eh permitido um array vazio.");
		 	}
		 	
		 	if (!(valores[0].contains(":"))){
		 		throw new Exception("Tem que haver : separando os dois campos.");
		 	}
		 	
		 	if (valores[0].split(":")[0].matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
		 		throw new Exception("O primeiro campo tem qua haver so caracteres numericos.");
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
	 public static void bubbleSortDec(String[] valores) throws Exception {
		 String[] copia = valores.clone();
		 bubbleSort(copia);
		 for (int i = 0 ; i < copia.length; ++i){
			 valores[i]= copia[(copia.length-1) - i];
		 }
	 }
	 
}
