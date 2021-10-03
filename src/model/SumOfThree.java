package model;

public class SumOfThree implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(3)*3;
    }

    @Override
    public String description() {
        return "Somme des 3";
    }
}
