import java.util.ArrayList;
public class Board{
  protected Piece[][] _contents;
  private ArrayList<Piece> _deadW = new ArrayList<Piece>();
  private ArrayList<Piece> _deadB = new ArrayList<Piece>();


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
      _contents[(int)(3.5 - 3.5 * i)][4] = new King(/*this, */i, new Location( (int)(3.5 - 3.5 * i), 4 ));
      _contents[(int)(3.5 - 3.5 * i)][3] = new Queen(/*this, */i, new Location( (int)(3.5 - 3.5 * i), 3 ));
    }
    update();
  }// end setup


  public void update(){
    for (Piece[] row : _contents){
      for (Piece x : row){
        if (x != null){
          x.checkMoves(this);
        }
      }
    }
  }

    public Piece piece(Integer row, Integer column){ //gets the piece at specific location
    return _contents[row][column];
  }

  public Piece piece(Location position){ //again, with location class
    return _contents[position.getRow()][position.getColumn()];
  }

  public Location relocatePiece(Piece whichPiece, Location newLocation){//newLocation variable?
    Location temp = whichPiece._current; // orig locatin of piece

    _contents[newLocation.getRow()][newLocation.getColumn()] = whichPiece;
    whichPiece.changeLoc(newLocation);
    _contents[temp.getRow()][temp.getColumn()] = null;
    //piece(temp) = null;
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
    return ((row >= 0 && row < 8) && (column >= 0 && column < 8) );
  }
  public boolean positionExists(Location location){
    return positionExists(location.getRow(),location.getColumn());
  }


  public boolean thereIsAPiece(Location position) { // is there a piece at the specified location
    return piece(position) != null;
  }

    public String toString(){
      String output = "\n\n  ";
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

    public Piece checkDanger(int clr, Location whereKing){
      // checks endangerment from rook moves:
      int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // S, N, E, W
      // check in each direction
      // if you hit a rook or queen of the same color, stop going in that direction
      // if you hit a rook or queen of the opposite color, you are in danger. exit function
      for(int[] coors : directions){
        Location temp = new Location(whereKing._row, whereKing._column );

        temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
        while (positionExists(temp)){// while it's still on the board
          // System.out.println("now checking: " + temp);
          if (thereIsAPiece(temp) ) { // is there a piece there?

            if ( (piece(temp)._color != clr) && (piece(temp) instanceof Rook || piece(temp) instanceof Queen) ){ // if the color of the piece at temp is the same
              return piece(temp);
            }
            // System.out.println("stop - no more danger this direction");
            break;

          }
          temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation

        }
      }// end for loop

      // System.out.println("\nnow checking bishop moves");
      // checks endangerment from bishop moves:
      int[][] directions2 = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} }; // NE, NW, SE, SW

      for(int[] coors : directions2){
        Location temp = new Location(whereKing._row, whereKing._column );

        temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
        while (positionExists(temp)){// while it's still on the board
        //  System.out.println("now checking: " + temp);
          if (thereIsAPiece(temp) ) { // is there a piece there?

            if ( (piece(temp)._color != clr) && (piece(temp) instanceof Bishop || piece(temp) instanceof Queen) ){ // if the color of the piece at temp is the same
              return piece(temp);
            }
          //  System.out.println("stop - no more danger this direction");
            break;

          }
          temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]); // apply the translation
        }
      }// end for loop

      // checks endangerment from knights:
      // System.out.println("\nnow checking knight moves");
      int[][] directions3 = { {1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1} };
      Location[] movesToCheck = new Location[8];
      for (int i = 0; i < 8; i++){
        movesToCheck[i] = new Location(whereKing.getRow() + directions3[i][0], whereKing.getColumn() + directions3[i][1]);
      } // makes a list of moves to check
      for (Location x : movesToCheck){
        // System.out.println(x);
        if (positionExists(x) && thereIsAPiece(x)){// if the move is on the board
          if (piece(x)._color != clr && piece(x) instanceof Knight){
            return piece(x);
          }
        }
      }
      // checks endangerment from pawns (en passant not a consideration)
      // System.out.println("\n now checking pawn moves");
      int[] dirs = {-1, 1};
      for (int x : dirs){
        Location threat = new Location(whereKing.getRow() + clr, whereKing.getColumn() + x );
        // System.out.println(threat);
        if (positionExists(threat) && thereIsAPiece(threat)) {// if there's a piece a pawn taking move away
          // black pawns decrease in row; white increases
          // a black pawn threatening a king would have a row less than the white king
          if (piece(threat)._color != clr && piece(threat) instanceof Pawn){
            return piece(threat);
          }
        }
      }

      Piece output=new Piece(0,new Location(8,8));
      return output;
    } // end checkDanger


  }
