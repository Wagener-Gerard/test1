import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {

	ArrayList<Slot> stack1 = new ArrayList<Slot>();
	ArrayList<Slot> stack2 = new ArrayList<Slot>();
	ArrayList<Slot> stack3 = new ArrayList<Slot>();
	Slot abeyance = new Slot(null, 0, 0, 16);
	
	public void setStack(ArrayList<Slot> stack1, ArrayList<Slot> stack2, ArrayList<Slot> stack3){
		this.stack1 = stack1;
		this.stack2 = stack2;
		this.stack3 = stack3;
	}
	
	public void setSlot(Slot abeyance) {
		this.abeyance = abeyance;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.darkGray);
		g.fillRect(190, 100, 20, 500);
		g.fillRect(590, 100, 20, 500);
		g.fillRect(990, 100, 20, 500);
		
		
		if (abeyance.disk != null) {
			g.setColor(Color.red);
			g.fillRoundRect(abeyance.x-abeyance.disk.width, abeyance.y-45, abeyance.disk.width*2, 90, 20, 20);	
			g.setColor(Color.black);
			g.drawRoundRect(abeyance.x-abeyance.disk.width, abeyance.y-45, abeyance.disk.width*2, 90, 20, 20);	
		}	
		
		for (Slot slot : stack1) {
			if (slot.disk != null){
				g.setColor(Color.red);
				g.fillRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
				g.setColor(Color.BLACK);
				g.drawRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
			}
		}
			
		for (Slot slot : stack2) {
			if (slot.disk != null){
				g.setColor(Color.red);
				g.fillRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
				g.setColor(Color.BLACK);
				g.drawRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
			}
		}
			
		for (Slot slot : stack3) {
			if (slot.disk != null){
				g.setColor(Color.red);
				g.fillRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
				g.setColor(Color.BLACK);
				g.drawRoundRect(slot.x-slot.disk.width, slot.y, slot.disk.width*2, 90, 20, 20);
			}
		}
	}
}
