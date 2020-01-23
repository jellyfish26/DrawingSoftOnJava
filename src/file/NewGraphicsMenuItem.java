package file;

import drawing.CustomGraphics2D;

import javax.swing.*;
import java.awt.*;

public class NewGraphicsMenuItem extends JMenuItem {
    private Color backgroundColor;
    private CustomGraphics2D customGraphics;

    public NewGraphicsMenuItem(String name, CustomGraphics2D customGraphics, Color backgroundColor) {
        super(name);
        this.backgroundColor = backgroundColor;
        this.customGraphics = customGraphics;
        this.addActionListener(e -> this.customGraphics.newGraphics(this.backgroundColor));
    }
}
