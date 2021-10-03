package model;

public class SumOfFour implements Combination{
    @Override
    public int getScore(DiceHand hand) {
        return hand.count(4)*4;
    }

    @Override
    public String description() {
        return "Somme des 4";
    }
}
