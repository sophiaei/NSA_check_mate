import java.util.ArrayList;

public class Bishop extends Piece{
  public Bishop(/* Board board, */ int clr, Location where){
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
    output += "B";
    output += colorText(RESET);
    return output;
  }

  public void checkMoves(Board brd){ // this is just the board that the piece is on


        int[][] directions = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} }; // NE, NW, SE, SW
        for(int[] coors : directions){
          // adds the translation until you ucan't go anymore
          // start at the current location plus translation once
          // end when you either hit a piece
          Location temp = new Location(_current._row, _current._column );

          for (int i = 1; i < 8; i++){ // you can, at most, add the translation 7 times provided you don't break before then
            temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
            if (brd.thereIsAPiece(temp) ){ // is there a piece there?

              if (brd.piece(temp)._color == this._color ){ // if the color of the piece at temp is the same
                break;
              }
             _possibleMoves.add(temp); // if it's a piece of another color, you can just take that piece
              break;
            }
            _possibleMoves.add(temp);
          }


      }
    }

  }
