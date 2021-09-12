import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy {

    public static final int YATZY_SCORE = 50;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;

    private final int[] dices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }

    public int scoreOnes() {
        return calculateScoreByCombination(1);
    }

    public int scoreTwos() {
        return calculateScoreByCombination(2);
    }

    public int scoreThrees() {
        return calculateScoreByCombination(3);
    }

    public int scoreFours() {
        return calculateScoreByCombination(4);
    }

    public int scoreFives() {
        return calculateScoreByCombination(5);
    }

    public int scoreSixes() {
        return calculateScoreByCombination(6);
    }

    public int scoreChance() {
        return Arrays.stream(dices).sum();
    }

    public int scoreYatzy() {
        return isAllDicesValueAreTheSame() ? YATZY_SCORE : 0;
    }

    public int scorePair() {
        return getScoreByOccurrences(2);
    }

    public int scoreTwoPair() {
        int score = 0;
        int occurrences = 2;
        int[] dicesSortedWithoutDuplication = IntStream.of(dices).sorted().distinct().toArray();
        for (int dice : dicesSortedWithoutDuplication) {
            if (countDiceOccurrences(dice, dices) >= occurrences) {
                score += dice * occurrences;
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

    private boolean isAllDicesValueAreTheSame() {
        return Arrays.stream(dices).distinct().count() == 1;
    }

    private Integer getScoreByOccurrences(int occurrences) {
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = dicesSortedDesc.length - 1; i >= 0; i--) {
            if (countDiceOccurrences(dicesSortedDesc[i], dicesSortedDesc) >= occurrences) {
                return occurrences * dicesSortedDesc[i];
            }
        }
        return 0;
    }

    private int countDiceOccurrences(int dice, int[] dices) {
        return (int) Arrays.stream(dices).filter(currentDice -> currentDice == dice).count();
    }

    public int calculateScoreByCombination(int combination) {
        return (int) (Arrays.stream(dices).filter(d -> d == combination).count() * combination);
    }

    private int calculateStraight() {
        int[] dicesSortedDesc = IntStream.of(dices).sorted().toArray();
        for (int i = 0; i < dices.length - 1; i++) {
            if (dicesSortedDesc[i] != dicesSortedDesc[i + 1] - 1) {
                return 0;
            }
        }
        return Arrays.stream(dicesSortedDesc).sum();
    }
}
