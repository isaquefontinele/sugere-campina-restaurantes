package Projeto;


import java.io.IOException;


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

	public static void criaSugere() throws IOException {
		Estabelecimentos esta = new Estabelecimentos(teste2);
		Usuarios user = new Usuarios(teste1.recolheDados());

		//sugere = new SugereCampina(user, esta);
		/*System.out.println("criou");
		try {
			sugere2 = (SugerePopulares) new SugereCampina(user,esta);
			//sugere2 = (SugerePopulares) sugere;
			System.out.println("passou");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// sugere = new SugerePorPerfil(user,esta);
		 sugere2 = new SugerePorPerfil(user, esta);
	*/}

	public static void main(String[] args) throws Exception {
		teste1 = new TrataArquivoOpinioes("opinioes-dos-usuarios-v2.data");
		teste2 = new TrataArquivoEstabelecimento(
				"lista_estabelecimentos_projeto_lp2-v2.data");
		Integer seila = 0;

		// sugere = new SugereCampina(teste1, teste2);
		Integer[] notas = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		//
		// System.out.println(Arrays.toString(sugere.recomendacoes(notas, 39)));

		// System.out.println(Arrays.toString(user.getOpinioes("Nazareno")));

		//criaSugere();
		Estabelecimentos esta = new Estabelecimentos(teste2);
		Usuarios user = new Usuarios(teste1.recolheDados());
                System.out.println(esta.getEstabelecimentos().get(0) + " " + esta.getEndereco(esta.getEstabelecimentos().get(0)) + " " + esta.getTipoEstabelecimento(esta.getEstabelecimentos().get(0)));
                
                        
                        
		// System.out.println(Arrays.toString(sugere2.recomendacoes(
		// sugere.notasUsuario("Nazareno"), 5)));
		// System.out.println(Arrays.toString(sugere.mostraNotasGlobais()));
		// System.out.println(Arrays.toString(sugere.recomendacoes("Nazareno",
		// 5)));

		// while (it.hasNext()){
		// String nome = (String) it.next();
		// System.out.println(nome + ", " +
		// Arrays.toString(sugere.notasUsuario(nome)));
		// }
		// HashMap mapa = teste1.recolheDados();
		// Set chaves = mapa.keySet();
		// String [] linhaTemporaria = (String[]) mapa.get("Anonimo1");
		// mapa.keySet().remove("Anonimo1");
		// mapa.put("Anonimo01", linhaTemporaria);
		// System.out.println(mapa.keySet());
		//
		//
		// System.out.println(sugere.getEstabelecimentos().size());
		// System.out.println(Arrays.toString(sugere.recomendacoes("Rayff Queiroga",
		// 5)));

		// System.out.println(Arrays.toString(sugere.maisPopulares(7)));
		// System.out.println(Arrays.toString(sugere.notasUsuario("Anonimo74")));
		//

		// for (int i = 0; i < sugere.usuariosSemelhantes("Nazareno").size();
		// i++) {
		// java.util.Iterator<String[]> it =
		// sugere.usuariosSemelhantes("Nazareno").iterator();
		// while (it.hasNext()) {
		// System.out.println(Arrays.toString(it.next()));
		//
		// }
		// }

	}
}