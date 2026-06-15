package Vision.Game2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    private KeyHandler KeyH = new KeyHandler();
    private Thread gameThread;
    
    // Screen settings
    private final int originalTileSize = 16;
    private final int scale = 3;
    
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;
    
    // FPS
    int FPS = 60;
    
    // Set player's defalt position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update() {
        if (KeyH.upPressed == true) playerY -= playerSpeed;
        if (KeyH.downPressed == true) playerY += playerSpeed;
        if (KeyH.leftPressed == true) playerX -= playerSpeed;
        if (KeyH.rightPressed == true) playerX += playerSpeed;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g; 
        
        g2.setColor(Color.white);
        
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        
        g2.dispose();
    }
}
