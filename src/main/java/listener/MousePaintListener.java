package listener;

import drawing.CustomGraphics2D;
import drawing.DrawingJPanel;
import line.PenBehavior;
import line.SetNormalPen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePaintListener implements MouseMotionListener, MouseListener {
	private DrawingJPanel frame;
	private CustomGraphics2D frameGraphics;
	private PenBehavior penBehavior;
	
	public MousePaintListener(DrawingJPanel frame) {
		this.frame = frame;
		this.frameGraphics = frame.getCustomGraphics();
		this.penBehavior = new SetNormalPen(this, "", Color.BLACK);
	}
	
	public Graphics getGraphics() {
		return this.frameGraphics.getGraphics();
	}

	public CustomGraphics2D getCustomGraphics2D() {
		return this.frameGraphics;
	}

	public void setPenBehavior(PenBehavior penBehavior) {
		this.penBehavior = penBehavior;
	}

	public PenBehavior getPenBehavior() {
		return penBehavior;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		penBehavior.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		penBehavior.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		penBehavior.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		penBehavior.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		penBehavior.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		penBehavior.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		penBehavior.mouseReleased(e);
	}
}
