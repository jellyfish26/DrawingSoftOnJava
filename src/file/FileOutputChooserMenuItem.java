package file;

import drawing.CustomGraphics2D;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.StringJoiner;

public class FileOutputChooserMenuItem extends JMenuItem {
    private JFrame frame;
    private JFileChooser fileChooser;
    private FileNameExtensionFilter nameFilter;
    private CustomGraphics2D customGraphics;

    public FileOutputChooserMenuItem(String name, JFrame frame, CustomGraphics2D customGraphics, String... extensions) {
        super(name);
        this.fileChooser = new JFileChooser();
        this.frame = frame;
        this.customGraphics = customGraphics;
        StringJoiner joiner = new StringJoiner(",", "","");
        Arrays.stream(extensions).forEach(joiner::add);
        this.nameFilter = new FileNameExtensionFilter(joiner + " Images", extensions);
        fileChooser.setFileFilter(nameFilter);
        this.addActionListener(new KeyClick());
    }

    private class KeyClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            fileChooser.showSaveDialog(frame);
            customGraphics.fileOutput(fileChooser.getSelectedFile());
        }
    }
}
