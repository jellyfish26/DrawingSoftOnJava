import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MousePaintListener implements MouseMotionListener, MouseListener {
	JFrame frame;
	Graphics frameGraphis;
	
	public MousePaintListener(JFrame frame) {
		this.frame = frame;
		this.frameGraphis = frame.getGraphics();
	}
	
	public Graphics getGraphics() {
		return this.frameGraphis;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.frameGraphis.fillArc(e.getX(), e.getY(), 10, 10, 0, 360);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(frame.getGraphics());
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
