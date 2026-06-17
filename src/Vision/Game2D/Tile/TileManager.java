package Vision.Game2D.Tile;

import Vision.Game2D.Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class TileManager {
    private enum tileType { GRASS, BRICK, WATER }
    private final GamePanel gp;
    private final Map<tileType, Tile> tile = new EnumMap<>(tileType.class);

    public TileManager(GamePanel gp) {
        this.gp = gp;
        getTileImage();
    }

    public void getTileImage() {
        try {
            
            tile.put(tileType.GRASS, new Tile());
            tile.get(tileType.GRASS).setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/grass.png")));
            
            tile.put(tileType.BRICK, new Tile());
            tile.get(tileType.BRICK).setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/brick.png")));
            
            tile.put(tileType.WATER, new Tile());
            tile.get(tileType.WATER).setModel(ImageIO.read(getClass().getResourceAsStream("/Model/Tiles/water.png")));

        } catch (IOException e) {}
    }

    public void draw(Graphics2D g) {
        addTile(tileType.GRASS, 0, 0, g);
        addTile(tileType.BRICK, 1, 0, g);
        addTile(tileType.WATER, 2, 0, g);
    }
    
    public void addTile(tileType tileType, int x, int y, Graphics2D g) {
        g.drawImage(tile.get(tileType).getModel(), x * 48, y * 48, gp.getTileSize(), gp.getTileSize(), null);
    }
}
