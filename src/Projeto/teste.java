package Projeto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

public class teste {

	private static ManipulaPesquisa teste1;
	private static ManipulaRestaurante teste2;
	private static SugereCampina sugere;
	
	public static void main(String[] args) throws Exception {
		teste1 = new ManipulaPesquisa("opinioes-dos-usuarios-v2.data");
		teste2 = new ManipulaRestaurante("lista_estabelecimentos_projeto_lp2-v2.data");
		sugere = new SugereCampina(teste1, teste2);
		
//		java.util.Iterator it = sugere.opinioes.keySet().iterator();
//		while (it.hasNext()){
//			String nome = (String) it.next();
//			System.out.println(nome + ", " + Arrays.toString(sugere.notasUsuario(nome)));
//		}
		
		
		
		
		System.out.println(Arrays.toString(sugere.recomendacoes("Anonimo74", 5)));
		
		

//		for (int i = 0; i < sugere.usuariosSemelhantes("Nazareno").size(); i++) {
//			java.util.Iterator<String[]> it =  sugere.usuariosSemelhantes("Nazareno").iterator();
//			while (it.hasNext()) {
//				System.out.println(Arrays.toString(it.next()));
//				
//			}
//		}
		
		
		
		
		
		
		
		
		
		
		
		}
	}