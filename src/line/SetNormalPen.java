package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

public class SetNormalPen implements PenBehavior, SetMousePaintListener {
    String name;
    MousePaintListener paintListener;

    public SetNormalPen(MousePaintListener listener, String name) {
        this.name = name;
        this.paintListener = listener;
    }

    public SetNormalPen(String name) {
        this.name = name;
    }

    @Override
    public void setPenBehavior() {
        paintListener.setNormalLine();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
    }
}
