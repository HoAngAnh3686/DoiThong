package controllers;

import controllers.enemy.RocketController;
import controllers.pine.PineController;
import models.GameObject;
import models.Player;
import ultils.CommonValues;
import ultils.Ultils;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by DUC on 8/14/2016.
 * Updated by Duong on 8/16/2016.
 */
public class PlayerController extends SingleController implements KeyListener, Colliable{

    private GameInput gameInput;
    private static final int FLY_SPEED = 7;
    private static final int DROP_SPEED = 9;

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
    }

    public static final PlayerController instance = new PlayerController(
            new Player(300, 200),
            new ImageDrawer("resources/bird.png")
    );

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
           case KeyEvent.VK_SPACE:
               this.gameInput.keySpace = true;
               break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
                break;
        }
    }

    public void draw(Graphics g){
        super.draw(g);
    }

    public void run(){
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if (gameInput.keySpace) {
            this.gameVector.dy = -FLY_SPEED;
            Ultils.playSound("resources/sound3.wav",false);
        }
        if(gameInput.keySpace == false){
            this.gameVector.dy = DROP_SPEED;
        }
        if (PlayerController.instance.getGameObject().getY()<=0)
            PlayerController.instance.getGameObject().moveTo(PlayerController.instance.getGameObject().getX(),0);
        super.run();
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof RocketController || colliable instanceof PineController){
            gameObject.destroy();
            System.out.println("colliable");
            CommonValues.GAME_RUNNING = false;
            System.exit(0);
        }
    }
}
