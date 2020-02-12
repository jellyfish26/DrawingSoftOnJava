package color;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;
import java.awt.*;

public class SetColorMenuItem extends JMenuItem implements SetMousePaintListener {
    private MousePaintListener paintListener;
    private Color changeColor;

    public SetColorMenuItem(String name, MousePaintListener listener, Color color) {
        super(name);
        this.paintListener = listener;
        this.changeColor = color;
        this.addActionListener(e -> this.paintListener.getGraphics().setColor(changeColor));
    }

    public SetColorMenuItem(String name, Color color) {
        super(name);
        this.changeColor = color;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
        this.addActionListener(e -> paintListener.getGraphics().setColor(changeColor));
    }
}
