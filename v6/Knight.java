import java.util.ArrayList;

public class Knight extends Piece{
  public Knight(/*Board board, */int clr, Location where){
     super(/* board, */clr, where);
  }

  public String toString(){
    return "N";
  }
  public void checkMoves(){
    // (_current._row + 2, _current._col + 1)
    // (_current._row + 1, _current._col + 2)
    // (_current._row – 1, _current._col + 2)
    // (_current._row – 2, _current._col + 1)
    // (_current._row – 2, _current._col – 1)
    // (_current._row – 1, _current._col – 2)
    // (_current._row + 1, _current._col – 2)
    // (_current._row + 2, _current._col – 1)
  }
}
