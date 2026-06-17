package Vision.Game2D.Main;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public interface Model {
    default BufferedImage setupImage(String path, GamePanel gp) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream(path));
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration();
            BufferedImage optimizedImage = gc.createCompatibleImage(gp.getTileSize(), gp.getTileSize(), image.getTransparency());

            Graphics2D g2 = optimizedImage.createGraphics();
            g2.drawImage(image, 0, 0, gp.getTileSize(), gp.getTileSize(), null);
            g2.dispose();

            return optimizedImage;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
