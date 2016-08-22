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
    private static final int RESPAWN = 100;
    private int t=13;
    private int count;
    private int countT;

    private PineControllerManager() {
        super();
    }

    public void run(){
        super.run();
        count ++;
        countT ++;
        if (countT==300 && t > 3){
            t-=1;
            countT=0;
        }
        Random rd = new Random();
        int a=rd.nextInt(t);
        int enX = CommonValues.SCREEN_WIDTH;
        int enY = rd.nextInt(10);
        if (enY<3) enY= 3;
        if(count == RESPAWN ){
            count = 0;
                PineController pineController = PineController.create(
                        enX, CommonValues.SCREEN_HEIGHT- enY*50, PineType.GREEN);
            this.add(pineController);
        }
        Iterator<SingleController> singleControllerIterator = singleControllerVector.iterator();
        while (singleControllerIterator.hasNext()){
            SingleController singleController= singleControllerIterator.next();
            if (singleController.getGameObject().getX() == PlayerController.instance.getGameObject().getX()+150
                && a==0)
                singleController.getGameObject().moveTo(PlayerController.instance.getGameObject().getX()+150,
                        CommonValues.SCREEN_HEIGHT-500);
        }
    }

    public static final PineControllerManager instance = new PineControllerManager();
}
