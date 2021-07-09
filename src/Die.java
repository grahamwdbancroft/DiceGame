import java.util.Random;

public class Die {

    static int numSides = 6;

    public int rollOneDie() {
        Random myRandom = new Random();
        int n = myRandom.nextInt(numSides);
        n += 1;
        return n;
    }
}
