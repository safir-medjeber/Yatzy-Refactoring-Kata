import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class Yatzy {

    private int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int calculatePoints(int combinaison) {
        return (int) (Arrays.stream(dice).filter(d -> d == combinaison).count() * combinaison);
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
        for (int i = 0; i < dice.length - 1; i++) {
            if (dice[i] != dice[i + 1]) {
                return 0;
            }
        }
        return 50;
    }

    public int score_pair() {
        int[] dicesSortedDesc = IntStream.of(dice).sorted().toArray();
        for (int i = dicesSortedDesc.length - 1; i >= 0; i--) {
            if (countOccurrences(dicesSortedDesc[i], dicesSortedDesc) == 2) {
                return 2 * dicesSortedDesc[i];
            }
        }
        return 0;
    }

    private int countOccurrences(int element, int[] dicesSorted) {
        return (int) Arrays.stream(dicesSorted).filter(r -> r == element).count();
    }

    public  int two_pair() {
        int score = 0;
        int[] dicesSortedWithoutDuplication = IntStream.of(dice).sorted().distinct().toArray();
        for (int i = 0; i < dicesSortedWithoutDuplication.length; i++) {
            if (countOccurrences(dicesSortedWithoutDuplication[i], dice) >= 2) {
                score += (dicesSortedWithoutDuplication[i]* 2);
            }
        }
        return score;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++) {
            if (t[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

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
