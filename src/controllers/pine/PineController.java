package controllers.pine;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.GameObject;
import models.Pine;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by DUC on 8/13/2016.
 */
public class PineController extends SingleController implements Colliable {
    private static final int X_SPEED = -3;
    private static final int Y_SPEED = 0;

    public PineController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = X_SPEED;
        this.getGameVector().dy=Y_SPEED;
        CollsionPool.instance.add(this);
    }

    public static PineController create(int x, int y, PineType type) {
        PineController pineController = null;
        switch (type) {
            case GREEN: {
                pineController = new PineController(
                        new Pine(x, y),
                        new ImageDrawer("resources/wall.png"));
                break;
            }
        }
        return pineController;
    }

    public void run(){
        super.run();
        if (this.getGameObject().getX()<-200) this.getGameObject().destroy();
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
