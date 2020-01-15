import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MousePaintListener implements MouseMotionListener, MouseListener {
	private DrawingJFrame frame;
	private CustomGraphics2D frameGraphics;
	private DrawingShape drawShape;
	
	public MousePaintListener(DrawingJFrame frame) {
		this.frame = frame;
		this.frameGraphics = frame.getCustomGraphics2D();
	}
	
	public Graphics getGraphics() {
		return this.frameGraphics.getGraphics();
	}

	public void setDrawShape(DrawingShape shape) {
		this.drawShape = shape;
	}

	public CustomGraphics2D getCustomGraphics2D() {
		return this.frameGraphics;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
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
