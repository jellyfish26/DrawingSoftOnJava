package color;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import java.awt.Color;
import javax.swing.JButton;

public class SetColorButton extends JButton implements SetMousePaintListener {
	private MousePaintListener paintListener;
	private Color changeColor;
	
	public SetColorButton(MousePaintListener paintListener, String name, Color color) {
		super(name);
		this.paintListener = paintListener;
		this.changeColor = color;
		this.addActionListener(e -> this.paintListener.getGraphics().setColor(changeColor));
	}

	public SetColorButton(String name, Color color) {
		super((name));
		this.changeColor = color;
	}

	@Override
	public void setMousePaintListener(MousePaintListener listener) {
		paintListener = listener;
		addActionListener(e -> paintListener.getGraphics().setColor(changeColor));
	}
	
	public void setLocationAndSize(int x, int y) {
		this.setLocation(x, y);
		this.setSize(80, 28);
	}
}
