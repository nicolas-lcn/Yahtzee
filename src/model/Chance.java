package model;

public class Chance implements Combination {

    @Override
    public int getScore(DiceHand hand) {
        return hand.sum();
    }

    @Override
    public String description() {
        return "Chance";
    }
}
