import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DiceGame {

    static int numDice = 5;
    static int numSimulations = 10000;

    public static void main(String[] args) {

        Map<Integer, Integer> occurencesOfScores = new HashMap<Integer, Integer>();

        // Simulate the games and keep record of how many times each score occurs
        for (int currentSimulation = 0; currentSimulation < numSimulations; currentSimulation++) {
            int score = simulateOneGame();

            // Keep record of score
            if (occurencesOfScores.get(score) == null) {
                occurencesOfScores.put(score, 1);
            } else {
                occurencesOfScores.put(score, occurencesOfScores.get(score) + 1);
            }
        }

        // Get and sort all the scores/keys
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(occurencesOfScores);

        // Output the results
        System.out.println("Number of simulations was " + numSimulations + " using " + numDice + " dice.");
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println("Total " + entry.getKey() + " occurred " + entry.getValue() + " times.");
        }
    }

    private static int simulateOneGame() {

        Die myDie = new Die();
        int score = 0;

        int numDiceInPlay = numDice;

        while (numDiceInPlay > 0) {
            int[] comeOut = new int[numDiceInPlay];

            // Roll all the dice
            for (int i = 0; i < numDiceInPlay; i++) {
                comeOut[i] = myDie.rollOneDie();
            }
            Arrays.sort(comeOut);

            // If there are any 3's, remove those dice and score 0
            if (Arrays.asList(comeOut).contains(3)) {
                int numThrees = 0;
                for (int i = 0; i < numDiceInPlay; i++) {
                    if (comeOut[i] == 3) {
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
