package view;

import model.Die;
import model.Game;
import model.ScoreRow;

class ViewModel {



  private Game game;
  private Controller controller;


  ViewModel(Controller controller) {
    this.controller = controller;
    this.game = new Game();
  }



  void click(int dieIndex) {
    Die die = game.getDice().get(dieIndex);
    if (die.isBlocked()) {
      die.unblock();
    } else {
      die.block();
    }
    controller.redrawDices();
  }

  void choose(int row) {
    ScoreRow scoreRow = game.getRows().get(row);
    boolean isOver = game.choose(scoreRow);
    controller.update(row);

    if (isOver) {
      controller.stopGame();
    } else {
      controller.redrawDices();
    }
  }


  void reRoll() {
    game.reRoll();
    controller.redrawDices();
  }

  void restart() {
    for (int row = 0; row < game.getRows().size(); row++) {
      game.getRows().get(row).reset();
      controller.update(row);
    }
    game.initialRoll();
    controller.redrawDices();
  }

  int getTotalScore() {
    return game.getTotalScore();
  }

  int nbDice() {
    return game.getDice().size();
  }

  int nbRows() {
    return game.getRows().size();
  }

  String getRowDescription(int row) {
    ScoreRow scoreRow = game.getRows().get(row);
    return scoreRow.description();
  }

  int getDieValue(int die) {
    return game.getDice().get(die).value();
  }

  boolean isDieBlocked(int die) {
    return game.getDice().get(die).isBlocked();
  }

  boolean isChoosableRow(int row) {
    return game.getRows().get(row).isAvailable();
  }

  String getScoreDescription(int row) {
    ScoreRow scoreRow = game.getRows().get(row);
    return scoreRow.isAvailable() ? "???" : String.valueOf(scoreRow.getScore());
  }
}
