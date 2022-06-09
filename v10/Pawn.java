import java.util.ArrayList;

public class Pawn extends Piece{
  //protected Location _current;
  public boolean _justJumped2; // whether the pawn has just moved up two

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



  // public void checkMoves(){
  //   Location New=new Location(this._row+2*this._color,this._column); // adance by 2
  //   Location New2=new Location(this._row+this._color,this._column); // regular advance
  //   Location New3=new Location(this._row+this._color,this._column-1); // eat to the right
  //   Location New4=new Location(this._row+this._color,this._column+1); // eat to the left
  //
  //       if(board.positionExists(New2)&&!board.thereIsAPiece(New2)){ //up 1 move
  //         _possibleMoves.add(New2);
  //       }
  //       if(_row==(4.5-2.5*color)&&!board.thereIsAPiece(New2)){ // up 2 move
  //         if(!board.thereIsAPiece(New)){
  //         _possibleMoves.add(New);
  //       }
  //     }
  //     // regular taking case
  //     if( board.positionExists(New3)&&(board.thereIsAPiece(New3)&&New3.on._color!=this._color) )
  //       { //diagnol eat
  //       _possibleMoves.add(New3);
  //     }
  //     if( board.positionExists(New4)&&(board.thereIsAPiece(New4)&&New4.on._color!=this._color) ){ //diagnol eat pt 2
  //       _possibleMoves.add(New4);
  //     }
  //     // en passsant case
  //     if( board.positionExists(New3)
  //       &&(board.thereIsAPiece(new Location(this._row,this._column-1)) )
  //       && ((board[this._row][this._column-1]) instanceof Pawn) &&
  //        board[this._row][this._column-1]._color!=this._color
  //       && (board[this._row][this._column-1]._justJumped2 ) )
  //       { //diagnol eat
  //       _possibleMoves.add(New3);
  //     }
  //     if(board.positionExists(New4)&&(new Location(this._row,this._column+1))
  //     && ((board[this._row][this._column+1]) instanceof Pawn) &&
  //      board[this._row][this._column-1]._color!=this._color
  //     && (board[this._row][this._column+1]._justJumped2 ) ) { //diagnol eat pt 2
  //       _possibleMoves.add(New4);
  //     }
  //
  //   }
    // en passsant case:
    // check if the diagonal locatio to which you'd be movign is on the board
    // check if there is a piece next to you
    // check if that piece is a pawn
    // and that he pawn you're about to take has just moved up two (_justJumped2)

    // reular taking case:
    // check if the diagonal locatio to which you'd be movign is on the board
    // check if there is a piece at that Location

  }
