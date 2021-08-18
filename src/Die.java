import java.util.Random;

public class Die {

    private static final int NUM_SIDES = 6;

    public int roll() {
        Random myRandom = new Random();
        return myRandom.nextInt(NUM_SIDES) + 1;
    }
}
