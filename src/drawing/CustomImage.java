package drawing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomImage extends BufferedImage {
    public CustomImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public boolean fileOutput(File file) {
        try {
            String extension = file.getName().substring(file.getName().lastIndexOf("."));
            System.out.println(extension);
            if (extension.equals(".png") || extension.equals(".jpg")) {
                return ImageIO.write(this, extension.substring(1), file);
            } else if (extension.isEmpty()) {
                return ImageIO.write(this, "png", new File(file.getPath() + ".png"));
            } else {
                return false;
            }
        } catch (IOException | NullPointerException e) {
            return false;
        }
    }
}
