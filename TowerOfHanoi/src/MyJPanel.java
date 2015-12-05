import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MyJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
			
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, 1200, 900);
			
			g.setColor(Color.darkGray);
			g.fillRect(190, 100, 20, 500);
			g.fillRect(590, 100, 20, 500);
			g.fillRect(990, 100, 20, 500);
			/*
			for (int i=0; i<5; i++){
				g.setColor(Color.red);
				g.fillRoundRect(pDisks[i].x, pDisks[i].y, pDisks[i].width, pDisks[i].height, 20, 20);
				g.setColor(Color.BLACK);
				g.drawRoundRect(pDisks[i].x, pDisks[i].y, pDisks[i].width, pDisks[i].height, 20, 20);
			}*/
	}
}
