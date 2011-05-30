
package Projeto;


/**
 * 
 * @author laerton
 */
public class AcoesBarraFerramentas {

	private SugereCampina sugere;
	private JanelaGenerica janelaGenerica;

	public AcoesBarraFerramentas(SugereCampina sugere,
			JanelaGenerica janelaGenerica) {
		this.janelaGenerica = janelaGenerica;
		this.sugere = sugere;
	}

	public void abrirJanelaRanking() {
		janelaGenerica.setVisible(true);
		janelaGenerica.setTitle("Ranking");

		CentralizaJanela.centralizaJanela(janelaGenerica);
		try {
			janelaGenerica.povoaListaRanking(sugere.maisPopulares(sugere
					.getEstabelecimentos().size()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Mensagem.exibirMensagem(e.getMessage());
		}
	}

	public void abrirJanelaPorPopularidade() {
		String resposta = mensagemIndicacoes();

		if (resposta != null) {

			janelaGenerica.setTitle("Indicações dos mais populares.");

			CentralizaJanela.centralizaJanela(janelaGenerica);
			try {
				janelaGenerica.povoaListaRanking(sugere.maisPopulares(Integer
						.valueOf(resposta)));
				janelaGenerica.setVisible(true);
			} catch (Exception e) {
				if (e.getMessage().equals(
						String.valueOf(sugere.getEstabelecimentos().size()))) {
					Mensagem.exibirMensagem("Você solicitou "
							+ resposta
							+ " opiniões, mas só há "
							+ e.getMessage()
							+ " estabelecimento(s).\n Por esse motivo restarei exibindo somente o(s) "
							+ e.getMessage());
					try {
						janelaGenerica.povoaListaRanking(sugere
								.maisPopulares(Integer.valueOf(sugere
										.getEstabelecimentos().size())));
						janelaGenerica.setVisible(true);
					} catch (Exception e1) {
						Mensagem.exibirMensagem(e.getMessage());
					}
				} else {
					Mensagem.exibirMensagem(e.getMessage());
				}

			}

		}
	}
	public void abrirJanelaPorPerfilActionPerformed(Integer[] notas) {
		String resposta = mensagemIndicacoes();
		if (resposta != null) {

			janelaGenerica.setTitle("Indicações por perfil.");

			CentralizaJanela.centralizaJanela(janelaGenerica);
			try {
				String[] retorno = sugere.recomendacoes(notas,
						Integer.valueOf(resposta));
				if (retorno.length < Integer.valueOf(resposta)) {
					Mensagem.exibirMensagem("Da(s) " + resposta
							+ " solicitada(s), só foi possível indicar "
							+ retorno.length + " opiniões.");
				}

				janelaGenerica.povoaListaRanking(retorno);
				janelaGenerica.setVisible(true);

			} catch (Exception e) {
				if (e.getMessage() == null) {
					Mensagem.exibirMensagem("Não há sugestões para esse perfil.");
				} else {
					Mensagem.exibirMensagem(e.getMessage());
				}
			}

		}
	}

	public void abrirJanelaPorPerfilActionPerformed(String usuario) {
		String resposta = mensagemIndicacoes();
		if (resposta != null) {

			janelaGenerica.setTitle("Indicações por perfil.");

			CentralizaJanela.centralizaJanela(janelaGenerica);
			try {
				String[] retorno = sugere.recomendacoes(usuario,
						Integer.valueOf(resposta));
				if (retorno.length < Integer.valueOf(resposta)) {
					Mensagem.exibirMensagem("Da(s) " + resposta
							+ " solicitada(s), só foi possível indicar "
							+ retorno.length + " opiniões.");
				}

				janelaGenerica.povoaListaRanking(retorno);
				janelaGenerica.setVisible(true);

			} catch (Exception e) {
				if (e.getMessage() == null) {
					Mensagem.exibirMensagem("Não há sugestões para esse perfil.");
				} else {
					Mensagem.exibirMensagem(e.getMessage());
				}
			}

		}
	}

	private String mensagemIndicacoes() {
		String resposta = null;
		boolean sair = true;
		do {

			resposta = Mensagem.caixaDeEntrada("Quantas indicações deseja?");
			if (resposta != null) {
				if (resposta.equals("") || Integer.valueOf(resposta) <= 0) {
					Mensagem.exibirMensagem("Quantidade inválida");
				} else {
					sair = false;
				}
			} else {
				sair = false;
			}

		} while (sair);
		return resposta;
	}
}
