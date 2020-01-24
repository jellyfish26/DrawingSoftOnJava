package listener;

import drawing.CustomGraphics2D;
import drawing.DrawingJFrame;
import drawing.DrawingJPanel;
import drawing.DrawingShape;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePaintListener implements MouseMotionListener, MouseListener {
	private DrawingJPanel frame;
	private CustomGraphics2D frameGraphics;
	private DrawingShape drawShape;
	
	public MousePaintListener(DrawingJPanel frame) {
		this.frame = frame;
		this.frameGraphics = frame.getCustomGraphics();
	}
	
	public Graphics getGraphics() {
		return this.frameGraphics.getGraphics();
	}

	public void setDrawShape(DrawingShape shape) {
		this.drawShape = shape;
	}

	public void setNormalLine() {
		this.drawShape = null;
	}

	public CustomGraphics2D getCustomGraphics2D() {
		return this.frameGraphics;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (drawShape != null) return;
		this.frameGraphics.drawSmoothLine(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (drawShape == null) return;
		drawShape.setVertex(e.getX(), e.getY());
		drawShape.drawShapeToCustomGraphics(this.getCustomGraphics2D());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.frameGraphics.resetSmoothLineCoordinate();
	}
}
