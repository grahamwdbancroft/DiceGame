import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DiceGame {

    private static final int THREE_DIE = 3;
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

        Die myDie = new Die();
        int score = 0;

        int numDiceInPlay = NUM_DICE;

        while (numDiceInPlay > 0) {
            int[] comeOut = new int[numDiceInPlay];

            // Roll all the dice
            for (int i = 0; i < numDiceInPlay; i++) {
                comeOut[i] = myDie.roll();
            }
            Arrays.sort(comeOut);

            // If there are any 3's, remove those dice and score 0
            if (Arrays.asList(comeOut).contains(THREE_DIE)) {
                int numThrees = 0;
                for (int i = 0; i < numDiceInPlay; i++) {
                    if (comeOut[i] == THREE_DIE) {
                        numThrees++;
                    }
                }
                numDiceInPlay -= numThrees;
            } else {
                // Remove and score the lowest die
                numDiceInPlay--;
                score += comeOut[0];
            }
        }

        return score;
    }

}
