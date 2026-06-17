package Vision.Game2D.Main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("teste");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.setSize(gamePanel.getScreenWidth(), gamePanel.getScreenHeight());

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
