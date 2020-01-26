package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;
import shape.BaseShape;

import javax.swing.*;

public class SetStampButton extends JButton implements SetMousePaintListener {
    private MousePaintListener paintListener;
    private SetStamp setStamp;

    public SetStampButton(MousePaintListener paintListener, String name, BaseShape setShape) {
        super(name);
        this.paintListener = paintListener;
        this.setStamp = new SetStamp(name, setShape);
        this.addActionListener(e -> this.setStamp.setPenBehavior());
    }

    public SetStampButton(String name, BaseShape setShape) {
        super(name);
        this.setStamp = new SetStamp(name, setShape);
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        this.paintListener = listener;
        setStamp.setMousePaintListener(listener);
        this.addActionListener(e -> this.setStamp.setPenBehavior());
    }

    public void setLocationAndSize(int x, int y) {
        this.setLocation(x, y);
        this.setSize(80, 28);
    }
}
