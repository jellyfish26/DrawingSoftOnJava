package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;

public class SetThicknessMenuItem extends JMenuItem implements SetMousePaintListener {
    private  MousePaintListener paintListener;
    private int thicknessLevel;

    public SetThicknessMenuItem(String name, int level) {
        super(name);
        this.thicknessLevel = level;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
        addActionListener(e -> paintListener.getCustomGraphics2D().changeLineThickness(thicknessLevel));
    }
}
