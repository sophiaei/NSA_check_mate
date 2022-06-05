import java.util.ArrayList;

public class Piece{
  protected ArrayList<Location> _possibleMoves;
  //protected Board board;
  public int _color; //black =-1, white=1
  protected Location _current;
  public String toString(){
    return "-";
  }

  public Piece(/*Board board, */int clr, Location where){
    //this.board = board;
    _color = clr;
    _current = where;
    _possibleMoves = new ArrayList<Location>();
  }
  public String getLocation(){
    return _current.toString();
  }


  public void changeLoc(Location l){
    _current=l;
   }
}
