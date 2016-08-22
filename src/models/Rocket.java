package models;

/**
 * Created by DUC on 8/13/2016.
 */
public class Rocket extends GameObject {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 25 ;
    public Rocket(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
