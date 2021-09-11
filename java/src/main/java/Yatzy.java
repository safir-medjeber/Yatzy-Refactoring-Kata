import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy {

    private int[] dices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }

    public int chance() {
        return Arrays.stream(dices).sum();
    }

    public int calculatePoints(int combination) {
        return (int) (Arrays.stream(dices).filter(d -> d == combination).count() * combination);
    }

    public int ones() {
        return calculatePoints(1);
    }

    public int twos() {
        return calculatePoints(2);
    }

    public int threes() {
        return calculatePoints(3);
    }

    public int fours() {
        return calculatePoints(4);
    }

    public int fives() {
        return calculatePoints(5);
    }

    public int sixes() {
        return calculatePoints(6);
    }

    public int yatzy() {
        for (int i = 0; i < dices.length - 1; i++) {
            if (dices[i] != dices[i + 1]) {
                return 0;
            }
        }
        return 50;
    }

    public int score_pair() {
        int combination = 2;
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = dicesSortedDesc.length - 1; i >= 0; i--) {
            if (countDiceOccurrences(dicesSortedDesc[i], dicesSortedDesc) >= combination) {
                return combination * dicesSortedDesc[i];
            }
        }
        return 0;
    }

    private int countDiceOccurrences(int dice, int[] dices) {
        return (int) Arrays.stream(dices).filter(currentDice -> currentDice == dice).count();
    }

    public  int two_pair() {
        int score = 0;
        int[] dicesSortedWithoutDuplication = IntStream.of(dices).sorted().distinct().toArray();
        int combination = 2;
        for (int i = 0; i < dicesSortedWithoutDuplication.length; i++) {
            if (countDiceOccurrences(dicesSortedWithoutDuplication[i], dices) >= combination) {
                score += dicesSortedWithoutDuplication[i]* combination;
            }
        }
        return score;
    }

    public int three_of_a_kind() {
        int combination = 3;
        return getScore(combination);
    }

    public  int four_of_a_kind() {
        int combination = 4;
        return getScore(combination);
    }

    private Integer getScore(int combination) {
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = dicesSortedDesc.length - 1; i >= 0; i--) {
            if (countDiceOccurrences(dicesSortedDesc[i], dicesSortedDesc) >= combination) {
                return combination * dicesSortedDesc[i];
            }
        }
        return 0;
    }

    public  int smallStraight() {
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = 0; i < dices.length - 1; i++) {
            if (dicesSortedDesc[i] != dicesSortedDesc[i + 1] -1) {
                return 0;
            }
        }
        return 20;
    }

    public  int fullHouse() {
        int pair = score_pair();
        int three = three_of_a_kind();
        if( pair + three == Arrays.stream(dices).sum())
            return pair + three;
        return 0;
    }
}
