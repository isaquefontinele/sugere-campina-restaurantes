package Projeto;

import java.awt.Component;
import java.awt.Frame;
import java.awt.SplashScreen;
import java.net.URL;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 * 
 * @author Isaque
 *
 */

public class teste {

	private static ManipulaPesquisa teste1;
	private static ManipulaRestaurante teste2;
	private static SugereCampina sugere;
	
	public static void main(String[] args) throws Exception {
		teste1 = new ManipulaPesquisa("opinioes-dos-usuarios-v2.data");
		teste2 = new ManipulaRestaurante("lista_estabelecimentos_projeto_lp2-v2.data");
		sugere = new SugereCampina(teste1, teste2);
//		Integer[] notas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
//	    
//		System.out.println(Arrays.toString(sugere.recomendacoes(notas, 39)));
		
        Mensagem.exibirMensagem(String.valueOf(JOptionPane.showConfirmDialog(new Component() {} , "teste")));
                   



		
//		while (it.hasNext()){
//			String nome = (String) it.next();
//			System.out.println(nome + ", " + Arrays.toString(sugere.notasUsuario(nome)));
//		}
//		HashMap mapa = teste1.recolheDados();
//                Set chaves = mapa.keySet();
//                String [] linhaTemporaria = (String[]) mapa.get("Anonimo1");
//                mapa.keySet().remove("Anonimo1");
//                mapa.put("Anonimo01", linhaTemporaria);
//                System.out.println(mapa.keySet());
//                
//
//		System.out.println(sugere.getEstabelecimentos().size());
//		System.out.println(Arrays.toString(sugere.recomendacoes("Rayff Queiroga", 5)));

//		System.out.println(Arrays.toString(sugere.maisPopulares(7)));
//		System.out.println(Arrays.toString(sugere.notasUsuario("Anonimo74")));
//		

//		for (int i = 0; i < sugere.usuariosSemelhantes("Nazareno").size(); i++) {
//			java.util.Iterator<String[]> it =  sugere.usuariosSemelhantes("Nazareno").iterator();
//			while (it.hasNext()) {
//				System.out.println(Arrays.toString(it.next()));
//				
//			}
//		}
		
		
		
		
		
		
		
		
		
		}	
	}