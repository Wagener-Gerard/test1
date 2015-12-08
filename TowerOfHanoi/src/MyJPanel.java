import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Disk> stack1 = new ArrayList<Disk>();
	ArrayList<Disk> stack2 = new ArrayList<Disk>();
	ArrayList<Disk> stack3 = new ArrayList<Disk>();

	Disk hoveringDisk;
	int mouseX;
	int mouseY;
	
	static final int DISKHEIGHT = 10;
	static final int PANELHEIGHT = 600;
	
	static final int CENTER1 = 200;
	static final int CENTER2 = 600;
	static final int CENTER3 = 1000;
	
	public void setStack(ArrayList<Disk> stack1, ArrayList<Disk> stack2, ArrayList<Disk> stack3){
		this.stack1 = stack1;
		this.stack2 = stack2;
		this.stack3 = stack3;
	}
	
	public void setHoveringDisk(Disk hoveringDisk) {
		this.hoveringDisk = hoveringDisk;
	}
	
	public void setMouseXY(int x, int y) {
		this.mouseX = x;
		this.mouseY = y;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.darkGray);
		g.fillRect(190, 100, 20, 500);
		g.fillRect(590, 100, 20, 500);
		g.fillRect(990, 100, 20, 500);
		
		for (Disk disk : stack1) {
			g.setColor(Color.red);
			g.fillRoundRect( CENTER1 - disk.width, PANELHEIGHT - DISKHEIGHT - stack1.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect( CENTER1 - disk.width, PANELHEIGHT - DISKHEIGHT - stack1.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
		}
		
		for (Disk disk : stack2) {
			g.setColor(Color.red);
			g.fillRoundRect( CENTER2 - disk.width, PANELHEIGHT - DISKHEIGHT - stack2.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect( CENTER2 - disk.width, PANELHEIGHT - DISKHEIGHT - stack2.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
		}
		
		for (Disk disk : stack3) {
			g.setColor(Color.red);
			g.fillRoundRect( CENTER3 - disk.width, PANELHEIGHT - DISKHEIGHT - stack3.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect( CENTER3 - disk.width, PANELHEIGHT - DISKHEIGHT - stack3.indexOf(disk) * DISKHEIGHT , disk.width*2, DISKHEIGHT, 20, 20);
		}
		
		if (hoveringDisk != null) {
			System.out.println(hoveringDisk);
			g.setColor(Color.red);
			g.fillRoundRect(mouseX - hoveringDisk.width, mouseY - (DISKHEIGHT / 2) , hoveringDisk.width * 2, DISKHEIGHT, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect(mouseX - hoveringDisk.width, mouseY - (DISKHEIGHT / 2) , hoveringDisk.width * 2, DISKHEIGHT, 20, 20);
		}
	}
}
