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
  }


  public boolean checkDanger(int clr, Location whereKing){
    // checks if the king of ggiven color is in inDanger
  }
  public Board turn(){ // returns the board in its state after the turn
    public boolean inDanger=false; // has to b here bc king in question chagnes

    public boolean castling; // whether you're castling

    if (inDanger){
      System.out.println("king is in danger"); \
      if (!(brd[kingLocation[(int)(0.5 + 0.5*_whiteTurn)]].hasMoves() ) ){
        _over = true;
        _wonBy = _whiteTurn * -1; // meaning the opp color won
        System.out.println("game over");
        return brd;
      }
    }
    // from there, get use input

    System.out.println("Please input your move");

    Scanner sc = new Scanner( System.in );

    while( sc.hasNext() ) {
      String inInput = sc.next();
      if (inInput == "CK" || inInput == "CQ"){ // if you're castling

      }

    }


  }

  public void go(){
    while (_over == false){
      turn()
    }
  }

  public static void main(String[] args){

    //checking location
    Location a = new Location(2, 3);
    System.out.println(a);

    //checking piece
    Piece x = new Piece( -1, a);
    System.out.println(x);
    System.out.println(x._color);
    System.out.println(x._current);

    Board go = new Board();
    System.out.println(go);
        Scanner sc = new Scanner( System.in );
        Board bo = new Board();
        while( sc.hasNext() ) {
          System.out.println( bo.nextMove(sc.next() ));
        }

      }//end main()
  }
