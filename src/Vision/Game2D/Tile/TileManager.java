package Vision.Game2D.Tile;

import Vision.Game2D.Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/grass.png")));

            tile[1] = new Tile();
            tile[1].setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/brick.png")));

            tile[2] = new Tile();
            tile[2].setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/water.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(tile[0].getModel(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
        g.drawImage(tile[1].getModel(), 48, 0, gp.getTileSize(), gp.getTileSize(), null);
        g.drawImage(tile[2].getModel(), 96, 0, gp.getTileSize(), gp.getTileSize(), null);
    }
}
