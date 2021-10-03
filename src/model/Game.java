package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private List<Die> dice;
  private int nbReRolls;
  private List<ScoreRow> rows;

  public Game() {
    dice = new ArrayList<Die>();
    rows = new ArrayList<ScoreRow>();
    for (int i = 0; i < 5; i++) {
      dice.add(new Die());
    }

    rows.add(new ScoreRow(new Chance()));
    rows.add(new ScoreRow(new SumOfOne()));
    rows.add(new ScoreRow(new SumOfTwo()));
    rows.add(new ScoreRow(new SumOfThree()));
    rows.add(new ScoreRow(new SumOfFour()));
    rows.add(new ScoreRow(new SumOfFive()));
    rows.add(new ScoreRow(new SumOfSix()));
    rows.add(new ScoreRow(new ThreeOfAKind()));
    rows.add(new ScoreRow(new FourOfAKind()));
    rows.add(new ScoreRow(new Yahtzee()));
    rows.add(new ScoreRow(new FullHouse()));
    rows.add(new ScoreRow(new SmallStraight()));
    rows.add(new ScoreRow(new LargeStraight()));


    nbReRolls = 3;
    initialRoll();


  }

  private DiceHand getHand() {
    return new DiceHand(dice);
  }

  public List<Die> getDice() {
    return dice;
  }

  public List<ScoreRow> getRows() {
    return rows;
  }

  public boolean choose(ScoreRow scoreRow) {
    scoreRow.record(getHand());
    if (isOver()){

      return true;
    }

    else {
      initialRoll();
      return false;
    }

  }

  public void reRoll() {
    if (nbReRolls > 1) {
      for (Die die : dice) {
        die.roll();
      }
      nbReRolls -= 1;
    }
  }

  private void unblockDice() {
    for (Die die : dice) {
      die.unblock();
    }
  }

  public void initialRoll() {
    unblockDice();
    nbReRolls = 3;
    for (Die die : dice) {
      die.roll();
    }
  }

  public int getTotalScore() {
    int score = 0;
    int bonus = 0;
    for (ScoreRow row : rows) {
      score += row.getScore();
    }
    for (int i = 1 ; i<=6; i++) {
      bonus += rows.get(i).getScore();
    }

    return bonus>=63? score+35: score;
  }

  private boolean isOver() {
    return rows.stream().allMatch(row -> !row.isAvailable());
  }


}



