import java.util.ArrayList;
import java.util.Scanner;

public class Driver{
  public boolean _over;
  public int _wonBy;
  public Board brd;
  public Location[] kingLocations; // black then white
  public int _whiteTurn; // 1 is that it's white

  public Driver(){
    brd= new Board(); // sets up the board
    brd.setUp();
    Location white =  new Location(0, 4);
    Location black = new Location(7, 4);
    kingLocations = new Location[2];
    kingLocations[0] = black;
    kingLocations[1] = white;
    //= {white, black}; // 4 0 for white, 4 7 for black
    _whiteTurn = 1;
  }

  public String[] verifyMove(){
    boolean inDanger = false; // has to b here bc king in question chagnes

    boolean castling = false; // whether you're castling
    Location abyss = new Location(10, 10);
    Piece moving = new Piece(0, abyss);
    Piece alsoMoving = null;
    Piece captured;
    Location endPlace = abyss;
    String newType = ""; // for pawn promotion
    Scanner sc = new Scanner( System.in );
    String[] bad = {"exited"};
    String[] gameover = {"game over"};

    Location throne = kingLocations[(int)(0.5+0.5*_whiteTurn)];
    //System.out.println(throne);
    Piece eater = brd.checkDanger(_whiteTurn, throne);
    if (eater._color!=0 ){ // checks if the game is over
      System.out.println("king is in danger");
      inDanger = true;
      if (!(brd.piece( kingLocations[(int)(0.5 + 0.5*_whiteTurn)]).hasMoves() )  && (brd.checkDanger( eater._color, eater._current )._color==0)){
        _over = true;
        _wonBy = _whiteTurn * -1; // meaning the opp color won
        clearScreen();
        if (_wonBy == 1){
          System.out.println("Game Over! White won!" );
        }
        else{
        System.out.println("Game Over! Black won!" );
      }
        //System.out.println(brd);
        return gameover;
      }
    }
    System.out.println("Please input your move");

    while( sc.hasNext() == false) {
      int x = 1;
      // if there's no input yet, just hold tight
    }
    String inInput = sc.next();
    //System.out.println(sc.next());
    if (inInput.trim().toUpperCase().equals("CK") || inInput.trim().toUpperCase().equals ("CQ")){ // if you're castling
      castling = true;
      // search for king

      moving = brd.piece((int)(3.5 - 3.5 * _whiteTurn), 4); // og location of king - king must be n og locaiton
      if (inInput.toUpperCase().equals("CK")){
        alsoMoving = brd.piece((int)(3.5 - 3.5 * _whiteTurn), 7); // rook on kings side
      } else {
        alsoMoving = brd.piece((int)(3.5 - 3.5 * _whiteTurn), 0); // rook on queen's side
      }

    }

    String[] info;
    try{
      info = inInput.split(","); // this will give you as long an array as needed
      //Location startingPlace = new Location(info[0], info[1]);
      //System.out.println(info);
      //System.out.println(info[0] + info[1] + info[2] + info[3]) ;
    }
    catch (Exception e) {
      info = new String[4];
      System.out.println("You typed something strange; please try again");
      return bad;
    }
    moving = brd.piece(Integer.parseInt(info[0]), Integer.parseInt(info[1]) );
    //if (moving == null){

    if (moving._color != _whiteTurn){
      System.out.println("Wrong color piece! Please try again");
      info = null;
      return bad;
    }
    System.out.println("Piece moving: The one at " + moving._current);
    endPlace = new Location(Integer.parseInt(info[2]), Integer.parseInt(info[3]));
    // this needs to b in location form bc we'll be checking this against movelists
    //System.out.println("Will go to: " + endPlace);
    if (info.length > 4){
      newType = info[4]; // this is for pawn promotion
    }

    // we now have the input as variables; we need to check if the move is valid
    if ( inDanger && (endPlace == brd.checkDanger( _whiteTurn, kingLocations[(int)(0.5 + 0.5*_whiteTurn)])._current )) ||moving instanceof King){// if it isn't the king that's moving
        System.out.println("The king is in danger please move it");
        System.out.println(brd.checkDanger( _whiteTurn, kingLocations[(int)(0.5 + 0.5*_whiteTurn)])._current );
        System.out.println(endPlace);
        return bad;
    }
    if (moving.isMove(endPlace) == false){
      System.out.println("Your move isn't possible for the given piece. Try again");
      System.out.println("Moves that are possible: " + moving._possibleMoves);
      info = null;
      return bad;
    }
    //System.out.println("yes, this works");
    return info;
  }

  public Board turn(){
    String[] printout = verifyMove();
    if (printout[0] == "game over"){
      return brd;
    }
    while(printout.length == 1 && printout[0] == "exited"){
      printout = verifyMove();
      System.out.println(printout);
    }

    Piece moving = brd.piece(Integer.parseInt(printout[0]), Integer.parseInt(printout[1]) );
    Location endPlace = new Location(Integer.parseInt(printout[2]), Integer.parseInt(printout[3]));
    String newType = "";
    Piece captured;
    //System.out.println("Will go to: " + endPlace);
    if (printout.length > 4){
      newType = printout[4]; // this is for pawn promotion
    }

/*
    // actually doing the moving
    if (castling){
      // we've checked that the king is good to castle; we've not checked that the rook is good
      Location newKingPlace;
      Location newRookPlace;
      if (inInput == "CK"){//
        newKingPlace = new Location((int)(3.5-3.5*moving._color), 6);
        newRookPlace = new Location( (int)(3.5-3.5*moving._color), 5 );
      } else {// queens side castling
        newKingPlace = new Location((int)(3.5-3.5*moving._color), 2);
        newRookPlace = new Location( (int)(3.5-3.5*moving._color), 3 );
      }
      if (alsoMoving.isMove( newRookPlace) ){
        if ( !(brd.thereIsAPiece( newRookPlace)) && !(brd.thereIsAPiece( newKingPlace)) ){
          brd.relocatePiece(moving, newKingPlace);// the king moves
          brd.relocatePiece(alsoMoving, newRookPlace);
        }
      }

*/
    // } else if (moving instanceof King){
    //   moving._hasMoved==true;

    if (moving instanceof Pawn){
      //System.out.println("now dealing with pawns");
      if(moving._current._row==3.5+2.5*moving._color){ // pawn promotion
        if (newType.toUpperCase().equals("Q") ){
          moving=new Queen(moving._color,moving._current);
        }
        if (newType.toUpperCase().equals("N") ){
          moving=new Knight(moving._color,moving._current);
        }
        if (newType.toUpperCase().equals("R")){
          moving=new Rook(moving._color, moving._current);
        }
        if (newType.toUpperCase().equals("B")){
          moving=new Bishop(moving._color,moving._current);
        }

      }
      if (moving._current._column != endPlace.getColumn()){// en passant case. Check 1. is it a diagonal move?
        Location neighbor = new Location( endPlace.getRow() - moving._color, endPlace.getColumn() );
        if ( brd.thereIsAPiece( neighbor) && !(brd.thereIsAPiece(endPlace) ) ){ // is there a piece there?
          // there will be no ambiguity between diagonal takign and en passsant
          captured = brd.piece( neighbor );

        }
      }
    } // end of pawn cases

    if (brd.thereIsAPiece(endPlace)) {
      captured = brd.piece(endPlace);
      // by this point captured will be set
      brd.pieceRemoved(captured);
    }

    brd.relocatePiece(moving, endPlace); // move down
    System.out.println("New Location: " + moving._current);

    moving._hasMoved = true;
    if (moving instanceof King){
      kingLocations[(int)(0.5 + 0.5*_whiteTurn)] = moving._current;
    }

    //System.out.println("about to update the move lists");
    brd.update();
    //System.out.println("move lists updated");
    _whiteTurn *= -1;
    clearScreen();
    return brd;
}// end turn


    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

  public void go(){
    brd.setUp();
    while (_over == false){

      if (_whiteTurn == 1){
        System.out.println("White's turn");
      } else{
        System.out.println("Black's turn");
      }

      System.out.println( turn() );
    }

  }

  public static void main(String[] args){
    Board b = new Board();
    //System.out.println(b);
    clearScreen();
    System.out.println("Welcome to Chess! When entering your moves, please format as such: original row, original column, final row, final column");
    b.setUp();
    System.out.println(b);
    //turn();

    Driver game = new Driver();

    // System.out.println(game.turn() );
    game.go();

    }//end main()
  }
