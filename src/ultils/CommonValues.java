package ultils;

/**
 * Created by tungbt94 on 16/08/2016.
 */
public class CommonValues {
    public static final String NAME = "Doi Thong";

    public static final int SCREEN_WIDTH = 1260;
    public static final int SCREEN_HEIGHT = 720;
    public static final int THREAD_DELAY = 17;

    public static boolean GAME_RUNNING = true;
    public double toseconds(int threadCount) {
        return ((double)threadCount * THREAD_DELAY)/1000;
    }

}
