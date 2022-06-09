import java.util.ArrayList;

public class Piece{
  protected ArrayList<Location> _possibleMoves;
  //protected Board board;
  public int _color; //black =-1, white=1
  protected Location _current;

  public boolean _justJumped2; // whether the pawn has just moved up two
  // specific to pawns, but needs to be here bc boards contain pieces, not pawns

  public Piece(/*Board board, */int clr, Location where){
  //  this.board = board;
    _color = clr;
    _current = where;
    _possibleMoves = new ArrayList<Location>();
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
    output += "-";
    output += colorText(RESET);
    return output;
  }


  public String getLocation(){
    return _current.toString();
  }


  public void changeLoc(Location l){
    _current=l;
   }

   public void checkMoves(Board brd){ // for now this is a TBoard, not an actual board

   }

   public boolean hasMoves(){
     return _possibleMoves.size() > 0;
   }

   public boolean isMove(Location move){
     return _possibleMoves.indexOf(move) != -1;
   }
}
