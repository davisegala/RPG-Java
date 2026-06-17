package Vision.Game2D.Main;

import Control.Entity.Player;
import Vision.Game2D.Tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    private final KeyHandler keyH = new KeyHandler();
    private Thread gameThread;
    
    // Screen settings
    private final int originalTileSize = 16;
    private final int scale = 3;
    
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;
    
    // Player
    Player player = new Player(this, keyH, "Davi");
    
    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
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
        final long drawInterval = 1000000000L / FPS; 
        long lastTime = System.nanoTime();

        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - lastTime;
            lastTime = currentTime;

            timer += passedTime;
            
            update();
            repaint();
            drawCount++;

            if (timer >= 1000000000L) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            try {
                long executionTime = System.nanoTime() - currentTime;
                long remainingTime = drawInterval - executionTime;
                if (remainingTime > 0) {
                    long sleepTimeMs = remainingTime / 1000000; 
                    int sleepTimeNs = (int) (remainingTime % 1000000);
                    Thread.sleep(sleepTimeMs, sleepTimeNs);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        player.update();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

    public int getTileSize() {
        return tileSize;
    }
}
