package line;

import listener.MousePaintListener;
import listener.SetMousePaintListener;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class PenBehaviorComboBox extends JComboBox<PenBehavior> implements SetMousePaintListener {

    public PenBehaviorComboBox(PenBehavior... objects) {
        super(objects);
        this.addItemListener(new objectSelect());
    }

    @Override
    public void setMousePaintListener(MousePaintListener listener) {
        for (int objectIndex = 0; objectIndex < getItemCount(); ++objectIndex) {
            if (getItemAt(objectIndex) instanceof SetMousePaintListener) {
                ((SetMousePaintListener) getItemAt(objectIndex)).setMousePaintListener(listener);
            }
        }
    }

    private class objectSelect implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (itemEvent.getStateChange() != ItemEvent.SELECTED) return;
            ((PenBehavior) Objects.requireNonNull(getSelectedItem())).setPenBehavior();
        }
    }
}
