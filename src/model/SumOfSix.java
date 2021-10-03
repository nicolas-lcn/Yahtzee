package model;

public class SumOfSix implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(6)*6;
    }

    @Override
    public String description() {
        return "Somme des 6";
    }
}