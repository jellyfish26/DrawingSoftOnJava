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
        private Object beforeObject;

        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                ((PenBehavior) Objects.requireNonNull(getSelectedItem())).setPenBehavior();
                beforeObject = getSelectedItem();
            } else if (itemEvent.getStateChange() == ItemEvent.DESELECTED && beforeObject != null) {
                ((PenBehavior) Objects.requireNonNull(beforeObject)).removePenBehavior();
            }
        }
    }
}
