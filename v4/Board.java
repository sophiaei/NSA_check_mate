public class Board{
  Piece[][] _contents;
  Piece[] _takenByBlack, _takenByWhite;

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
    temp.position = null;
    piece[position.getRow()][position.getColumn()] = null;
    return aux;

  }

  public boolean thereIsAPiece(Location position) {
    return piece(position) != null;
}
