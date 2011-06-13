package Projeto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import Projeto.Janelas.SugereCampinaAplication;
import Projeto.acoes.CentralizaJanela;

public class SplashScreen {

	private static SugereCampinaAplication programa;
	private static void lancarSplashScreen() {

		final JWindow janelaScreen = new JWindow();
		final JProgressBar barraDeProgresso = new JProgressBar();

		JLabel imagem = new JLabel();
		ImageIcon icone = new ImageIcon("sugere 400x300.jpg");
		imagem.setIcon(icone);

		barraDeProgresso.setPreferredSize(new Dimension(400, 20));
		barraDeProgresso.setStringPainted(true);

		janelaScreen.getContentPane().setLayout(new BorderLayout());
		janelaScreen.getContentPane().add(imagem, BorderLayout.CENTER);
		janelaScreen.getContentPane().add(barraDeProgresso,BorderLayout.SOUTH);

		new Thread() {

			public void run() {
				int valorDaBarra = 0;
				while (valorDaBarra < 101) {
					barraDeProgresso.setValue(Math.min(valorDaBarra, 100));
					try {
						Thread.sleep(20);
					} catch (InterruptedException ex) {
						ex.getMessage();
					}
					valorDaBarra += 1;
				}
				janelaScreen.dispose();
				SugereCampinaAplication programa;
				try {
					programa = new SugereCampinaAplication();
					programa.setVisible(true);
					CentralizaJanela.centralizaJanela(programa);
				} catch (IOException ex) {				
					ex.printStackTrace();
				} 
			}
		}.start();

		janelaScreen.pack();
		janelaScreen.setVisible(true);
		janelaScreen.setLocationRelativeTo(null);
	}

	public static void main(String args[]) throws Exception {
		lancarSplashScreen();
	}
	
}
