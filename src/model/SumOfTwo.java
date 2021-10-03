package model;

public class SumOfTwo implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(2)*2;
    }

    @Override
    public String description() {
        return "Somme des 2 ";
    }
}
