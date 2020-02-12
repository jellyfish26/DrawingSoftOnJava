package line;

import listener.MousePaintListener;
import shape.BaseShape;

import java.awt.event.MouseEvent;

public class SetStamp extends BasePenBehavior {
    BaseShape stampShape;

    public SetStamp(MousePaintListener listener, String name, BaseShape shape) {
        super(listener, name);
        this.stampShape = shape;
    }

    public SetStamp(String name, BaseShape shape) {
        super(name);
        this.stampShape = shape;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        stampShape.drawShape(getMousePaintListener().getGraphics(), mouseEvent.getPoint());
    }
}
