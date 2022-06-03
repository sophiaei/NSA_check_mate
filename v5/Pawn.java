public class Pawn extends Piece{
  protected Location _current;
  public void checkMoves(){
    Location New=new Location(this._row+2*this._color,this._column);
    Location New2=new Location(this._row+this._color,this._column);
    Location New3=new Location(this._row+this._color,this._column-1);
    Location New4=new Location(this._row+this._color,this._column+1);

    if(!board.positionExists(New2)){ //up 1 move
    _possibleMoves.add(New2);
}

        if(_row==(4.5-2.5*color)&&!board.positionExists(New2)){ // up 2 move
          if(!board.positionExists(New)){
          _possibleMoves.add(New);
        }
      }
      if(board.positionExists(New3){ //diagnol eat
        _possibleMoves.add(New3);

      }
      if(board.positionExists(New4){ //diagnol eat pt 2
        _possibleMoves.add(New4);

      }
    }

  }
