package model;

public class SumOfFive implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(5)*5;
    }

    @Override
    public String description() {
        return "Somme de 5";
    }
}