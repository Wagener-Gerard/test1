import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import java.awt.event.MouseAdapter;

public class Main {
	
	public Disk hoveringDisk;
	public Graphics g;
	public JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main(){
		initialize();
	}

	public void initialize() {		
		ArrayList<Disk> stack1 = new ArrayList<Disk>();
		ArrayList<Disk> stack2 = new ArrayList<Disk>();
		ArrayList<Disk> stack3 = new ArrayList<Disk>();
		
		for (int i = 50; i > 0 ; i--) {
			stack1.add(new Disk (i * 3, stack1));
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		MyJPanel panel = new MyJPanel();
		panel.setStack(stack1, stack2, stack3);
		panel.setBounds(0, 0, 1200, 600);
		frame.getContentPane().add(panel);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	

				if (hoveringDisk == null){
					return;
				}
				
				ArrayList<Disk> stackToCheck;
				
				switch (e.getX() / 400) {
					case 0 :
						stackToCheck = stack1;
						break;
					case 1 :
						stackToCheck = stack2;
						break;
					default :
						stackToCheck = stack3;
						break;
				}
				
				if (!stackToCheck.isEmpty()) {
					Disk highestDisk = stackToCheck.get(stackToCheck.size() - 1);
					
					if (hoveringDisk.width > highestDisk.width) {
						System.out.println("da daaa -> geet net :(");
						
						hoveringDisk.lastPos.add(hoveringDisk);
						panel.setMouseXY(e.getX(), e.getY());
						panel.setHoveringDisk(null);
						panel.repaint(); 
						return;
					}				
				} 

				stackToCheck.add(hoveringDisk);
				hoveringDisk.setLastPos(stackToCheck);
				hoveringDisk = null;
				
				panel.setMouseXY(e.getX(), e.getY());
				panel.setHoveringDisk(null);
				panel.repaint(); 
			}
		
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("Pressed");
				
				ArrayList<Disk> stackToCheck;
				
				switch (e.getX() / 400) {
					case 0 :
						stackToCheck = stack1;
						break;
					case 1 :
						stackToCheck = stack2;
						break;
					default :
						stackToCheck = stack3;
						break;
				}
				
				if (!stackToCheck.isEmpty()) {
					hoveringDisk = stackToCheck.get(stackToCheck.size() - 1);		
					stackToCheck.remove(stackToCheck.size() - 1);
					panel.setMouseXY(e.getX(), e.getY());
					panel.setHoveringDisk(hoveringDisk);
					panel.repaint();
				} 
			}
		});
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (hoveringDisk != null){
					panel.setMouseXY(e.getX(), e.getY());
					panel.repaint();
				}
			}
		});
	}
}
