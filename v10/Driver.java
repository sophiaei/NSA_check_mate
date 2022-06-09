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
    Location white =  new Location(0, 4);
    Location black = new Location(7, 4);
    kingLocations = new Location[2];
    kingLocations[0] = white;
    kingLocations[1] = black;
    //= {white, black}; // 4 0 for white, 4 7 for black
    _whiteTurn = 1;
  }


  public boolean checkDanger(int clr, Location whereKing){
    // checks if the king of ggiven color is in inDanger
    return false;
  }


  public Board turn(){

    boolean inDanger = false; // has to b here bc king in question chagnes

    boolean castling; // whether you're castling
    Location abyss = new Location(10, 10);
    Piece moving = new Piece(0, abyss);
    Piece alsoMoving;
    Location endPlace = abyss;
    String newType; // for pawn promotion
    Scanner sc = new Scanner( System.in );

    if (inDanger == true){ // checks if the game is over
      System.out.println("king is in danger");
      if (!(brd.piece( kingLocations[(int)(0.5 + 0.5*_whiteTurn)]).hasMoves() ) ){
        _over = true;
        _wonBy = _whiteTurn * -1; // meaning the opp color won
        System.out.println("game over");
        return brd;
      }
    }
    System.out.println("Please input your move");

    while( sc.hasNext() == false) {
      int x = 1;
      // if there's no input yet, just hold tight
    }
    String inInput = sc.next();
    if (inInput == "CK" || inInput == "CQ"){ // if you're castling
      castling = true;
    }
    try{
      String[] info = inInput.split(" "); // this will give you as long an array as needed
      //Location startingPlace = new Location(info[0], info[1]);
      moving = brd.piece(Integer.parseInt(info[0]), Integer.parseInt(info[1]) );
      endPlace = new Location(Integer.parseInt(info[2]), Integer.parseInt(info[3]));
      // this needs to b in location form bc we'll be checking this against movelists
      if (info.length > 4){
        newType = info[4]; // this is for pawn promotion
      }
    } catch (Exception e) {
      System.out.println("You typed something strange; please try again");
      turn();
    }
    // we now have the input as variables; we need to actually move stuff
    if (inDanger && !(moving instanceof King)){// if it isn't the king that's moving
        System.out.println("The king is in danger; please move it");
        turn();
    }
    if (moving.isMove(endPlace)){
      System.out.print("yes, this works");
    } else{
      turn();
    }

    return brd;
  }// end turn


  public void go(){
    while (_over == false){
      turn();
    }
  }

  public static void main(String[] args){
    //checking location
    /*
    Location a = new Location(2, 3);
    System.out.println(a);

    //checking piece
    Piece x = new Piece( -1, a);
    System.out.println(x);
    System.out.println(x._color);
    System.out.println(x._current);
    */

    Board b = new Board();
    System.out.println(b);
    b.addPiece("B", 1, 1, 1);
    System.out.println(b);


    System.out.println("testing the bishop checkmoves function");
    System.out.println(b.piece(1, 1)._possibleMoves);
    b.piece(1, 1).checkMoves(b);
    System.out.println(b.piece(1, 1)._possibleMoves); // check
    /*
    */
  //  System.out.println()

      }//end main()
  }
