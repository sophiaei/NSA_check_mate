public class Location{
  protected int _row;
  protected int _column;
  protected Piece on;

  public Location(int row, int col){
    _row=row;
    _column=col;
  }


  public int getRow(){
    return _row;
  }

  public void setRow(int row){
    this.row = row;
  }

  public int getColumn(){
    return _column;
  }

  public void setColumn(int column){
    this.column = column;
  }

  public void setValues(int column, int row){
    this.row = row;
    this.column = column;
  }

  public String toString(){
    return (string) _row + " "+ _column;
  }
}
