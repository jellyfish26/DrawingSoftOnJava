package shape;

import drawing.DrawingShape;
import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;

public class ChangeShapeButton extends JButton implements SetMousePaintListener {
    private MousePaintListener paintListener;
    private String shapeName;
    private int verticesSize;

    public ChangeShapeButton(MousePaintListener paintListener, String name, int verticesSize) {
        super(name);
        this.shapeName = name;
        this.paintListener = paintListener;
        this.verticesSize = verticesSize;
        this.addActionListener(e -> this.paintListener.setDrawShape(new DrawingShape(this.verticesSize, this.shapeName)));
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
        this.addActionListener(e -> paintListener.setDrawShape(new DrawingShape(this.verticesSize, this.shapeName)));
    }
}
