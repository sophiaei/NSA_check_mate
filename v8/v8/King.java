import java.util.ArrayList;

public class King extends Piece{
  public King(/* Board board, */int clr, Location where){
     super( /*board, */clr, where);
  }

  public String toString(){
    return "K";
  }
  public void checkMoves(Board brd){

    int[][] potentialMoves = { {1, 1}, {1, -1}, {-1, -1}, {-1, 1}, {1, 0} {0, 1}, {-1, 0}, {0, -1} }
    for int(int[] coors : potentialMoves){
      Location trans = new Location(_current._row + coors[0], _current._column + coors[1]);
      if (brd.thereIsAPiece(trans) == false){// if there isn'a piece already there
        if (){ // if the move wouldn't endanger the king

        }

      }
    }

  }
}
