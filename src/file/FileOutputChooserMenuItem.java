package file;

import drawing.CustomImage;

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
    private CustomImage customImage;

    public FileOutputChooserMenuItem(String name, JFrame frame, CustomImage image, String... extensions) {
        super(name);
        this.fileChooser = new JFileChooser();
        this.frame = frame;
        this.customImage = image;
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
            customImage.fileOutput(fileChooser.getSelectedFile());
        }
    }
}
