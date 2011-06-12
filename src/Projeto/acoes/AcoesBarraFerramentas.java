package Projeto.acoes;

import Projeto.Algoritimos.Sugere;
import Projeto.Janelas.JanelaGenerica;
import java.util.Arrays;

/**
 * 
 * @author Laerton, Isaque, ...
 */
public class AcoesBarraFerramentas extends AcoesEmJanelas {
	private JanelaGenerica janelaGenerica;

	/**
	 * Construtor da Classe AcoesBarraFerramentas Cria uma janela genérica para
	 * os algoritmos de sugestões por ranking, popularidade e perfis)
	 * 
	 * @param Objeto
	 *            do tipo SugereCampina
	 * @param Objeto
	 *            do tipo JanelaGerica
	 */

	public AcoesBarraFerramentas(Sugere sugere) {
		super(sugere);
		this.janelaGenerica = new JanelaGenerica();
	}

	public AcoesBarraFerramentas(Sugere sugere, String[] filtro) {
		super(sugere, filtro);
		this.janelaGenerica = new JanelaGenerica();
	}

	/**
	 * 
	 * Exibe na tela um objeto do tipo JanelaGerica com o resultado do algoritmo
	 * ranking
	 */
	public void abrirJanelaRanking() {
		try {
                        String[] retorno = super.getMaisPopulares();
                        
                        if (!(retorno[0].equals(""))){
                            inicializaJanelaGenerica("Ranking", retorno);
                        } else {
                            Mensagem.exibirMensagem("Infelizmente não foi possível gerar recomendações.");
                        }
		} catch (Exception e) {
			Mensagem.exibirMensagem((e.getMessage() == null)?"Infelizmente não foi possível gerar recomendações,\npois não há estabeleciemntos que atendam os requisitos":e.getMessage());
		}
	}

	/**
	 * Exibe na tela um objeto do tipo JanelaGerica com o resultado do algoritmo
	 * popularidade Haverá requisição via inputbox da quantidade a ser
	 * apresentada
	 */
	public void abrirJanelaPorPopularidade() {
		String resposta = mensagemIndicacoes();
		if (resposta != null) {
			try {

                        String[] retorno = super.getMaisPopulares(Integer.valueOf(resposta));
                        
                        if (!(retorno[0].equals("") )){
                                inicializaJanelaGenerica("Indicações dos mais populares.",retorno);
                        } else {
                            Mensagem.exibirMensagem("Infelizmente não foi possível gerar recomendações.");
                        }

			} catch (Exception ex) {
				Mensagem.exibirMensagem(ex.getMessage());
			}

		}
	}

	/**
	 * Exibe na tela um objeto do tipo JanelaGerica com o resultado do algoritmo
	 * por perfil Haverá requisição via inputbox da quantidade a ser apresentada
	 * 
	 * @param Integer
	 *            [] contendo as notas para análise
	 */
	public void abrirJanelaPorPerfilActionPerformed(Integer[] notas) {
		String resposta = mensagemIndicacoes();
		if (resposta != null) {
			try {
				String[] retorno = super.getPorPerfil(notas,
						Integer.valueOf(resposta));
                                
				if (retorno.length < Integer.valueOf(resposta)) {
					Mensagem.exibirMensagem("Das " + resposta
							+ " solicitadas, só foi possível indicar "
							+ retorno.length + " opinião(ões).");
				}
				inicializaJanelaGenerica("Indicações por perfil.", retorno);
			} catch (Exception e) {
				if (e.getMessage() == null) {
                                    String mensagem ;
                                    if (super.getFiltroAtivo()){
                                        mensagem = "Com estes filtros e seu perfil não foi possível gerar recomendaçoes.\nDeseja exibir os únicos estabecelecimentos que não foram excluidos pelos filtros?";
                                    }else{
                                        mensagem = "Não há sugestões para esse perfil.\nDeseja exibir a lista de ranking?";
                                    }
                                    
                                    int intRespota = Mensagem
							.exibePergunta(mensagem);
                                    if (intRespota == 0) {
						abrirJanelaRanking();
					}
				} else {
					Mensagem.exibirMensagem(e.getMessage());
				}
			}
		}
	}

	/**
	 * Exibe na tela um objeto do tipo JanelaGerica com o resultado do algoritmo
	 * por perfil Haverá requisição via inputbox da quantidade a ser apresentada
	 * 
	 * @param String
	 *            contendo o nome do usuário a ser analisado
	 */
	public void abrirJanelaPorPerfilActionPerformed(String usuario) {

		String resposta = mensagemIndicacoes();
		if (resposta != null) {
			try {
				int novoNumeroDeRecomendacoes = super.getNumeroDeNotas(usuario);
				int r = Integer.valueOf(resposta);

				if (r > novoNumeroDeRecomendacoes) {
					r = novoNumeroDeRecomendacoes;
				}

				String[] retorno = super.getPorPerfil(usuario, r);
                               
				if (retorno != null) {
					if (retorno.length < Integer.valueOf(resposta)) {
						Mensagem.exibirMensagem("Das " + resposta
								+ " solicitadas, só foi possível indicar "
								+ retorno.length + " opinião(ões).");
					}
					inicializaJanelaGenerica("Indicações por perfil.", retorno);
				} else {
					String mensagem ;
                                    if (super.getFiltroAtivo()){
                                        mensagem = "Com estes filtros e seu perfil não foi possível gerar recomendaçoes.\nDeseja exibir os únicos estabecelecimentos que não foram excluidos pelos filtros?";
                                    }else{
                                        mensagem = "Não há sugestões para esse perfil.\nDeseja exibir a lista de ranking?";
                                    }

                                    int intRespota = Mensagem
							.exibePergunta(mensagem);
                                    if (intRespota == 0) {
						abrirJanelaRanking();
				}
			}
                        } catch (Exception e) {
				if (e.getMessage() == null) {
                                    String mensagem ;
                                    if (super.getFiltroAtivo()){
                                        mensagem = "Deseja exibir os únicos estabecelecimentos que não foram excluidos pelos filtros?";
                                    }else{
                                        mensagem = "Não há sugestões para esse perfil.\nDeseja exibir a lista de ranking?";
                                    }

                                    int intRespota = Mensagem
							.exibePergunta(mensagem);
                                    if (intRespota == 0) {
						abrirJanelaRanking();
					}
				} else {
					Mensagem.exibirMensagem(e.getMessage());
				}
			}

		}

	}

	private void inicializaJanelaGenerica(String titulo, String[] conteudo) {
		janelaGenerica.setTitle(titulo);
		CentralizaJanela.centralizaJanela(janelaGenerica);
		janelaGenerica.povoaListaRanking(conteudo);
		janelaGenerica.setVisible(true);
	}

	/**
	 * Metodo que efetua a analise de acertos dos algoritimos dos objetos
	 * SugerePorPerfil e SugerePorPopularidade
	 */
	public void abriComparacoes() {
		super.threadComparaRecomendacoes();

	}

}
