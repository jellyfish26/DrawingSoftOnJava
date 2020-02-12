package color;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomColorMenuItem extends JMenuItem implements SetMousePaintListener {
    private JFrame frame;
    private MousePaintListener paintListener;
    private Color changeColor;

    public CustomColorMenuItem(String name, MousePaintListener listener, JFrame frame) {
        super(name);
        this.frame = frame;
        this.paintListener = listener;
        this.addActionListener(new KeyClick());
    }

    public CustomColorMenuItem(String name, JFrame frame) {
        super(name);
        this.frame = frame;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        paintListener = listener;
        this.addActionListener(new KeyClick());
    }

    private class KeyClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            changeColor = JColorChooser.showDialog(frame, "Set Color", paintListener.getGraphics().getColor());
            if (changeColor == null) changeColor = new Color(0, 0, 0);
            paintListener.getGraphics().setColor(changeColor);
        }
    }
}
