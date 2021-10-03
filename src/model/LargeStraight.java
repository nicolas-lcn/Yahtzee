package model;

public class LargeStraight implements Combination {

    private boolean isStraight(DiceHand hand){
            if (hand.count(1)>0 && hand.count(2)>0 && hand.count(3)>0 && hand.count(4)>0 && hand.count(5)>0 || hand.count(2)>0 && hand.count(3)>0 && hand.count(4)>0 && hand.count(5)>0 && hand.count(6)>0 ){
                return true;
            }
            return false;
    }
    @Override
    public int getScore(DiceHand hand) {
        return isStraight(hand)? 40:0;
    }

    @Override
    public String description() {
        return "Grande Suite";
    }
}
