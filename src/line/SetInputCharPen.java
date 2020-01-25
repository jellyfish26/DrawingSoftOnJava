package line;

import listener.MousePaintListener;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class SetInputCharPen extends BasePenBehavior {
    public SetInputCharPen(MousePaintListener listener, String name) {
        super(listener, name);
    }

    public SetInputCharPen(String name) {
        super(name);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        String inputChar = JOptionPane.showInputDialog("Enter the character you want to draw.");
        if (inputChar != null) {
            getMousePaintListener().getGraphics().drawString(inputChar, mouseEvent.getX(), mouseEvent.getY());
        }
    }
}
