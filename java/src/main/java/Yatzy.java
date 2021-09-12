import java.util.Arrays;
import java.util.stream.IntStream;

class Yatzy {

    private static final int YATZY_SCORE = 50;
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;

    private final int[] dice;

    public Yatzy(int[] dice) {
        this.dice = new int[5];
        System.arraycopy(dice, 0, this.dice, 0, this.dice.length);
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
        final int occurrences = 2;
        return IntStream.of(dice).sorted().distinct()
                        .filter(die->this.countDieOccurrences(die) >= occurrences).sum() * occurrences;
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
            if (countDieOccurrences(diceSorted[i], diceSorted) >= occurrences) {
                return occurrences * diceSorted[i];
            }
        }
        return 0;
    }

    private int countDieOccurrences(int die) {
        return countDieOccurrences(die, this.dice);
    }

    private int countDieOccurrences(int die, int[] dice) {
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
