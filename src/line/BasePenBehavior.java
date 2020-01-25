package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import java.awt.event.MouseEvent;

public abstract class BasePenBehavior implements PenBehavior, SetMousePaintListener {
    private String penName;
    private MousePaintListener paintListener;

    public BasePenBehavior(MousePaintListener listener, String name) {
        this.penName = name;
        this.paintListener = listener;
    }

    public BasePenBehavior(String name) {
        this.penName = name;
    }

    public MousePaintListener getMousePaintListener() {
        return paintListener;
    }

    public String getPenName() {
        return penName;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        this.paintListener = listener;
    }

    @Override
    public void setPenBehavior() {
        paintListener.setPenBehavior(this);
    }

    @Override
    public void removePenBehavior() {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
