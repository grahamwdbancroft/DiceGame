public class Rules {

    private static final int THREE_DIE = 3;

    public int scorePool(Pool pool) {
        if(pool.containsDieWithValue(THREE_DIE)) {
            return 0;
        } else {
            return pool.getLowest().getValue();
        }
    }

    public void removeDice(Pool pool) {
        if (pool.containsDieWithValue(THREE_DIE)) {
            pool.removeDiceByValue(THREE_DIE);
        } else {
            pool.removeDie(pool.getLowest());
        }
    }
}
