package model;

public class FullHouse implements Combination {

    private boolean isThree(DiceHand hand) {
        for (int i = 1; i <= 6; i++)
            if (hand.count(i) == 3)
                return true;
        return false;

    }

    private boolean isTwo (DiceHand hand){
        for (int i = 1; i<= 6; i++)
            if (hand.count(i)==2)
                return true;
        return false;
    }

    private boolean isFull(DiceHand hand){
        if(isTwo(hand)&&isThree(hand))
            return true;
        return false;
    }

    @Override
    public int getScore(DiceHand hand) {
        return isFull(hand)? 25 : 0 ;
    }

    @Override
    public String description() {
        return "Full";
    }
}
