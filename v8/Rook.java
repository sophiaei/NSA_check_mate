import java.util.ArrayList;

public class Rook extends Piece{
  public Rook(/*Board board, */int clr, Location where){
     super( /*board, */clr, where);
  }

  public String toString(){
    return "R";
  }
  public void checkMoves(){

    



      for(int x = _current._row+1; x<8;x++  ){//up
        if(_current.thereIsAPiece(x, _current._column){
          _possibleMoves.add(x,_current._column);
          break;
        }
        else{
          _possibleMoves.add(x,_current._column);
        }
  }
  for(int x = _current._row-1; x>0;x--  ){//up
    if(_current.thereIsAPiece(x, _current._column){
      _possibleMoves.add(x,_current._column);
      break;
    }
    else{
      _possibleMoves.add(x,_current._column);
    }
}
  for(int x = _current._column+1; x<8;x++  ){//up
    if(_current.thereIsAPiece(_current._row, x){
      _possibleMoves.add(_current._row, x);
      break;
    }
    else{
      _possibleMoves.add(_current._row, x);
    }
  }
    for(int x = _current._column-1; x>0;x--  ){//up
      if(_current.thereIsAPiece(_current._row, x){
        _possibleMoves.add(_current._row, x);
        break;
      }
      else{
        _possibleMoves.add(_current._row, x);
      }
    }
  }


}
