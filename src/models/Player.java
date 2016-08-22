package models;

/**
 * Created by DUC on 8/13/2016.
 */
public class Player extends GameObject {
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    public Player(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
