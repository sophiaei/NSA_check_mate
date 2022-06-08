import java.util.ArrayList;

public class Bishop extends Piece{
  public Bishop(/* Board board, */ int clr, Location where){
     super( /*board, */clr, where);
  }
  public String toString(){
    return "B";
  }
  public void checkMoves(){
      //
      //
      //   int[][] directions = { {1, 1}, {1, -1} {-1, 1}, {-1, -1}}; // NE, NW, SE, SW
      //   for(int[] coors : directions){
      //     // adds the translation until you ucan't go anymore
      //     // start at the current location plus translation once
      //     // end when you either hit a piece
      //
      //     Location temp = new Location(_current._row + coors[0], _current._column + coors[1]);
      //
      //
      //
      //     for (int r = _current._row + coors[0]; 0 <= r && r < 8; r+=coors[0]){ //
      //       for (int c = _current._column + coors[1]; 0 <= c && c < 8; c+=coors[1]){
      //         if (){// once it hits something it breaks
      //           temp = new Location(r, c);
      //
      //         }
      //       }
      //     }
      //
      // }
    }

  }
