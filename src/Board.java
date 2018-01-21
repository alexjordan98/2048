import java.util.*;

public class Board {

  ArrayList<Tile> board;
  int length = 4;
  
  
  
  // Builds the initial game board 
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
  
  // Adds more tiles to board each time key is pressed 
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
  
  
  
  // Changes value of tile
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
  
  // Checks if a tile exists that is above the given tile's
  public boolean tileAbove(Tile t) {
    
    boolean b = false;
    
    for(Tile t2 : board) {
      if(t2.x == t.x - 1) {
        b = true;
      }
    }
    return b;
  }
  
  // Checks if the above tile's value is the same as the given tile's
  // removes above tile
  // Decreases the value of the tile's x

  public void tileAboveSame(Tile t) {
    
    
    for(Tile t2 : board) {
      if(t2.x == t.x - 1 && t2.value == t.value) {
        t.x = t2.x;
        t.value = t.value * t.value;
        board.remove(t2);
      }
    }
  }
  
  // Checks if a tile exists that is below the given tile's
  public boolean tileBelow(Tile t) {
    
    boolean b = false;
    
    for(Tile t2 : board) {
      if(t2.x == t.x + 1) {
        b = true;
      }
    }
    return b;
  }
  
  // Checks if the below tile's value is the same as the given tile's
  // removes below tile
  // increases the value of the tile's x

  public void tileBelowSame(Tile t) {
    
    
    for(Tile t2 : board) {
      if(t2.x == t.x + 1 && t2.value == t.value) {
        t.x = t2.x;
        t.value = t.value * t.value;
        board.remove(t2);
      }
    }
  }
  
  // Checks if a tile exists that is to the right of the given tile's
  public boolean tileRight(Tile t) {
    
    boolean b = false;
    
    for(Tile t2 : board) {
      if(t2.y == t.y + 1) {
        b = true;
      }
    }
    return b;
  }
  
  // Checks if the right tile's value is the same as the given tile's
  // removes right tile
  // increases the value of the tile's y
  public void tileRightSame(Tile t) {
    
    
    for(Tile t2 : board) {
      if(t2.y == t.y + 1 && t2.value == t.value) {
        t.y = t2.y;
        t.value = t.value * t.value;
        board.remove(t2);
      }
    }
  }
  
  // Checks if a tile exists that is to the left of the given tile's
  public boolean tileLeft(Tile t) {
    
    boolean b = false;
    
    for(Tile t2 : board) {
      if(t2.y == t.y - 1) {
        b = true;
      }
    }
    return b;
  }
  
  // Checks if the left tile's value is the same as the given tile's
  // removes left tile
  // decreases the value of the tile's y
  public void tileLeftSame(Tile t) {
    
    
    for(Tile t2 : board) {
      if(t2.y == t.y + 1 && t2.value == t.value) {
        t.y = t2.y;
        t.value = t.value * t.value;
        board.remove(t2);
      }
    }
  }
}
