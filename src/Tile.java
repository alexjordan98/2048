import java.awt.*;
import java.util.HashMap;

import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;

class Tile {

  int value;
  Color color;
  int size = 100;
  int x;
  int y;
  
  Tile(int value, int x, int y) {
    
    this.value = value;
    this.x = x;
    this.y = y;
  }
  
  
  // Renders the tile
  public WorldImage renderTile() {
    return new OverlayImage(new TextImage(Integer.toString(this.value), color.BLACK),
        new RectangleImage(this.size, this.size, "solid", this.color));
  }
  
  
  
  
  

  // Assigns the color of the cell
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
