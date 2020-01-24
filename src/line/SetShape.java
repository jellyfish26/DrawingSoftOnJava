package line;

import drawing.DrawingShape;
import listener.MousePaintListener;
import listener.SetMousePaintListener;

public class SetShape implements PenBehavior, SetMousePaintListener {
    MousePaintListener paintListener;
    String name;
    int vertex;

    public SetShape(MousePaintListener listener, String name, int vertex) {
        this.paintListener = listener;
        this.name = name;
        this.vertex = vertex;
    }

    public SetShape(String name, int vertex) {
        this.name = name;
        this.vertex = vertex;
    }

    @Override
    public void setPenBehavior() {
        paintListener.setDrawShape(new DrawingShape(vertex, name));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        this.paintListener = listener;
    }
}
