package model;

public class FourOfAKind implements Combination {


    public boolean isFour(DiceHand hand) {
        for (int i = 1; i <= 6; i++)
            if (hand.count(i) >= 4)
                return true;
        return false;


    }

    @Override
    public int getScore(DiceHand hand) {
        return (isFour(hand)) ? hand.sum() : 0;
    }

    @Override
    public String description() {
        return "Four-Of-A-Kind";
    }
}
