package line;

import drawing.DrawingShape;
import listener.MousePaintListener;
import listener.SetMousePaintListener;

import java.awt.event.MouseEvent;

public class SetShape implements PenBehavior, SetMousePaintListener {
    private MousePaintListener paintListener;
    private DrawingShape drawShape;
    private String name;
    private int vertex;

    public SetShape(MousePaintListener listener, String name, int vertex) {
        this.paintListener = listener;
        this.name = name;
        this.vertex = vertex;
        this.drawShape = new DrawingShape(vertex, name);
    }

    public SetShape(String name, int vertex) {
        this.name = name;
        this.vertex = vertex;
        this.drawShape = new DrawingShape(vertex, name);
    }

    @Override
    public void setPenBehavior() {
        paintListener.setPenBehavior(this);
    }

    @Override
    public void removePenBehavior() {

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        this.paintListener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        drawShape.setVertex(mouseEvent.getX(), mouseEvent.getY());
        drawShape.drawShapeToCustomGraphics(paintListener.getCustomGraphics2D());
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
