import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;

public class Main {
	
	public Graphics g;

	public JFrame frame;
	
	/**
	 * Launch the application.
	 */
	
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

	/**
	 * Create the application.
	 * @return 
	 */

	public Main(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	
	public void initialize() {		
		Area area1 = new Area(0, 400);
		Area area2 = new Area(400, 800);
		Area area3 = new Area(800, 1200);
		
		Disk disk1 = new Disk(70, 1, 1);
		Disk disk2 = new Disk(90, 2, 2);
		Disk disk3 = new Disk(110, 3, 3);
		Disk disk4 = new Disk(130, 4, 4);
		Disk disk5 = new Disk(150, 5, 5);
			
		ArrayList<Slot> stack1 = new ArrayList<Slot>();
		ArrayList<Slot> stack2 = new ArrayList<Slot>();
		ArrayList<Slot> stack3 = new ArrayList<Slot>();
		
		Slot stack1slotl1 = new Slot(disk1, 200, 150, 1);
		Slot stack1slotl2 = new Slot(disk2, 200, 240, 2);
		Slot stack1slotl3 = new Slot(disk3, 200, 330, 3);
		Slot stack1slotl4 = new Slot(disk4, 200, 420, 4);
		Slot stack1slotl5 = new Slot(disk5, 200, 510, 5);
		
		Slot stack2slotl1 = new Slot(null, 600, 150, 6);
		Slot stack2slotl2 = new Slot(null, 600, 240, 7);
		Slot stack2slotl3 = new Slot(null, 600, 330, 8);
		Slot stack2slotl4 = new Slot(null, 600, 420, 9);
		Slot stack2slotl5 = new Slot(null, 600, 510, 10);
		
		Slot stack3slotl1 = new Slot(null, 1000, 150, 11);
		Slot stack3slotl2 = new Slot(null, 1000, 240, 12);
		Slot stack3slotl3 = new Slot(null, 1000, 330, 13);
		Slot stack3slotl4 = new Slot(null, 1000, 420, 14);
		Slot stack3slotl5 = new Slot(null, 1000, 510, 15);
		
		Slot abeyance = new Slot(null, 0, 0, 16);
				
		stack1.add(stack1slotl1);
		stack1.add(stack1slotl2);
		stack1.add(stack1slotl3);
		stack1.add(stack1slotl4);
		stack1.add(stack1slotl5);
		
		stack2.add(stack2slotl1);
		stack2.add(stack2slotl2);
		stack2.add(stack2slotl3);
		stack2.add(stack2slotl4);
		stack2.add(stack2slotl5);
		
		stack3.add(stack3slotl1);
		stack3.add(stack3slotl2);
		stack3.add(stack3slotl3);
		stack3.add(stack3slotl4);
		stack3.add(stack3slotl5);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		MyJPanel panel = new MyJPanel();
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {		
				if (abeyance.x > area1.x1 && abeyance.x < area1.x2){
					for (int i=0; i<5; i++) {
						if (i != 4){
							if (stack1.get(i).disk == null){
								if(stack1.get(i+1).disk != null){
									stack1.get(i).disk = abeyance.disk;
								}
							}
						}  
						if (i == 4) {
							if (stack1.get(i-1).disk == null){
								stack1.get(i).disk = abeyance.disk;
							}
						}
					}
					abeyance.x = 0;
					abeyance.y = 0;
					abeyance.disk = null;
					panel.repaint(); 
				}
				
				if (abeyance.x > area2.x1 && abeyance.x < area2.x2){
					for (int i=0; i<5; i++) {
						if (i != 4){
							if (stack2.get(i).disk == null){
								if(stack2.get(i+1).disk != null){
									stack2.get(i).disk = abeyance.disk;
								}
							}
						}  
						if (i == 4) {
							if (stack2.get(i-1).disk == null){
								stack2.get(i).disk = abeyance.disk;
							}
						}
					}
					abeyance.x = 0;
					abeyance.y = 0;
					abeyance.disk = null;
					panel.repaint(); 
				}
				
				if (abeyance.x > area3.x1 && abeyance.x < area3.x2){
					for (int i=0; i<5; i++) {
						if (i != 4){
							if (stack3.get(i).disk == null){
								if(stack3.get(i+1).disk != null){
									stack3.get(i).disk = abeyance.disk;
								}
							}
						}  
						if (i == 4) {
							if (stack3.get(i-1).disk == null){
								stack3.get(i).disk = abeyance.disk;
							}
						}
					}
					abeyance.x = 0;
					abeyance.y = 0;
					abeyance.disk = null;
					panel.repaint(); 
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				int x, y;
				x = e.getX();
				y = e.getY();
				
				for (Slot slot : stack1) {
					if (slot.disk != null){
						if((slot.x-slot.disk.width<x)&&(slot.y<y)&&(slot.x+slot.disk.width>x)&&(slot.y+90>y)){
							System.out.println(slot.disk.width);
							abeyance.disk = slot.disk;
							abeyance.x = x;
							abeyance.y = y;
							panel.setSlot(abeyance);
							slot.disk = null;
							panel.repaint();
						}
					}
				}	
				
				for (Slot slot : stack2) {
					if (slot.disk != null){
						if((slot.x-slot.disk.width<x)&&(slot.y<y)&&(slot.x+slot.disk.width>x)&&(slot.y+90>y)){
							System.out.println(slot.disk.width);
							abeyance.disk = slot.disk;
							abeyance.x = x;
							abeyance.y = y;
							panel.setSlot(abeyance);
							slot.disk = null;
							panel.repaint();
						}
					}
				}
				
				for (Slot slot : stack3) {
					if (slot.disk != null){
						if((slot.x-slot.disk.width<x)&&(slot.y<y)&&(slot.x+slot.disk.width>x)&&(slot.y+90>y)){
							System.out.println(slot.disk.width);
							abeyance.disk = slot.disk;
							abeyance.x = x;
							abeyance.y = y;
							panel.setSlot(abeyance);
							slot.disk = null;
							panel.repaint();
						}
					}
				}
			}
		});
		
		panel.setStack(stack1, stack2, stack3);		
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x, y;
				x = arg0.getX();
				y = arg0.getY();
				abeyance.x = x;
				abeyance.y = y;
				panel.setSlot(abeyance);
				panel.repaint();
			}
		});
		panel.setBounds(0, 0, 1200, 600);
		frame.getContentPane().add(panel);
	}
}
