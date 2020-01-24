package line;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface PenBehavior extends MouseMotionListener, MouseListener {
    void setPenBehavior();
    void removePenBehavior();
}
