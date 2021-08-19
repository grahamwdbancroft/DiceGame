import java.util.Random;

public class Die {

    private static final int NUM_SIDES = 6;
    private int value;

    public int roll() {
        Random myRandom = new Random();
        value = myRandom.nextInt(NUM_SIDES) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

}
