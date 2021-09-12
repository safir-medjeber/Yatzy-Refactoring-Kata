import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void act_score_chance_should_sum_all_dice() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{2, 3, 4, 5, 1});
        Yatzy yatzyCase2 = new Yatzy(new int[]{3, 3, 4, 5, 1});

        int resultCase1 = yatzyCase1.scoreChance();
        int resultCase2 = yatzyCase2.scoreChance();

        assertEquals(15, resultCase1);
        assertEquals(16, resultCase2);
    }

    @Test
    public void given_all_dice_with_same_number_should_return_50() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{4, 4, 4, 4, 4});
        Yatzy yatzyCase2 = new Yatzy(new int[]{6, 6, 6, 6, 6});
        Yatzy yatzyCase3 = new Yatzy(new int[]{6, 6, 6, 6, 3});

        int resultCase1 = yatzyCase1.scoreYatzy();
        int resultCase2 = yatzyCase2.scoreYatzy();
        int resultCase3 = yatzyCase3.scoreYatzy();

        assertEquals(50, resultCase1);
        assertEquals(50, resultCase2);
        assertEquals(0, resultCase3);
    }

    @Test
    public void act_score_ones_should_sum_all_dice_with_value_1() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{1, 2, 3, 4, 5});
        Yatzy yatzyCase2 = new Yatzy(new int[]{1, 2, 1, 4, 5});
        Yatzy yatzyCase3 = new Yatzy(new int[]{6, 2, 2, 4, 5});
        Yatzy yatzyCase4 = new Yatzy(new int[]{1, 2, 1, 1, 1});

        int resultCase1 = yatzyCase1.scoreOnes();
        int resultCase2 = yatzyCase2.scoreOnes();
        int resultCase3 = yatzyCase3.scoreOnes();
        int resultCase4 = yatzyCase4.scoreOnes();

        assertEquals(1, resultCase1);
        assertEquals(2, resultCase2);
        assertEquals(0, resultCase3);
        assertEquals(4, resultCase4);
    }

    @Test
    public void act_score_twos_should_sum_all_dice_with_value_2() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{1, 2, 3, 2, 6});
        Yatzy yatzyCase2 = new Yatzy(new int[]{2, 2, 2, 2, 2});

        int resultCase1 = yatzyCase1.scoreTwos();
        int resultCase2 = yatzyCase2.scoreTwos();

        assertEquals(4, resultCase1);
        assertEquals(10, resultCase2);
    }

    @Test
    public void act_score_threes_should_sum_all_dice_with_value_3() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{1, 2, 3, 2, 3});
        Yatzy yatzyCase2 = new Yatzy(new int[]{2, 3, 3, 3, 3});

        int resultCase1 = yatzyCase1.scoreThrees();
        int resultCase2 = yatzyCase2.scoreThrees();

        assertEquals(6, resultCase1);
        assertEquals(12, resultCase2);
    }

    @Test
    public void act_score_fours_should_sum_all_dice_with_value_4() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{4, 4, 4, 5, 5});
        Yatzy yatzyCase2 = new Yatzy(new int[]{4, 4, 5, 5, 5});
        Yatzy yatzyCase3 = new Yatzy(new int[]{4, 5, 5, 5, 5});

        int resultCase1 = yatzyCase1.scoreFours();
        int resultCase2 = yatzyCase2.scoreFours();
        int resultCase3 = yatzyCase3.scoreFours();

        assertEquals(12, resultCase1);
        assertEquals(8, resultCase2);
        assertEquals(4, resultCase3);
    }

    @Test
    public void act_score_fives_should_sum_all_dice_with_value_5() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{4, 4, 4, 5, 5});
        Yatzy yatzyCase2 = new Yatzy(new int[]{4, 4, 5, 5, 5});
        Yatzy yatzyCase3 = new Yatzy(new int[]{4, 5, 5, 5, 5});

        int resultCase1 = yatzyCase1.scoreFives();
        int resultCase2 = yatzyCase2.scoreFives();
        int resultCase3 = yatzyCase3.scoreFives();

        assertEquals(10, resultCase1);
        assertEquals(15, resultCase2);
        assertEquals(20, resultCase3);
    }

    @Test
    public void act_score_sixes_should_sum_all_dice_with_value_6() {
        Yatzy yatzyCase1 = new Yatzy(new int[]{4, 4, 4, 5, 5});
        Yatzy yatzyCase2 = new Yatzy(new int[]{4, 4, 6, 5, 5});
        Yatzy yatzyCase3 = new Yatzy(new int[]{6, 5, 6, 6, 5});

        int resultCase1 = yatzyCase1.scoreSixes();
        int resultCase2 = yatzyCase2.scoreSixes();
        int resultCase3 = yatzyCase3.scoreSixes();

        assertEquals(0, resultCase1);
        assertEquals(6, resultCase2);
        assertEquals(18, resultCase3);
    }

    @Test
    public void one_pair() {
        assertEquals(6,new Yatzy(new int[]{3, 4, 3, 5, 6}).scorePair());
        assertEquals(10,new Yatzy(new int[]{5, 3, 3, 3, 5}).scorePair());
        assertEquals(12,new Yatzy(new int[]{5, 3, 6, 6, 5}).scorePair());
        assertEquals(12,new Yatzy(new int[]{5, 6, 6, 6, 5}).scorePair());
    }

    @Test
    public void two_Pair() {
       assertEquals(16, new Yatzy(new int[]{3, 3, 5, 4, 5}).scoreTwoPair());
        assertEquals(16, new Yatzy(new int[]{3, 3, 5, 5, 5}).scoreTwoPair());
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, new Yatzy(new int[]{3, 3, 3, 4, 5}).scoreThreeOfAKind());
        assertEquals(15, new Yatzy(new int[]{5, 3, 5, 4, 5}).scoreThreeOfAKind());
        assertEquals(9, new Yatzy(new int[]{3, 3, 3, 3, 5}).scoreThreeOfAKind());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(new int[]{3, 3, 3, 3, 5}).scoreFourOfAKind());
        assertEquals(20, new Yatzy(new int[]{5, 5, 5, 4, 5}).scoreFourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(new int[]{1, 2, 3, 4, 5}).scoreSmallStraight());
        assertEquals(0, new Yatzy(new int[]{2, 3, 4, 5, 6}).scoreSmallStraight());
        assertEquals(15, new Yatzy(new int[]{2, 3, 4, 5, 1}).scoreSmallStraight());
        assertEquals(0, new Yatzy(new int[]{1, 2, 2, 4, 5}).scoreSmallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(new int[]{6, 2, 3, 4, 5}).scoreLargeStraight());
        assertEquals(20, new Yatzy(new int[]{2, 3, 4, 5, 6}).scoreLargeStraight());
        assertEquals(0, new Yatzy(new int[]{1, 2, 2, 4, 5}).scoreLargeStraight());
        assertEquals(0, new Yatzy(new int[]{1, 2, 3, 4, 5}).scoreLargeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18,new Yatzy(new int[]{6, 2, 2, 2, 6}).scoreFullHouse());
        assertEquals(0, new Yatzy(new int[]{2, 3, 4, 5, 6}).scoreFullHouse());
    }
}
