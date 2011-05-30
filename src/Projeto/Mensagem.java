package Projeto;

import javax.swing.JOptionPane;

/**
 * Classe para exibir mensagens de erro geradas por tratamentos de excessões
 * 
 * @author Laerton
 */
public class Mensagem {
	/**
	 * Exibe um alerta ao usuário
	 * 
	 * @param String - Mensagem que será exibida no alerta
	 */
	public static void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Sugere Campina",
				JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Recebe informações do usuário
	 * @param String - Mensagem a exibir na caixa de texto ao usuário
	 * @return String - Informações passadas pelo usuário
	 */
	public static String caixaDeEntrada(String mensagem) {
		return javax.swing.JOptionPane.showInputDialog(mensagem);
	}
}
