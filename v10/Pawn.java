import java.util.ArrayList;

public class Pawn extends Piece{
  //protected Location _current;


  public Pawn(/*Board board, */int clr, Location where){
     super( /*board, */clr, where);
    _justJumped2 = false;
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
    output += "P";
    output += colorText(RESET);
    return output;
  }



  public void checkMoves(Board board){
    Location New=new Location(_current.getRow()+2*this._color,_current.getColumn()); // adance by 2
    Location New2=new Location(_current.getRow()+this._color,_current.getColumn()); // regular advance
    Location New3=new Location(_current.getRow()+this._color,_current.getColumn()-1); // eat to the right
    Location New4=new Location(_current.getRow()+this._color,_current.getColumn()+1); // eat to the left

        if(board.positionExists(New2)&&!board.thereIsAPiece(New2)){ //up 1 move
          _possibleMoves.add(New2);
        }
        if(_current.getRow()==((int)(3.5-2.5*_color))&&!board.thereIsAPiece(New2)){ // up 2 move
          if(!board.thereIsAPiece(New)){
          _possibleMoves.add(New);
        }
      }
      // regular taking case
      if( board.positionExists(New3)&&(board.thereIsAPiece(New3)&&board.piece(New3)._color!=this._color) )
        { //diagnol eat
        _possibleMoves.add(New3);
      }
      if( board.positionExists(New4)&&(board.thereIsAPiece(New4)&&board.piece(New4)._color!=this._color) ){ //diagnol eat pt 2
        _possibleMoves.add(New4);
      }
      // en passsant case
      if( board.positionExists(New3) &&(board.thereIsAPiece(new Location(_current.getRow(),_current.getColumn()-1)) ) ) {
        if ( board.piece(_current.getRow(), _current.getColumn()-1 )  instanceof Pawn){
          if ( board.piece(_current.getRow(), _current.getColumn()-1 )._color!=this._color && board.piece(_current.getRow(), _current.getColumn()-1 )._justJumped2 ){
              _possibleMoves.add(New3);
          }
        }
      }

      if( board.positionExists(New4) &&(board.thereIsAPiece(new Location(_current.getRow(),_current.getColumn()+1)) ) ) {
        if (( board.piece(_current.getRow(), _current.getColumn()+1 ) instanceof Pawn)){
          if ( board.piece(_current.getRow(), _current.getColumn()+1 )._color!=this._color && ( board.piece(_current.getRow(), _current.getColumn()+1 )._justJumped2 )){
              _possibleMoves.add(New4);
          }
        }
      }

    }
    // en passsant case:
    // check if the diagonal locatio to which you'd be movign is on the board
    // check if there is a piece next to you
    // check if that piece is a pawn
    // and that he pawn you're about to take has just moved up two (_justJumped2)

    // reular taking case:
    // check if the diagonal locatio to which you'd be movign is on the board
    // check if there is a piece at that Location

  }
