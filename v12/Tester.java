public class Tester{
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


    /*
    System.out.println("testing the bishop checkmoves function");
    b.addPiece("B", 1, 1, 1);
    System.out.println(b);
    System.out.println(b.piece(1, 1)._possibleMoves);
    // b.piece(1, 1).checkMoves(b);
    // System.out.println(b.piece(1, 1)._possibleMoves); // check if it does ok with board boundaries

    b.addPiece("R", 0, 2, 1);
    b.addPiece("R", 6, 6, -1);
    System.out.println(b);

    b.piece(1, 1).checkMoves(b);
    System.out.println(b.piece(1, 1)._possibleMoves); // check how it does with other pieces
    */

    /*
    System.out.println("testing the knight checkmoves function");
    b.addPiece("N", 1, 2, 1);
    System.out.println(b);
    // b.piece(1, 2).checkMoves(b);
    // System.out.println(b.piece(1, 2)._possibleMoves); // check if it does ok with board boundaries

    b.addPiece("R", 0, 0, 1);
    b.addPiece("B", 2, 4, -1);
    System.out.println(b);

    b.piece(1, 2).checkMoves(b);
    System.out.println(b.piece(1, 2)._possibleMoves); // check how it does with other pieces
    */

    /*
    System.out.println("testing the pawn checkmoves function");
    b.addPiece("P", 1, 2, 1);
    System.out.println(b);
    // b.piece(1, 2).checkMoves(b);
    // System.out.println(b.piece(1, 2)._possibleMoves); // check if it does ok with board boundaries

    b.addPiece("R", 2, 3, -1); // testing normal taking case
    b.addPiece("P", 1, 1, -1); // testing en passant case
    b.piece(1, 1)._justJumped2 = true;
    // should also be possible to move forward two

    System.out.println(b);

    b.piece(1, 2).checkMoves(b);
    System.out.println(b.piece(1, 2)._possibleMoves); // check how it does with other pieces
    */
    /*
    System.out.println("testing the checkDanger function");
    b.addPiece("K", 3, 4, 1);
    System.out.println(b);
    // b.piece(1, 2).checkMoves(b);
    // System.out.println(b.piece(1, 2)._possibleMoves); // check if it does ok with board boundaries

    // b.addPiece("Q", 2, 3, -1); // should endanger the king
    b.addPiece("R", 3, 6, 1); // should not endanger the king
    b.addPiece("B", 2, 4, -1); // should not endanger the king
    // b.addPiece("N", 2, 2, -1); // should endanger king
    b.addPiece("P", 4, 3, -1); // should endanger king

    System.out.println(b);
    System.out.println(b.checkDanger(1, new Location(3, 4) ) );
    */

    System.out.println("testing the checkMoves function for king");
    b.addPiece("K", 3, 4, 1);
    System.out.println(b);
    b.addPiece("B", 2, 4, -1); // blocks two squares and the square it's on

    System.out.println(b);
    b.piece(3, 4).checkMoves(b);
    System.out.println(b.piece(3, 4)._possibleMoves);




  //  System.out.println()
  }
}
