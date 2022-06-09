import java.util.ArrayList;

public class King extends Piece{
  public King(/* Board board, */int clr, Location where){
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
    output += "K";
    output += colorText(RESET);
    return output;
  }

  // public void checkMoves(Board brd){
  //
  //   int[][] potentialMoves = { {1, 1}, {1, -1}, {-1, -1}, {-1, 1}, {1, 0} {0, 1}, {-1, 0}, {0, -1} }
  //   for int(int[] coors : potentialMoves){
  //     Location trans = new Location(_current._row + coors[0], _current._column + coors[1]);
  //     if (brd.thereIsAPiece(trans) == false){// if there isn'a piece already there
  //       if (){ // if the move wouldn't endanger the king
  //
  //       }
  //
  //     }
  //   }
  //
  // }


}
