package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import java.net.URL;
import java.util.*;

import static javafx.scene.layout.Priority.ALWAYS;

public class Controller implements Initializable {

  static final double WIDTH = 450;
  static final double HEIGHT = 650;

  private static final DiceDrawer diceDrawer = new DiceDrawer();

  private ViewModel viewModel;

  @FXML
  private HBox diceBox;

  @FXML
  private HBox scoreBox;

  @FXML
  private GridPane scoreGrid;

  @FXML
  private Button rerollButton;

  @FXML
  private Label scoreLabel;

  private Map<Integer, Canvas> diceCanvas = new HashMap<>();
  private Map<Integer, Button> rowButtons = new HashMap<>();
  private Map<Integer, Label> rowLabels = new HashMap<>();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    viewModel = new ViewModel(this);

    for (int die = 0; die < viewModel.nbDice(); die++) {
      Canvas canvas = new Canvas(DiceDrawer.SIDE_LENGTH, DiceDrawer.SIDE_LENGTH);
      diceCanvas.put(die, canvas);
      diceBox.getChildren().add(canvas);
      int finalDie = die;
      canvas.setOnMouseReleased(event -> viewModel.click(finalDie));
    }
    redrawDices();

    scoreGrid.prefWidth(WIDTH);
    ColumnConstraints colConstr = new ColumnConstraints();
    colConstr.setHgrow(ALWAYS);
    scoreGrid.getColumnConstraints().add(new ColumnConstraints());
    scoreGrid.getColumnConstraints().add(colConstr);
    scoreGrid.getColumnConstraints().add(new ColumnConstraints());

    int lineCount = 0;
    for (int row = 0; row < viewModel.nbRows(); row++) {
      Button button = new Button("Choisir");
      int finalRow = row;
      button.setOnMouseClicked(event -> this.clicked(button, finalRow));
      Label name = new Label(viewModel.getRowDescription(row));
      Label score = new Label(viewModel.getScoreDescription(row));
      rowButtons.put(row, button);
      rowLabels.put(row, score);
      scoreGrid.add(button,0, lineCount);
      scoreGrid.add(name,1, lineCount);
      scoreGrid.add(score, 2, lineCount);
      lineCount++;
    }

    rerollButton.setOnMouseClicked(event -> viewModel.reRoll());
    scoreBox.prefWidth(WIDTH);

  }

  private void clicked(Button button, int row) {
    button.disarm();
    button.setVisible(false);
    viewModel.choose(row);
  }

  void redrawDices() {
    for (int die = 0; die < viewModel.nbDice(); die++) {
      Canvas canvas = diceCanvas.get(die);
      diceDrawer.draw(
        canvas.getGraphicsContext2D(),
        viewModel.getDieValue(die),
        viewModel.isDieBlocked(die));
    }
  }

  void update(int row) {
    Label score = rowLabels.get(row);
    score.setText(viewModel.getScoreDescription(row));
    Button button = rowButtons.get(row);
    button.setVisible(viewModel.isChoosableRow(row));
    redrawScore();
  }

  private void redrawScore() {
    scoreLabel.setText(Integer.toString(viewModel.getTotalScore()));
  }

  void stopGame() {
    rerollButton.setText("Recommencer");
    rerollButton.setOnMouseClicked(this::restart);
  }

  private void restart(MouseEvent mouseEvent) {
    rerollButton.setText("Relancer !");
    viewModel.restart();
    rerollButton.setOnMouseClicked(event -> viewModel.reRoll());
  }
}
