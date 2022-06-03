public class Board{
  Piece[][] _contents;
  Piece[] _deadW, _deadB;

  public Board(){
    _contents = new Piece[8][8];
  }

  public Piece piece(Integer row, Integer column){
    return pieces[row][column];
  }

  public Piece piece(Location position){
    return pieces[position.getRow()][position.getColumn()];
  }

  public  void placePiece(Piece piece, Location position){
    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  public Piece relocatePiece(Piece whichPiece, Location newLocation){//newLocation variable?
    placePiece(piece(piece.getRow(), piece.getColumn()), newLocation);
    pieceRemoved(piece(piece.getRow(), piece.getColumn());
  }

  public Piece pieceRemoved(Piece pieceDying){
    if(piece(position) == null){
      return null;
    }
    Piece temp = piece(position);
    if (temp.color>0){
      _deadW.add(temp);
    }
    else{
      _deadB.add(temp);
    }
    temp.position = null;
    piece[position.getRow()][position.getColumn()] = null;
    return aux;

  }
  public boolean positionExists(int row, int column){
    return (row >= 0 && row < 8) && (column >= 0 && column < 8);
  }
  public boolean positionExists(Location location){
    return positionExists(location.getRow(),location.getColumn()));
  }


  public boolean thereIsAPiece(Location position) {
    return piece(position) != null;
  }
}
