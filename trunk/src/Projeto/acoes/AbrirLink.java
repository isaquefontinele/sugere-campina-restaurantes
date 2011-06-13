package Projeto.acoes;

import java.awt.Desktop;

public class AbrirLink {
	
	private static String link;

	public AbrirLink(String link) {
		this.link = link;
	}

	public static void main(String[] args) {

		Desktop desk = java.awt.Desktop.getDesktop();
		try {
			desk.browse(new java.net.URI(link));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
