import controllers.CollsionPool;
import controllers.PlayerController;
import controllers.enemy.RocketControllerManager;
import controllers.pine.PineControllerManager;
import models.Player;
import ultils.CommonValues;
import ultils.Ultils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by DUC on 8/13/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

    public GameWindow(){
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setSize(CommonValues.SCREEN_WIDTH, CommonValues.SCREEN_HEIGHT);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(PlayerController.instance);

        background = Ultils.loadImage("resources/background2.jpg");
        this.bufferedImage = new BufferedImage(CommonValues.SCREEN_WIDTH,CommonValues.SCREEN_HEIGHT,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);

        PlayerController.instance.draw(bufferImageGraphic);
        PineControllerManager.instance.draw(bufferImageGraphic);
        RocketControllerManager.instance.draw(bufferImageGraphic);

        g.drawImage(bufferedImage, -14, 0, null);

    }

    @Override
    public void run() {
        while (CommonValues.GAME_RUNNING) {
            try {
                PlayerController.instance.run();
                PineControllerManager.instance.run();
//                RocketControllerManager.instance.run();
                CollsionPool.instance.run();

                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.exit(0);
    }
}

