package jogo;

import javax.swing.JFrame;

public class TesteGrafico {

	public static void main(String[] args) {
		JFrame tela = new JFrame();
		Grafico desenho = new Grafico();
		tela.add(desenho);
		tela.setSize(300,300);
		tela.setVisible(true);

	}

}
