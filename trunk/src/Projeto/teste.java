package Projeto;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Projeto.Algoritimos.Sugere;
import Projeto.Filtros.FiltrosDeDados;
import Projeto.Janelas.JanelaFiltro;
import Projeto.TratamentosArquivos.Estabelecimentos;
import Projeto.TratamentosArquivos.TrataArquivoEstabelecimento;
import Projeto.TratamentosArquivos.TrataArquivoOpinioes;
import Projeto.TratamentosArquivos.Usuarios;
import java.util.Iterator;


//mport sun.misc.Sort;

/**
 * 
 * @author Isaque
 * 
 */

public class teste {

	private static TrataArquivoOpinioes teste1;
	private static TrataArquivoEstabelecimento teste2;
	private static Sugere sugere;
	private static Sugere sugere2;
	private static TiposDeFiltros tipo;
	private static ArrayList<String> tipos;
	private static FiltrosDeDados filtro;
	private static Estabelecimentos esta;
	private static JanelaFiltro janelaFiltro = new JanelaFiltro();
	private static ArrayList<String> metodo(){
		filtro = new FiltrosDeDados(JanelaFiltro.getListaDeFiltros(), esta);
		return filtro.aplicaFiltros();
	}
	public static void main(String[] args) throws Exception {
		teste1 = new TrataArquivoOpinioes("opinioes-dos-usuarios-v2.data");
		teste2 = new TrataArquivoEstabelecimento(
				"lista_estabelecimentos_projeto_lp2-v2.data");
		Estabelecimentos esta = new Estabelecimentos(teste2);
		String[] teste321 = {"Palavra-chave:Bar"};
		filtro = new FiltrosDeDados(teste321, esta);
                ArrayList<String> lista1 =filtro.aplicaFiltros();
                Iterator<String> it = (Iterator<String>) lista1.iterator();
                String palavra;
                String palavra2 = "Bonaparte";
                while (it.hasNext()){
                	palavra = it.next();
                    System.out.println(palavra + " " + palavra2 + " " + palavra.equals(palavra2) + " " + palavra2.equals(palavra) + " " + palavra.contains(palavra2) );
                }
                lista1.toString().contains("Bonaparte");
		System.out.println(lista1.toString().contains("Bonaparte"));
		System.out.println(filtro.aplicaFiltros());
		String[] novo = {};
		System.out.println(novo[0]);
                        
                        
		
	}
}