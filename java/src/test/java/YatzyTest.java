import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = new Yatzy(2, 3, 4, 5, 1).scoreChance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).scoreChance());
    }

    @Test
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4, 4, 4, 4, 4).scoreYatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).scoreYatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).scoreYatzy());
    }

    @Test
    public void test_1s() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).scoreOnes());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).scoreOnes());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).scoreOnes());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).scoreOnes());
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).scoreTwos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).scoreTwos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).scoreThrees());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).scoreThrees());
    }

    @Test
    public void fours_test() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).scoreFours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).scoreFours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).scoreFours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).scoreFives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).scoreFives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).scoreFives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).scoreSixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).scoreSixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).scoreSixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6,new Yatzy(3, 4, 3, 5, 6).scorePair());
        assertEquals(10,new Yatzy(5, 3, 3, 3, 5).scorePair());
        assertEquals(12,new Yatzy(5, 3, 6, 6, 5).scorePair());
        assertEquals(12,new Yatzy(5, 6, 6, 6, 5).scorePair());
    }

    @Test
    public void two_Pair() {
       assertEquals(16, new Yatzy(3, 3, 5, 4, 5).scoreTwoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).scoreTwoPair());
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).scoreThreeOfAKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).scoreThreeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).scoreThreeOfAKind());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).scoreFourOfAKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).scoreFourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).scoreSmallStraight());
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).scoreSmallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).scoreSmallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).scoreSmallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).scoreLargeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).scoreLargeStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).scoreLargeStraight());
        assertEquals(0, new Yatzy(1, 2, 3, 4, 5).scoreLargeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18,new Yatzy(6, 2, 2, 2, 6).scoreFullHouse());
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).scoreFullHouse());
    }
}
