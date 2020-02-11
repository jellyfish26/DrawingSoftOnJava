package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;
import shape.BaseShape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetStampButton extends JButton implements SetMousePaintListener {
    private MousePaintListener paintListener;
    private BaseShape setShape;
    private SetStampPen stampPen;
    public static final int SIZE_WIDTH = 80, SIZE_HEIGHT = 28;

    public SetStampButton(MousePaintListener paintListener, String name, BaseShape setShape, SetStampPen pen) {
        super(name);
        this.paintListener = paintListener;
        this.setShape = setShape;
        this.stampPen = pen;
        this.addActionListener(new SetStampAction());
    }

    public SetStampButton(String name, BaseShape setShape, SetStampPen pen) {
        super(name);
        this.setShape = setShape;
        this.stampPen = pen;
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        this.paintListener = listener;
        this.addActionListener(new SetStampAction());
    }

    public void setLocationAndSize(int x, int y) {
        this.setLocation(x, y);
        this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
    }

    private class SetStampAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            stampPen.setDrawStamp(setShape);
        }
    }
}
