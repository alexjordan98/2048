import java.util.*;

/**
 * This class represents a board in the game 2048, it is the place where all the tiles are places.
 */
public class Board {

  /**
   * @param board a List of Tiles.
   * @param length, the length of the board.
   */
  private List<Tile> board;
  private int length = 4;

  /**
   * Initializes the board.
   */
  public void buildBoard() {
    
   HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();
   
   int randomXY = (int) (Math.random() * 4 + 0);


   int randomTile = (int) (Math.random() * 5 + 1);
   
   Tile tile2 = new Tile(2, randomXY, randomXY);
   Tile tile4 = new Tile(4, randomXY, randomXY);
   
   tiles.put(1, tile2);
   tiles.put(2, tile2);
   tiles.put(3, tile2);
   tiles.put(4, tile2);
   tiles.put(5, tile4);

   board.add(tiles.get(randomTile));
   board.add(tiles.get(randomTile));       
  }

  /**
   * Adds tiles to the board if a key is pressed.
   * @param ke a string.
   */
  public void AddTiles(String ke) {
    
    HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();

    int randomXY = (int) (Math.random() * 4 + 0);
    int randomTile = (int) (Math.random() * 5 + 1);
    int randomTile2 = (int) (Math.random() * 5 + 1);

    
    Tile tile2 = new Tile(2, randomXY, randomXY);
    Tile tile4 = new Tile(4, randomXY, randomXY);
    
    tiles.put(1, tile2);
    tiles.put(2, tile2);
    tiles.put(3, tile2);
    tiles.put(4, tile2);
    tiles.put(5, tile4);
    
    if (ke.equals("up") 
        || ke.equals("down") 
        || ke.equals("left")
        || ke.equals("right")) {
      
      for(Tile t : board) {
        
        Tile ourTile = tiles.get(randomTile);        
        if (t.x == ourTile.x && t.y == ourTile.y) {
          ourTile = tiles.get(randomTile2);
        }
        else { 
          board.add(ourTile);
          }
      }      
    }    
  }
  

  /**
   * Increases the value ofa tile if it is merged with another tile of the same number;
   * the result is that the value of the tile is squared.
   * @param t a tile.
   * @param ke a key.
   */
  public void changeValue(Tile t, String ke) {
    if (ke.equals("up")) {      
      while (t.x > 0) {
        
        if (this.tileAbove(t)) {
          this.tileAboveSame(t);
        }
        else{t.x--;}
      }
    }
    if (ke.equals("down")) {      
      while (t.x < length) {
        
        if (this.tileBelow(t)) {
          this.tileBelowSame(t);
        }
        else{t.x++;}

      }
    }
    if (ke.equals("left")) {      
      while (t.y > 0) {
        
        if (this.tileLeft(t)) {
          this.tileLeftSame(t);
        }
        else{t.y--;}

        
      }
    }
    if (ke.equals("right")) {      
      while (t.y < length) {
        
        if (this.tileRight(t)) {
          this.tileRightSame(t);
        }
        else{t.y++;}

      }
    }
  }

  /**
   * Checks if there is a tile in the path of the given tile.
   * @param t tile.
   * @param degrees the direction pointing at in degrees
   * @return a boolean.
   */
  public boolean tileAbove(Tile t, int degrees) {
    
    boolean b = false;

    // up
    if (degrees == 90) {
      for (Tile t2 : board) {
        if (t2.y == t.y - 1) {
          b = true;
        }
      }
    }


    // left
    if (degrees == 180) {
      for(Tile t2 : board) {

        if(t2.x == t.x + 1) {
          b = true;
        }
      }
    }

    // dowmn
    if (degrees == 270) {
      for(Tile t2 : board) {
        if(t2.y == t.y + 1) {
          b = true;
        }
      }
    }

    //right
    if (degrees == 0) {
      for(Tile t2 : board) {
        if (t2.x == t.x - 1) {
          b = true;
        }
      }
    }
    return b;
  }


  /**
   * Checks if the above tile's value is the same as the given tile's, removes above tile,
   * decreases the value of the tile's x.
   *
   * @param degrees an int representing direction in degrees.
   * @param t a tile.
   */
  public void tileAboveSame(Tile t, int degrees) {

    // up
    if (degrees == 90) {
      for (Tile t2 : board) {
        if (t2.y == t.y - 1 && t2.value == t.value) {
          t.y = t2.y;
          t.value = t.value * t.value;
          board.remove(t2);
        }
      }
    }

    // left
    if (degrees == 180) {
      for (Tile t2 : board) {
        if (t2.x == t.x + 1 && t2.value == t.value) {
          t.x = t2.x;
          t.value = t.value * t.value;
          board.remove(t2);
        }
      }
    }

    //down
    if (degrees == 270) {
      for (Tile t2 : board) {
        if (t2.y == t.y + 1 && t2.value == t.value) {
          t.y = t2.y;
          t.value = t.value * t.value;
          board.remove(t2);
        }
      }
    }

    //right
    if (degrees == 0) {
      for (Tile t2 : board) {
        if (t2.x == t.x - 1 && t2.value == t.value) {
          t.x = t2.x;
          t.value = t.value * t.value;
          board.remove(t2);
        }
      }
    }
  }
}
