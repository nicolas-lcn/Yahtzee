package model;

public class ScoreRow {

  private int score;
  private boolean isFilled;
  private Combination combination;


  public ScoreRow(Combination comb) {
    this.combination = comb;
    this.score = 0;
    this.isFilled = false;
  }

  public void reset() {
    this.score = 0;
    this.isFilled = false;
  }

  public String description() {
    return combination.description();
  }

  public boolean isAvailable() {
    return !isFilled;
  }

  public int getScore() {
    return score;
  }

  public void record (DiceHand hand){
    if (isAvailable()){
      this.score = combination.getScore(hand);
      this.isFilled = true;
    }
  }
}
