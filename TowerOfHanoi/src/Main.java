import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;


public class Main {
	
	int previousY, previousX, currentX, currentY;
	Graphics g;
	
	private JFrame frame;

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
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

		canvas.setBounds(0, 0, 884, 561);
		frame.getContentPane().add(canvas);
	}
	
}
