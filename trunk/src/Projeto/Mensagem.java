package Projeto;

import javax.swing.JOptionPane;

public class Mensagem {
	public static void exibirMensagem(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem,"Sugere Campina",JOptionPane.INFORMATION_MESSAGE);
	}

        public static String caixaDeEntrada (String mensagem){
           return javax.swing.JOptionPane.showInputDialog(mensagem);
        }
}
