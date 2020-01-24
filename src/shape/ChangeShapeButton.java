package shape;

import drawing.DrawingShape;
import line.PenBehavior;
import line.SetShape;
import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;

public class ChangeShapeButton extends JButton implements SetMousePaintListener {
    private MousePaintListener paintListener;
    private String shapeName;
    private SetShape changeShape;
    private int verticesSize;

    public ChangeShapeButton(MousePaintListener paintListener, String name, int verticesSize) {
        super(name);
        this.shapeName = name;
        this.paintListener = paintListener;
        this.verticesSize = verticesSize;
        this.changeShape = new SetShape(paintListener, name, verticesSize);
        this.addActionListener(e -> paintListener.setPenBehavior(changeShape));
    }

    public ChangeShapeButton(String name, int verticesSize) {
        super(name);
        this.verticesSize = verticesSize;
    }

    public void setLocationAndSize(int x, int y) {
        this.setLocation(x, y);
        this.setSize(80, 28);
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
        this.changeShape = new SetShape(paintListener, shapeName, verticesSize);
        this.addActionListener(e -> paintListener.setPenBehavior(changeShape));
    }
}
