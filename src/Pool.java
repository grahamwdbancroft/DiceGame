import java.util.ArrayList;

public class Pool {

    private ArrayList<Die> dice;

    public Pool() {
        dice = new ArrayList<Die>();
    }

    public void addDie(Die die) {
        dice.add(die);
    }

    public void removeDie(Die die) {
        dice.remove(die);
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public void removeDiceByValue(int value) {
        ArrayList<Die> diceToRemove = new ArrayList<Die>();
        for (Die die : dice) {
            if(die.getValue() == value) {
                diceToRemove.add(die);
            }
        }
        dice.removeAll(diceToRemove);
    }

    public boolean isEmpty() {
        return dice.isEmpty();
    }

    public boolean containsDieWithValue(int value) {
        for (Die die : dice) {
            if (die.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public Die getLowest() {
        Die lowestDie = null;
        for (Die die : dice) {
            if (lowestDie == null || die.getValue() < lowestDie.getValue()) {
                lowestDie = die;
            }
        }
        return lowestDie;
    }

}
