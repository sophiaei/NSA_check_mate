public class Location{
  protected int _row;
  protected int _column;
  //protected Piece on;

  public Location(int row, int col){
    _row=row;
    _column=col;
  }


  public int getRow(){
    return _row;
  }

  public void setRow(int rw){
    _row = rw;
  }

  public int getColumn(){
    return _column;
  }

  public void setColumn(int column){
    _column = column;
  }

  public void setValues(int row, int column){
    _row = row;
    _column = column;
  }

  public String toString(){
    return (String) ("" +_row + " "+ _column);
  }
}
