import javax.swing.JFrame;

public class DrawingJFrame extends JFrame {
	private int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;
	private MousePaintListener paintListener;
	
	public DrawingJFrame() {
		super("Drawing Software");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.paintListener = new MousePaintListener(this);
		this.addMousePaintListener(this.paintListener);
	}
	
	public synchronized void addMousePaintListener(MousePaintListener mpl) {
		super.addMouseListener(mpl);
		super.addMouseMotionListener(mpl);
	}
	
	public MousePaintListener getMousePaintListener() {
		return this.paintListener;
	}
}
