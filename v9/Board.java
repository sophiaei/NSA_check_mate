import java.util.ArrayList;
public class Board{
  private Piece[][] _contents;
  private ArrayList<Piece> _deadW, _deadB;

  public Board(){
    _contents = new Piece[8][8];

    // we should not be making empty pieces that can't be used
  }// end constructor

  public void setUp(){
    //pawns:
    for (int j = 0; j < 8; j++){ // for the white pawn row
      _contents[1][j] = new Pawn(/*this, */1, new Location(1,j)); //iffy - check later
    }
    for (int j = 0; j < 8; j++){ // for the black pawn row
      _contents[6][j] = new Pawn(/*this, */-1, new Location(6,j)); //iffy - check later
    }

    // knights, bishops, rooks
    for (int i = -1; i <= 1; i+=2){ // for the two colors - relates to row
      // black ( i = -1) needs to be on row 7; white on row 0
      for (int k = -1; k <=1; k+=2){ // whether it's on the right or the left, where left is -1
      // left (k = -1) needs to be on column 7; right on column 1
        _contents[(int)(3.5 - 3.5 * i)][(int)(3.5 - 3.5 * k)] = new Rook(/*this, */i, new Location( (int)(3.5 - 3.5 * i), (int)(3.5 - 3.5 * k) ));
        _contents[(int)(3.5 - 3.5 * i)][(int)(3.5 - 2.5 * k)] = new Knight(/*this, */i, new Location( (int)(3.5 - 3.5 * i), (int)(3.5 - 2.5 * k) ));
        _contents[(int)(3.5 - 3.5 * i)][(int)(3.5 - 1.5 * k)] = new Bishop(/*this, */i, new Location( (int)(3.5 - 3.5 * i), (int)(3.5 - 1.5 * k) ));

      }
      // king, queen
      // black needs to be on (7, )
      // king
      _contents[(int)(3.5 - 3.5 * i)][4] = new King(/*this, */i, new Location( (int)(3.5 - 3.5 * i), 5 ));
      _contents[(int)(3.5 - 3.5 * i)][3] = new Queen(/*this, */i, new Location( (int)(3.5 - 3.5 * i), 4 ));
    }
  }



  public Piece piece(Integer row, Integer column){ //gets the piece at specific location
    return _contents[row][column];
  }

  public Piece piece(Location position){ //again, with location class
    return _contents[position.getRow()][position.getColumn()];
  }

  public Location relocatePiece(Piece whichPiece, Location newLocation){//newLocation variable?
    Location temp = whichPiece._current;

    _contents[newLocation.getRow()][newLocation.getColumn()] = whichPiece;
    whichPiece.changeLoc(newLocation);

    return temp;
  }

  public Piece pieceRemoved(Piece pieceDying){ // removing a piece and putting it with the dead pieces

    Piece temp = pieceDying;
    if (temp._color>0){
      _deadW.add(temp);
    }
    else{
      _deadB.add(temp);
    }
    _contents[temp._current.getRow()][temp._current.getColumn()] = null; // the piece should no longer be on the board
    temp._current = null; // the piece should no longer know its location
    return temp;

  }
  public boolean positionExists(int row, int column){ // is specified position on the board?
    return (row >= 0 && row < 8) && (column >= 0 && column < 8);
  }
  public boolean positionExists(Location location){
    return positionExists(location.getRow(),location.getColumn());
  }


  public boolean thereIsAPiece(Location position) { // is there a piece at the specified location
    return piece(position) != null;
  }



    public String toString(){
      String output = "  ";
       // numbers at the top
      for (int rw = 0; rw < 8; rw++){
        output += rw + " ";

      } // nums at top done
      output += "\n";
      for (int j = 0; j < 8; j++){
        output += j + " ";
        for (int i = 0; i < 8; i++){
          if (_contents[j][i] == null){// if there's no piece there, just put a dot
            output += "• ";
          } else {
            output += _contents[j][i].toString() + " ";
          }
        }
        output += "\n";
      } return output;
    }

  }
