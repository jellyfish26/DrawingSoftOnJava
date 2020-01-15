import javax.swing.*;

public class ChangeShapeButton extends JButton {
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

    void setLocationAndSize(int x, int y) {
        this.setLocation(x, y);
        this.setSize(80, 28);
    }
}
