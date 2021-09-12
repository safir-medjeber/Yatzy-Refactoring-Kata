import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy {

    public static final int YATZY_SCORE = 50;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;

    private final int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int scoreOnes() {
        return calculateScoreByCombinationOf(1);
    }

    public int scoreTwos() {
        return calculateScoreByCombinationOf(2);
    }

    public int scoreThrees() {
        return calculateScoreByCombinationOf(3);
    }

    public int scoreFours() {
        return calculateScoreByCombinationOf(4);
    }

    public int scoreFives() {
        return calculateScoreByCombinationOf(5);
    }

    public int scoreSixes() {
        return calculateScoreByCombinationOf(6);
    }

    public int scoreChance() {
        return Arrays.stream(dice).sum();
    }

    public int scoreYatzy() {
        return isAllDiceHasSameValue() ? YATZY_SCORE : 0;
    }

    public int scorePair() {
        return getScoreByOccurrences(2);
    }

    public int scoreTwoPair() {
        int score = 0;
        int occurrences = 2;
        int[] dicesSortedWithoutDuplication = IntStream.of(dice).sorted().distinct().toArray();
        for (int die : dicesSortedWithoutDuplication) {
            if (countDiceOccurrences(die, this.dice) >= occurrences) {
                score += die * occurrences;
            }
        }
        return score;
    }

    public int scoreThreeOfAKind() {
        return getScoreByOccurrences(3);
    }

    public int scoreFourOfAKind() {
        return getScoreByOccurrences(4);
    }

    public int scoreSmallStraight() {
        return calculateStraight() == SMALL_STRAIGHT_SCORE ? SMALL_STRAIGHT_SCORE : 0;
    }

    public int scoreFullHouse() {
        return scorePair() + scoreThreeOfAKind() == scoreChance() ? scoreChance() : 0;
    }

    public int scoreLargeStraight() {
        return calculateStraight() == LARGE_STRAIGHT_SCORE ? LARGE_STRAIGHT_SCORE : 0;
    }

    private boolean isAllDiceHasSameValue() {
        return Arrays.stream(dice).distinct().count() == 1;
    }

    private Integer getScoreByOccurrences(int occurrences) {
        int[] diceSorted = IntStream.of(dice).sorted().toArray();
        for (int i = diceSorted.length - 1; i >= 0; i--) {
            if (countDiceOccurrences(diceSorted[i], diceSorted) >= occurrences) {
                return occurrences * diceSorted[i];
            }
        }
        return 0;
    }

    private int countDiceOccurrences(int die, int[] dice) {
        return (int) Arrays.stream(dice).filter(currentDie -> currentDie == die).count();
    }

    public int calculateScoreByCombinationOf(int combination) {
        return (int) (Arrays.stream(dice).filter(currentDie -> currentDie == combination).count() * combination);
    }

    private int calculateStraight() {
        int[] diceSorted = IntStream.of(dice).sorted().toArray();
        for (int i = 0; i < dice.length - 1; i++) {
            if (diceSorted[i] != diceSorted[i + 1] - 1) {
                return 0;
            }
        }
        return scoreChance();
    }
}
