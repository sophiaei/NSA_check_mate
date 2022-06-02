public class Location{
  protected int _row;
  protected int _column;
  protected Piece on;
  public Location(int row, int col){
    _row=row;
    _column=col;
  }
  public String toString(){
    return (string) _row + " "+ _column;
  }
  public int getRow(){
    return _row;
  }
  public int getColumn(){
    return _column;
  }
  public Location translate(int column, int row){

  }
}
