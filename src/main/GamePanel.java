package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {


    // Screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public GamePanel() {
        // set the size of this class
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        // Enabling this can improve game's rendering performance
        this.setDoubleBuffered(true);
    }

    Thread gameThread;

    @Override
    public void run() {

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
}

