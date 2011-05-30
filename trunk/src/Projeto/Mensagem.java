package Projeto;

import java.awt.Component;

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
	/**
	 * Permite que o usuário possa escolher entre sim , não e cancela.
	 * @param String - Mensagem a exibir na caixa de texto com a pergunta ao usuário
	 * @return Int - sento 0 para Sim - yes , 1 - Não ou No, 2 - Cancela - cancel e -1 caso feche a janela
	 */
	public static int exibePergunta(String mensagem){
		return JOptionPane.showConfirmDialog(new Component() {}, mensagem);
	}
}
