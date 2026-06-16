package Vision.Game2D;
import Control.Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public final class Player extends Entity {
    private GamePanel gp;
    private KeyHandler keyH;
    public enum Actions { IDLE, UP, DOWN, LEFT, RIGHT }
    private Actions action = Actions.IDLE;
    private BufferedImage idle1, idle2, up1, up2, down1, down2, left1, left2, right1, right2;

    private final String spritePath = "Sprites/Player/";

    public Player(GamePanel gp, KeyHandler keyH, String name) {
        super(name);
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    private BufferedImage getImage(String fileName) {
        String local = spritePath + fileName;
        try {
            return ImageIO.read(getClass().getResourceAsStream(local));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getPlayerImage() {
        idle1 = getImage("player_idle_1.png");
        idle2 = getImage("player_idle_1.png");
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        action = Actions.IDLE;
    }
    
    public void update() {
        if (keyH.upPressed) {
            action = Actions.UP;
            y -= speed;
        }
        if (keyH.downPressed) {
            action = Actions.DOWN;
            y += speed;
        }
        if (keyH.leftPressed) {
            action = Actions.LEFT;
            x -= speed;
        }
        if (keyH.rightPressed) {
            action = Actions.RIGHT;
            x += speed;
        }
        if (!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
            action = Actions.IDLE;
        }
    }
    
    public void draw(Graphics2D g) {
        BufferedImage image = null;

        switch (action){
            case IDLE -> image = idle1;
            case UP -> image = up1;
            case DOWN -> image = down1;
            case LEFT -> image = left1;
            case RIGHT -> image = right1;
        }

        g.drawImage(image, x, y, gp.getTileSize()*2, gp.getTileSize()*2, null);
    }
}
