package controllers.pine;

import controllers.ControllerManager;
import controllers.PlayerController;
import controllers.SingleController;
import models.GameVector;
import ultils.CommonValues;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by DUC on 8/13/2016.
 * Updated by Duong on 8/16/2016.
 */
public class PineControllerManager extends ControllerManager {
    private int count;
    private static final int RESPAWN = 100;

    private PineControllerManager() {
        super();
    }

    public void run(){
        super.run();
        Random rd = new Random();
        int a=rd.nextInt(8)%3;
        System.out.println(a);
        count ++;
        int enX = CommonValues.SCREEN_WIDTH;
        int enY = rd.nextInt(500);
        if (enY<300) enY= 300;
        if(count == RESPAWN ){
            count = 0;
                PineController pineController = PineController.create(
                        enX, enY, PineType.GREEN);
            this.add(pineController);
        }
        Iterator<SingleController> singleControllerIterator = singleControllerVector.iterator();
        while (singleControllerIterator.hasNext()){
            SingleController singleController= singleControllerIterator.next();
            if (singleController.getGameObject().getX() == PlayerController.instance.getGameObject().getX()+120
                && a==0)
                singleController.getGameObject().moveTo(PlayerController.instance.getGameObject().getX()+120,200);
        }
    }

    public static final PineControllerManager instance = new PineControllerManager();
}
