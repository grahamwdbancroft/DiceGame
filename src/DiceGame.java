import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class DiceGame {

    private static final int NUM_DICE = 5;
    private static final int NUM_SIMULATIONS = 10000;

    public static void main(String[] args) {

        Map<Integer, Integer> occurencesOfScores = new HashMap<Integer, Integer>();

        // Simulate the games and keep record of how many times each score occurs
        for (int currentSimulation = 0; currentSimulation < NUM_SIMULATIONS; currentSimulation++) {
            int score = simulateOneGame();

            // Keep record of score
            if (occurencesOfScores.get(score) == null) {
                occurencesOfScores.put(score, 1);
            } else {
                occurencesOfScores.put(score, occurencesOfScores.get(score) + 1);
            }
        }

        // Get and sort all the scores/keys
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(occurencesOfScores);

        // Output the results
        System.out.println("Number of simulations was " + NUM_SIMULATIONS + " using " + NUM_DICE + " dice.");
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println("Total " + entry.getKey() + " occurred " + entry.getValue() + " times.");
        }
    }

    private static int simulateOneGame() {

        Pool myPool = new Pool();
        Rules myRules = new Rules();
        int score = 0;

        for (int i = 0; i < NUM_DICE; i++) {
            myPool.addDie(new Die());
        }

        do {
            myPool.rollDice();
            score += myRules.scorePool(myPool);
            myRules.removeDice(myPool);
        } while (!myPool.isEmpty());

        return score;
    }

}
