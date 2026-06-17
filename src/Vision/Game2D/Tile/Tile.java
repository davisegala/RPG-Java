package Vision.Game2D.Tile;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage model;
    private boolean isCollision = false;

    public boolean isCollision() {
        return isCollision;
    }

    public void setCollision(boolean collision) {
        isCollision = collision;
    }

    public BufferedImage getModel() {
        return model;
    }

    public void setModel(BufferedImage model) {
        this.model = model;
    }
}
