import javax.swing.JFrame;
import java.awt.*;

public class DrawingJFrame extends JFrame {
	private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;
	private MousePaintListener paintListener;

	public DrawingJFrame() {
		super("Drawing Software");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		this.paintListener = new MousePaintListener(this);
		addMousePaintListener(this.paintListener);
	}
	
	public synchronized void addMousePaintListener(MousePaintListener mpl) {
		addMouseListener(mpl);
		addMouseMotionListener(mpl);
	}

	public CustomGraphics2D getCustomGraphics2D() {
		return new CustomGraphics2D((Graphics2D) this.getGraphics());
	}

	public MousePaintListener getMousePaintListener() {
		return this.paintListener;
	}

	public Component[] add(Component[] comp) {
		Component[] values = new Component[comp.length];
		for (int i = 0; i < comp.length; i++) values[i] = super.add(comp[i]);
		return values;
	}
}
