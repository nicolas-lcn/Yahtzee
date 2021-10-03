package view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

class DiceDrawer {

  static final double SIDE_LENGTH = 80;

  private static final double MIDDLE = 0.5 * SIDE_LENGTH;
  private static final double WEST_X = 0.25 * SIDE_LENGTH;
  private static final double EAST_X = 0.75 * SIDE_LENGTH;
  private static final double NORTH_Y = 0.25 * SIDE_LENGTH;
  private static final double SOUTH_Y = 0.75 * SIDE_LENGTH;
  private static final Point2D CENTER = new Point2D(MIDDLE, MIDDLE);
  private static final Point2D NORTH_WEST = new Point2D(WEST_X, NORTH_Y);
  private static final Point2D WEST = new Point2D(WEST_X, MIDDLE);
  private static final Point2D SOUTH_WEST = new Point2D(WEST_X, SOUTH_Y);
  private static final Point2D NORTH_EAST = new Point2D(EAST_X, NORTH_Y);
  private static final Point2D EAST = new Point2D(EAST_X, MIDDLE);
  private static final Point2D SOUTH_EAST = new Point2D(EAST_X, SOUTH_Y);


  private static final List<Point2D> ONE_POINTS =
    List.of(CENTER);
  private static final List<Point2D> TWO_POINTS =
    List.of(NORTH_EAST, SOUTH_WEST);
  private static final List<Point2D> THREE_POINTS =
    List.of(NORTH_EAST, CENTER, SOUTH_WEST);
  private static final List<Point2D> FOUR_POINTS =
    List.of(NORTH_EAST, NORTH_WEST, SOUTH_WEST, SOUTH_EAST);
  private static final List<Point2D> FIVE_POINTS =
    List.of(NORTH_EAST, NORTH_WEST, SOUTH_WEST, SOUTH_EAST, CENTER);
  private static final List<Point2D> SIX_POINTS =
    List.of(NORTH_EAST, NORTH_WEST, EAST, WEST, SOUTH_EAST, SOUTH_WEST);


  private static final double DIAMETER = 8;


  void draw(GraphicsContext context, int value, boolean isBlocked) {
    Color backgroundColor = isBlocked ? Color.BLACK : Color.WHITE;
    Color foregroundColor = isBlocked ? Color.WHITE : Color.BLACK;
    context.setFill(backgroundColor);
    context.fillRect(0,0,SIDE_LENGTH,SIDE_LENGTH);
    context.setFill(foregroundColor);
    for (Point2D point : getPoints(value)) {
      context.fillOval(
        point.getX()- DIAMETER/2,
        point.getY() - DIAMETER/2,
        DIAMETER, DIAMETER
      );
    }
  }

  private List<Point2D> getPoints(int value) {
    switch (value) {
      case 1: return ONE_POINTS;
      case 2: return TWO_POINTS;
      case 3: return THREE_POINTS;
      case 4: return FOUR_POINTS;
      case 5: return FIVE_POINTS;
      case 6: return SIX_POINTS;
      default:
    }
    return List.of();
  }


}