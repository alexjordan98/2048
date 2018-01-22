import java.awt.*;
import java.util.HashMap;

/**
 * Represents a tile in the game 2048, tiles can be any power of 2, stating with 2, but the upper
 * limit for a tile's value depends on the size of the board beinng used to play.
 */
class Tile {

  private int value;
  private Color color;
  private int size = 100;
  private int x;
  private int y;

  /**
   * The main constructor for a tile.
   *
   * @param value the value(a power of 2) of the tile
   * @param color the color.
   * @param x the x coordinate.
   * @param y the y coordinate.
   */
  Tile(int value, Color color, int x, int y) {

    if (color == null || x < 0 || y < 0) {
      throw new IllegalArgumenrExcemption("Invalid Parameters");
    }
    else {
      this.value = value;
      this.colot = color;
      this.x = x;
      this.y = y;
    }
  }

  /**
   * Assigns the value of the tile.
   */
  public void chooseColor() {
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(2, Color.red);
    colors.put(4, Color.blue);
    colors.put(8, Color.green);
    colors.put(16, Color.yellow);
    colors.put(32, Color.magenta);
    colors.put(64, Color.pink);
    colors.put(128, Color.orange);
    colors.put(256, Color.CYAN);
    colors.put(512, Color.DARK_GRAY);
    colors.put(1024, Color.red);
    colors.put(2048, Color.blue);

    this.color = colors.get(this.value);
  }
}
