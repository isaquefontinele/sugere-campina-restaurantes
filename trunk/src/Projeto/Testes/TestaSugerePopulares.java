package Projeto.Testes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Projeto.Algoritimos.SugerePopulares;
import Projeto.TratamentosArquivos.Estabelecimentos;
import Projeto.TratamentosArquivos.TrataArquivoEstabelecimento;
import Projeto.TratamentosArquivos.TrataArquivoOpinioes;
import Projeto.TratamentosArquivos.Usuarios;

public class TestaSugerePopulares {

	private static SugerePopulares sugerePopulares;
	private static Usuarios user;
	private static Estabelecimentos esta;
	private static TrataArquivoOpinioes teste1;
	private static TrataArquivoEstabelecimento teste2;
	private static final String PESQUISA = "opinioesParaTeste.data";
	private static final String RESTAURANTES = "estabelecimentosParaTeste.data";
	
	
	@Before
	public void criaObjetos() throws IOException{
		teste1 = new TrataArquivoOpinioes("PESQUISA");
		teste2 = new TrataArquivoEstabelecimento("RESTAURANTES");
		esta = new Estabelecimentos(teste2);
		user = new Usuarios(teste1.recolheDados());
		
		try {
			sugerePopulares = new SugerePopulares(user, esta);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	@Test
	public void testaListaEstabelecimentos(){
		Assert.assertEquals("Erro em print dos estabelecimentos","[Bar do Cuscuz e Restaurante, Baixinho Bar e Restaurante, Bar do George, Bar do Santos, Bodão Bar e Restaurante, Bonaparte, Bongustaio, Cabana do Possidônio, Cantina da Sayonara, Cantina de Dona Inês, Cantina de Olavo, Cantina do Departamento de Meteorologia, Cantina do Hall das Placas, Cantinho Universitário, Chinatown, Divino Fogão, Fazenda, Giraffas, Girassol, Gulas, Manoel da Carne de Sol, Marmitaria ArtCulinária, Marmitaria Bom Paladar, Marmitaria da Mama, Paladar, Pedro da Picanha, Qdoca Bar e Restaurante, Restaurante Brasília, Restaurante da Quadra, Restaurante do Alexandre, Restaurante do Paraná, Restaurante Golden In China, Restaurante Lay China, Riso, Spolleto, Super China Restaurante, Trailer do Marcus, Tuxá, Varandas bar e restaurante]", sugerePopulares.listaEstabelecimentos().toString());
	}
	
	@Test
	public void testaContrutor(){

	}
	
	@Test
	public void testaGetUsuarios(){
		
	}
	
	@Test
	public void testaGetEstabelecimentos(){
		Assert.assertEquals("Erro em getEstabelecimentos",esta,sugerePopulares.getEstabelecimentos());
		System.out.println(sugerePopulares.getEstabelecimentos());
	}
	
	@Test
	public void testaUsuariosSemelhantes(){
		
	}
	
	@Test
	public void testaNotasUsuarios(){
		
	}
}
