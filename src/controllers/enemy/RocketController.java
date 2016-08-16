package controllers.enemy;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlayerController;
import controllers.SingleController;
import models.GameObject;
import models.Rocket;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by DUC on 8/13/2016.
 * Updated by Duong on 8/16/2016.
 */

public class RocketController extends SingleController implements Colliable {
    private static final int SPEED = 15;

    public RocketController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    public static RocketController create(int x, int y, RocketType type) {
        RocketController pineController = null;
        switch (type) {
            case CHICKEN: {
                pineController = new RocketController(
                        new Rocket(x, y),
                        new ImageDrawer("resources/rocket2.png"));
                break;
            }
        }
        return pineController;
    }


    @Override
    public void onCollide(Colliable colliable) {

    }
}
