import java.util.ArrayList;

/*
The only difference between this and the actual board class is taht this does not set up a Board
in standard configuration - you have to add peices, so there is an addPiece fucntion.
*/
public class TBoard extends Board{
  private Piece[][] _contents;
  private ArrayList<Piece> _deadW, _deadB;

  public TBoard(){
    _contents = new Piece[8][8];
    for (Piece[] row : _contents){
      for (Piece p : row){
        p = null; 
      }
    }
  }



  public Piece addPiece(String type, int r, int c, int clr){
    Piece a;
    Location where = new Location(r, c);
    if (type == "K"){
      a = new King(clr, where);
    } else if (type == "Q"){
      a = new Queen(clr, where);
    } else if (type == "N"){
      a = new Knight(clr, where);
    } else if (type == "B"){
      a = new Bishop(clr, where);
    } else if (type == "R"){
      a = new Rook(clr, where);
    } else if (type == "P"){
      a = new Pawn(clr, where);
    } else {
      a = new Piece(clr, where);
    }
    _contents[r][c] = a;
    return a;
  }

  }
