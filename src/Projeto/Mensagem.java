package Projeto;

import javax.swing.JOptionPane;

public class Mensagem {
	public static void exibirMensagem(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem,"Prato Cheio",JOptionPane.INFORMATION_MESSAGE);
	}
}
