package line;

import drawing.DrawingShape;
import listener.MousePaintListener;

import java.awt.event.MouseEvent;

public class SetShapePen extends BasePenBehavior {
    private DrawingShape drawShape;
    private int vertex;

    public SetShapePen(MousePaintListener listener, String name, int vertex) {
        super(listener, name);
        this.vertex = vertex;
        this.drawShape = new DrawingShape(vertex, name);
    }

    public SetShapePen(String name, int vertex) {
        super(name);
        this.vertex = vertex;
        this.drawShape = new DrawingShape(vertex, name);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        drawShape.setVertex(mouseEvent.getX(), mouseEvent.getY());
        drawShape.drawShapeToCustomGraphics(getMousePaintListener().getCustomGraphics2D());
    }
}
