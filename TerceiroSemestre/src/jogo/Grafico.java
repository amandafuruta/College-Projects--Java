package jogo;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Grafico extends JPanel{
	char tabuleiro[][] = new char [3][3];
	char simbolo = 'o';
	
	public Grafico () {
		repaint();
		MouseClique rato = new MouseClique();
		this.addMouseListener(rato);
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				tabuleiro[i][j]= ' ';
			}
		}
	}
	
	
	private class MouseClique implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			verificaDesenho (e.getX(), e.getY());
			
			repaint();
			
			verificaVencedor();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		   desenhaTabuleiro (g);
	}
	
	public void verificaDesenho (int x, int y) {
		if (simbolo == 'o') {
			simbolo = 'x';
		}else {
			simbolo = 'o';
		}
		
		if ((x >=10 && x<=90) && (y>=10 && y<=90)) {
			
			if (tabuleiro[0][0] == ' ') {
				tabuleiro[0][0] = simbolo;
				
			}
		}
		if (x>=90 && x<=190 && y>=10 && y<=90) {
			if (tabuleiro[0][1] == ' ') {
				tabuleiro[0][1] = simbolo;
			}
			
		}
		if (x>=190 && x<=270 && y>=10 && y<=90) {
			if (tabuleiro[0][2] == ' ') {
				tabuleiro[0][2]= simbolo;
			}
			
		}
		if(x >=10 && x<=90 && y>=90 && y<=180) {
			if (tabuleiro[1][0] == ' ') {
				tabuleiro[1][0]= simbolo;
			}
		}
		
		if(x>=90 && x<=190 && y>=90 && y<=180) {
			if (tabuleiro[1][1] == ' ') {
				tabuleiro[1][1]= simbolo;
			}
		}
		
		if(x>=190 && x<=270 && y>=90 && y<=180) {
			if (tabuleiro[1][2] == ' ') {
				tabuleiro [1][2] = simbolo;
			}
			
		}
		if(x >=10 && x<=90 && y>=180 && y<=250) {
			if (tabuleiro[2][0] == ' ') {
				tabuleiro[2][0]= simbolo;
			}
			
		}
		if(x>=90 && x<=190 && y>=180 && y<=250) {
			if (tabuleiro[2][1] == ' ') {
				tabuleiro[2][1]= simbolo;
			}
			
		}
		if(x>=190 && x<=270 && y>=180 && y<=250) {
			if (tabuleiro[2][2] == ' ') {
				tabuleiro[2][2]= simbolo;
			}
			
		}
	}
	
	public void verificaVencedor() {
		int sum= 0;
		int j = 0;
		
		// Verifica as linhas
		for (int i=0; i<3; i++) {
			if((tabuleiro[i][j] == 'o' &&  tabuleiro[i][j+1] == 'o' && tabuleiro[i][j+2] == 'o') || (tabuleiro[i][j] == 'x' &&  tabuleiro[i][j+1] == 'x' && tabuleiro[i][j+2] == 'x')) {		
				JOptionPane.showMessageDialog(getRootPane(), "Você Ganhou!", null, 1);
			}				
		}
		
		int i = 0;
		
		//Verifica as colunas
		for (j=0; j<3; j++) {
			if((tabuleiro[i][j] == 'o' &&  tabuleiro[i+1][j] == 'o' && tabuleiro[i+2][j] == 'o') || (tabuleiro[i][j] == 'x' &&  tabuleiro[i+1][j] == 'x' && tabuleiro[i+2][j] == 'x')) {		
				JOptionPane.showMessageDialog(getRootPane(), "Você Ganhou!", null, 1);
			}				
		}
		
		// Verifica a diagonal secundária
		
		if((tabuleiro[0][0] == 'o' &&  tabuleiro[1][1] == 'o' && tabuleiro[2][2] == 'o') || (tabuleiro[0][0] == 'x' &&  tabuleiro[1][1] == 'x' && tabuleiro[2][2] == 'x')) 		
			JOptionPane.showMessageDialog(getRootPane(), "Você Ganhou!", null, 1);
			
		// Verifica a diagonal primária
		
		if((tabuleiro[0][2] == 'o' &&  tabuleiro[1][1] == 'o' && tabuleiro[2][0] == 'o') || (tabuleiro[0][2] == 'x' &&  tabuleiro[1][1] == 'x' && tabuleiro[2][0] == 'x')) 		
				JOptionPane.showMessageDialog(getRootPane(), "Você Ganhou!", null, 1);   
		
				
	}
		
		
	
	public void desenhaTabuleiro(Graphics g) {
		
		// Linhas Verticais
		   g.drawLine(90, 10, 90, 250);
		   g.drawLine(190, 10, 190, 250);
		   // Linhas Horizontais
		   g.drawLine(10, 90, 270, 90);
		   g.drawLine(10, 180, 270, 180);
		   
		   
		   for (int i = 0; i<3; i++) {
			   for (int j = 0; j<3; j++) {
				   if (tabuleiro [i][j] == 'o') {
					   if(i== 0 && j==0) {
						// Bolinha
						 g.drawArc(20, 20, 60, 60, 0, 360);
					   }else if (i == 0 && j == 1) {
						   g.drawArc(110, 20, 60, 60, 0, 360);
					   }else if (i == 0 && j == 2) {
						   g.drawArc(210, 20, 60, 60, 0, 360);
					   }else if (i == 1 && j == 0) {
						   g.drawArc(20, 105, 60, 60, 0, 360);
					   }else if (i == 1 && j == 1) {
						   g.drawArc(110, 105, 60, 60, 0, 360);
					   }else if (i == 1 && j ==2) {
						   g.drawArc(210, 105, 60, 60, 0, 360);
					   }else if (i== 2 && j == 0) {
						   g.drawArc(20, 190, 60, 60, 0, 360);
					   }else if (i == 2 && j == 1) {
						   g.drawArc(110, 190, 60, 60, 0, 360);
					   }else if (i == 2 && j == 2) {
						   g.drawArc(210, 190, 60, 60, 0, 360);
					   }
					   
				   }else if (tabuleiro[i][j] == 'x') {
					   if(i== 0 && j==0) {
						// X
						   g.drawLine(20, 20, 70, 70);
						   g.drawLine(20, 70, 70, 20);
					   }else if (i == 0 && j==1) {
						   g.drawLine(115, 20, 165, 70);
						   g.drawLine(115, 70, 165, 20);
					   }else if (i== 0 && j==2) {
						   g.drawLine(210, 20, 260, 70);
						   g.drawLine(210, 70, 260, 20);
					   }else if (i== 1 && j==0) {
						   g.drawLine(20, 110, 70, 160);
						   g.drawLine(20, 160, 70, 110);
					   }else if (i == 1 && j == 1) {
						   g.drawLine(115, 110, 165, 160);
						   g.drawLine(115, 160, 165, 110);
					   }else if (i == 1 && j == 2) {
						   g.drawLine(210, 110, 260, 160);
						   g.drawLine(210, 160, 260, 110);
					   }else if (i ==2 && j == 0) {
						   g.drawLine(20, 200, 70, 250);
						   g.drawLine(20, 250, 70, 200);
					   }else if (i == 2 && j == 1) {
						   g.drawLine(115, 200, 165, 250);
						   g.drawLine(115, 250, 165, 200);
					   }else if (i == 2 && j == 2) {
						   g.drawLine(210, 200, 260, 250);
						   g.drawLine(210, 250, 260, 200);
					   }
				   }
			   }
		   }
	}
}

