package line;

import listener.MousePaintListener;
import shape.BaseShape;

import java.awt.event.MouseEvent;

public class SetStampPen extends BasePenBehavior {
    private BaseShape stampShape;

    public SetStampPen(MousePaintListener listener, String name) {
        super(listener, name);
    }

    public SetStampPen(String name) {
        super(name);
    }

    public void setDrawStamp(BaseShape stampShape) {
        this.stampShape = stampShape;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (stampShape == null) return;
        stampShape.drawShape(getMousePaintListener().getGraphics(), mouseEvent.getPoint());
    }
}
