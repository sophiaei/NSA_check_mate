public class Piece{
  protected Location[] _possibleMoves;
  public int color; //black =-1, white=1

  public Piece(String OGPos){
    _location=OGPos;
  }
  public String getLocation(){
    return _location;
  }
  public void checkMoves(){

  }
  public isMove(){

  }
  public void changeLoc(int column, int row){
    _current=new Location(_current.row + row,_current._column+column);
   }
}
