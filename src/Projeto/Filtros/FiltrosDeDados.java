package Projeto.Filtros;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import Projeto.TratamentosArquivos.Estabelecimentos;

public class FiltrosDeDados {
	private String[] filtros;
	private Estabelecimentos estabelecimentos;
	private ArrayList<String> listaEstabelecimentosLocal;

	public FiltrosDeDados(String[] filtros, Estabelecimentos estabelecimentos) {
		this.filtros = filtros;
		this.estabelecimentos = estabelecimentos;

		listaEstabelecimentosLocal = estabelecimentos.getEstabelecimentos();
	}

	private void FiltroPorTermo(ArrayList<String> restaurantes, String termo) {

		ArrayList<String> estabelecimentosFiltrados = new ArrayList<String>();

		for (int i = 0; i < restaurantes.size(); i++) {
			if (!restaurantes.get(i).toLowerCase()
					.contains(termo.toLowerCase())) {
				estabelecimentosFiltrados.add(restaurantes.get(i));
			}
		}

		listaEstabelecimentosLocal = estabelecimentosFiltrados;

	}

	private void FiltroPorTipo(ArrayList<String> restaurantes, String tipo) {
		ArrayList<String> estabelecimentosFiltrados = new ArrayList<String>();

		for (int i = 0; i < restaurantes.size(); i++) {
			if (estabelecimentos.getTipoEstabelecimento(restaurantes.get(i))
					.toLowerCase().equals(tipo.toLowerCase())) {
				estabelecimentosFiltrados.add(restaurantes.get(i));
			}
		}

		listaEstabelecimentosLocal = estabelecimentosFiltrados;
	}

	private void FiltroPorEndereco(ArrayList<String> restaurantes,
			String endereco) {
		ArrayList<String> estabelecimentosFiltrados = new ArrayList<String>();

		for (int i = 0; i < restaurantes.size(); i++) {
			if (estabelecimentos.getEndereco(restaurantes.get(i)).toLowerCase()
					.contains(endereco.toLowerCase()))
				estabelecimentosFiltrados.add(restaurantes.get(i));
		}
		listaEstabelecimentosLocal = estabelecimentosFiltrados;
	}

	public ArrayList<String> aplicaFiltros() {
		String filtro, argumento;

		for (int i = 0; i < filtros.length; i++) {
			filtro = filtros[i].split(":")[0];
			argumento = filtros[i].split(":")[1];

			if (filtro.equals("Palavra-chave")) {

				FiltroPorTermo(listaEstabelecimentosLocal, argumento);

			} else if (filtro.equals("Endereço")) {

				FiltroPorEndereco(listaEstabelecimentosLocal, argumento);
			} else if (filtro.equals("Tipo de refeição")) {

				FiltroPorTipo(listaEstabelecimentosLocal, argumento);
			}
		}
		return listaEstabelecimentosLocal;
	}
}
