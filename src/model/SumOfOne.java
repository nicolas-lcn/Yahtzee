package model;

public class SumOfOne implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(1);
    }

    @Override
    public String description() {
        return "Somme de 1";
    }
}
