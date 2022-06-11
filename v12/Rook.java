import java.util.ArrayList;

public class Rook extends Piece{
  public Rook(/*Board board, */int clr, Location where){
     super( /*board, */clr, where);
  }

  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int RESET = 0;
  public static String colorText(int a){ // creates a tag which you can place in front of the string you want to color
    return ("\033[0"+a+"m" ); // \033[0    \u001B[
  }
  public String toString() {
    String output = "";
    output += colorText((int)(33.5 - 0.5*_color));
    output += "R";
    output += colorText(RESET);
    return output;
  }

  public void checkMoves(Board brd){ // this is just the board that the piece is on
    super.checkMoves(brd);
    if (_hasMoved == false){
      Location longJump = new Location((int)(3.5-3.5*_color), 3 );
      Location shortJump = new Location((int)(3.5-3.5*_color), 5 );
      _possibleMoves.add(longJump);
      _possibleMoves.add(shortJump);
    }
      int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // S, N, E, W
      for(int[] coors : directions){
        // adds the translation until you ucan't go anymore
        // start at the current location plus translation once
        // end when you either hit a piece
        Location temp = new Location(_current._row, _current._column );

        temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
        while (brd.positionExists(temp)){// while it's still on the board

        //System.out.println("now checking: " + temp);
        if (brd.thereIsAPiece(temp) ){ // is there a piece there?

          if (brd.piece(temp)._color == this._color ){ // if the color of the piece at temp is the same
            //System.out.println("no move possible here bc already a piece ");
            break;
          }
          Location newOption = new Location(temp.getRow(), temp.getColumn());// you need a deep copy
          _possibleMoves.add(newOption); // if it's a piece of another color, you can just take that piece
          // System.out.println("yes, you can take the piece");
          break;
        }
        Location newOption2 = new Location(temp.getRow(), temp.getColumn());// you need a deep copy
        _possibleMoves.add(newOption2);
        // System.out.println("can move here");

        temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
        }

      }
    } // end checkmoves


}
