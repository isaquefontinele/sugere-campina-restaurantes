package Projeto;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 *
 */
public class CentralizaJanela {
	public static void centralizaJanela(JFrame componente)
    {
        // Centraliza a janela de abertura no centro do desktop.
          Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
          Rectangle r      = componente.getBounds();
        // Dimensões da janela
          int widthSplash = r.width ;
          int heightSplash = r.height;

        // calculo para encontrar as cooredenadas X e Y para a centralização da janela.
          int posX = (screen.width / 2) - ( widthSplash / 2 );
          int posY = (screen.height / 2) - ( heightSplash / 2 );

          componente.setBounds(posX,posY,widthSplash,heightSplash);
    }

}
