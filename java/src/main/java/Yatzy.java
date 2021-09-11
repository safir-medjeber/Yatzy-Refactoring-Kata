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
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = dicesSortedDesc.length - 1; i >= 0; i--) {
            if (countDiceOccurrences(dicesSortedDesc[i], dicesSortedDesc) == 2) {
                return 2 * dicesSortedDesc[i];
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
        for (int i = 0; i < dicesSortedWithoutDuplication.length; i++) {
            if (countDiceOccurrences(dicesSortedWithoutDuplication[i], dices) >= 2) {
                score += dicesSortedWithoutDuplication[i]* 2;
            }
        }
        return score;
    }

    public int three_of_a_kind() {
        int[] t;
        t = new int[6];
        t[dices[0] - 1]++;
        t[dices[1] - 1]++;
        t[dices[2] - 1]++;
        t[dices[3] - 1]++;
        t[dices[4] - 1]++;
        for (int i = 0; i < 6; i++) {
            if (t[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public  int four_of_a_kind() {
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1]++;
        tallies[dices[1] - 1]++;
        tallies[dices[2] - 1]++;
        tallies[dices[3] - 1]++;
        tallies[dices[4] - 1]++;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
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
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public  int fullHouse() {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        }
        else {
            return 0;
        }
    }
}
