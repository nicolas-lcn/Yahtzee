package model;

public class ThreeOfAKind implements Combination {

    public boolean isThree(DiceHand hand) {
        for (int i = 1; i <= 6; i++)
            if (hand.count(i) >= 3)
                return true;
        return false;
    }

    @Override
    public int getScore(DiceHand hand) {
        return isThree(hand) ? hand.sum() : 0;
    }

    @Override
    public String description() {
        return "Three-Of-A-Kind";
    }
}
