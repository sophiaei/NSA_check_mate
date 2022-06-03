public class Piece{
  protected Location[] _possibleMoves;
  private Board board;
  public int color; //black =-1, white=1

  public Piece(Board board){
    position = null;
    this.board = board;
  }
  public String getLocation(){
    return _location;
  }

  
  public void changeLoc(int column, int row){
    _current=new Location(_current.row + row,_current._column+column);
   }
}
