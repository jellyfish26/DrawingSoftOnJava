import java.awt.Color;
import javax.swing.JButton;

public class ChangeColorButton extends JButton {
	private MousePaintListener paintListener;
	private Color changeColor;
	
	public ChangeColorButton(MousePaintListener paintListener, String name, Color color) {
		super(name);
		this.paintListener = paintListener;
		changeColor = color;
		this.addActionListener(e -> {
			this.paintListener.getGraphics().setColor(changeColor);
		});
	}
	
	void setLocationAndSize(int x, int y) {
		this.setLocation(x, y);
		this.setSize(80, 28);
	}
}
