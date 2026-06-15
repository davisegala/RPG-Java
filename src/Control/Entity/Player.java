package Control.Entity;
import Vision.Game2D.GamePanel;
import Vision.Game2D.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;

public final class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH, String name) {
        super(name);
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
    
    public void update() {
        if (keyH.upPressed == true) {
            y -= speed;
        }
        
        if (keyH.downPressed == true) {
            y += speed;
        }
        
        if (keyH.leftPressed == true) {
            x -= speed;
        }
        
        if (keyH.rightPressed == true) {
            x += speed;
        }
    }
    
    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(x, y, gp.getTileSize(), gp.getTileSize());
    }
}
