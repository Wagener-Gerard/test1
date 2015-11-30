import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;


public class Main {
	
	public int previousY, previousX, currentX, currentY;
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
	 */
	
	public void initialize() {
		
		Disks Disk1 = new Disks(620, 130, 90, 120, 1);
		Disks Disk2 = new Disks(630, 240, 90, 140, 2);
		Disks Disk3 = new Disks(640, 330, 90, 160, 3);
		Disks Disk4 = new Disks(660, 420, 90, 180, 4);
		Disks Disk5 = new Disks(650, 510, 90, 200, 5);
		
		Disks[] Stack1 = new Disks[5];
		Disks[] Stack2 = new Disks[5];
		Disks[] Stack3 = new Disks[5];
		
		for (int i=0; i<5; i++){
			Stack2[i] = null;
			Stack3[i] = null;	
		}
		
		Stack1[0] = Disk1;
		Stack1[1] = Disk2;
		Stack1[2] = Disk3;
		Stack1[3] = Disk4;
		Stack1[4] = Disk5;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		Canvas canvas = new Canvas();
		
		
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				previousX = e.getX();
				previousY = e.getY();
			}
		});

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				g = canvas.getGraphics();
				
				g.drawRect(e.getX()-25, e.getY()-25, 50, 50);
				
				if ((previousX != currentX) || (previousY != currentY )){
					canvas.repaint();
					//canvas.paint(g);
				}
				
				previousX = currentX;
				previousY = currentY;
			}
		});

		canvas.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(canvas);
	}
	
}
