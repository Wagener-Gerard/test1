import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;


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
	 * @return 
	 */
	
	public void initialize() {
		
		Disks Disk1 = new Disks(930, 150, 90, 140, 1);
		Disks Disk2 = new Disks(910, 240, 90, 180, 2);
		Disks Disk3 = new Disks(890, 330, 90, 220, 3);
		Disks Disk4 = new Disks(870, 420, 90, 260, 4);
		Disks Disk5 = new Disks(850, 510, 90, 300, 5);
		
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
		frame.setBounds(100, 100, 1217, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Canvas canvas = new Canvas();
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				paintOnCanvas(canvas, Stack1);
			}
		});

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//g.drawRect(e.getX()-25, e.getY()-25, 50, 50);
				Stack1[0].x = e.getX();
				Stack1[0].y = e.getY();

				paintOnCanvas(canvas, Stack1);
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				//if mouse pressed{
				//canvas.repaint();
				//}
			}
		});

		canvas.setBounds(0, 0, 1200, 600);
		frame.getContentPane().add(canvas);
		//paintOnCanvas(canvas, Stack1);
	}	
	
	public void paintOnCanvas(Canvas pCanvas, Disks[] pDisks){
		for (int i=0; i<5; i++){
			g = pCanvas.getGraphics();
			g.setColor(Color.BLUE);
			g.fillRoundRect(pDisks[i].x, pDisks[i].y, pDisks[i].width, pDisks[i].height, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect(pDisks[i].x, pDisks[i].y, pDisks[i].width, pDisks[i].height, 20, 20);
		}
	}
}
