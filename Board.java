/** 
 * A game board of NxM board of tiles.
 * 
 *  @author PLTW
 * @version 2.0
 */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"lion", "lion",
                                        "penguin", "penguin",
                                        "dolphin", "dolphin",
                                        "fox", "fox",
                                        "monkey", "monkey",
                                        "turtle", "turtle"}; 
  private Tile[][] gameboard = new Tile[3][4];

  /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()
  {
    for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 4; c++) {
            gameboard[r][c] = new Tile(tileValues[r * 4 + c]);
        }
    }
  }

 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
      if (gameboard[0][0] == null) {
          return "";
      }

      String out = "";
      for (int r = 0; r < 3; r++) {
          for (int c = 0; c < 4; c++) {
              Tile t = gameboard[r][c];
              if (t.isMatched()) {
                  out = out + "  * " + "\t";
              } else if (t.isShowing()) {
                  out = out + t.value + "\t";
              } else {
                  out = out + "____" + "\t";
              }
          }
          out = out + "\n";
      }
 
    return out;
  }

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {
      if (gameboard[0][0] == null) {
          return false;
      }

      for (int r = 0; r < 3; r++) {
          for (int c = 0; c < 4; c++) {
              if (!gameboard[r][c].isMatched()) {
                  return false;
              }
          }
      }
    
    return true;
  }

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {  
    if (row >= 0 && row < gameboard.length && column >= 0 && column < gameboard[0].length) {
        gameboard[row][column].hidden = false;
    }
  }  

  /** 
   * Checks if the Tiles in the two locations match.
   * 
   * If Tiles match, show Tiles in matched state and return a "matched" message
   * If Tiles do not match, re-hide Tiles (turn face down).
   * 
   * Preconditions:
   *   gameboard is populated with Tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row1 the row value of Tile 1
   * @param col1 the column value of Tile 1
   * @param row2 the row value of Tile 2
   * @param col2 the column vlue of Tile 2
   * @return a message indicating whether or not a match occured
   */
  public String checkForMatch(int row1, int col1, int row2, int col2)
  {
    String msg = "";

    if (row1 >= 0 && row1 < gameboard.length && col1 >= 0 && col1 < gameboard[0].length && row2 >= 0 && row2 < gameboard.length && col2 >= 0 && col2 < gameboard[0].length) {
        if (gameboard[row1][col1].value.equals(gameboard[row2][col2].value)) {
            gameboard[row1][col1].matched = true;
            gameboard[row2][col2].matched = true;
            return "Matched";
        } else {
            gameboard[row1][col1].hidden = true;
            gameboard[row2][col2].hidden = true;
            return "";
        }
    }
    
    return "invalid input, please try again";
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param row the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {
      if (row >= 0 && row < gameboard.length && col >= 0 && col < gameboard[0].length) {
          if (!gameboard[row][col].isMatched()) {
              return true;
          }
      }

    return false;
  }
}
