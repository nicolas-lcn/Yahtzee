package model;

public class Yahtzee implements Combination{

    public boolean isYahtzee(DiceHand hand) {
        for (int i = 1; i <= 6; i++)
            if (hand.count(i) == 5)
                return true;
        return false;
    }


    @Override
    public int getScore(DiceHand hand) {
        return isYahtzee(hand)? 50 : 0;
    }

    @Override
    public String description() {
        return "Yahtzee";
    }
}
