package controllers.enemy;

import controllers.ControllerManager;
import models.Rocket;

import java.util.Random;

/**
 * Created by DUC on 8/13/2016.
 */
public class RocketControllerManager extends ControllerManager {
    private int count;
    private int countT;
    private int Respawn = 200;

    private RocketControllerManager() {
        super();
    }

    public void run(){
        Random rd = new Random();
        super.run();
        count ++;
        countT ++;
        if (countT>=300 && Respawn >40) {
            Respawn -= 20;
            countT=0;
            count=0;
        }
        System.out.println(Respawn);
        int enX = 1000;
        int enY = rd.nextInt(250);
        if (enY<35) enY=35;
        if(count == Respawn){
            count = 0;
            RocketController rocketController = RocketController.create(
                    enX, enY, RocketType.CHICKEN);
            this.add(rocketController);
        }
    }

    public static final RocketControllerManager instance = new RocketControllerManager();
}
