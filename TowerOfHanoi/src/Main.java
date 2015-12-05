import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;

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
		
		Disk disk1 = new Disk(70, 1);
		Disk disk2 = new Disk(90, 2);
		Disk disk3 = new Disk(110, 3);
		Disk disk4 = new Disk(130, 4);
		Disk disk5 = new Disk(150, 5);
			
		ArrayList<Slot> stack1 = new ArrayList<Slot>();
		ArrayList<Slot> stack2 = new ArrayList<Slot>();
		ArrayList<Slot> stack3 = new ArrayList<Slot>();
		
		Slot stack1slotl1 = new Slot(disk1, 200, 150);
		Slot stack1slotl2 = new Slot(disk2, 200, 240);
		Slot stack1slotl3 = new Slot(disk3, 200, 330);
		Slot stack1slotl4 = new Slot(disk4, 200, 420);
		Slot stack1slotl5 = new Slot(disk5, 200, 510);
		
		Slot stack2slotl1 = new Slot(null, 600, 150);
		Slot stack2slotl2 = new Slot(null, 600, 240);
		Slot stack2slotl3 = new Slot(null, 600, 330);
		Slot stack2slotl4 = new Slot(null, 600, 420);
		Slot stack2slotl5 = new Slot(null, 600, 510);
		
		Slot stack3slotl1 = new Slot(null, 1000, 150);
		Slot stack3slotl2 = new Slot(null, 1000, 240);
		Slot stack3slotl3 = new Slot(null, 1000, 330);
		Slot stack3slotl4 = new Slot(null, 1000, 420);
		Slot stack3slotl5 = new Slot(null, 1000, 510);
				
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
		
		panel.setStack(stack1, stack2, stack3);
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
			}
		});
		panel.setBounds(0, 0, 1200, 600);
		frame.getContentPane().add(panel);
	}
}
