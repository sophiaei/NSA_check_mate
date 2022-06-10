public class Woo{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Game game = new Game();
    ArrayList<Piece> captured = new ArrayList<>();

    System.out.println("Welcome to your game of chess! The first player will begin as WHITE.")
    while (!game._over){
      //print match status
      System.out.println(game.brd);
      System.out.print("Select a piece to move: ");
      Position ogLoc = game.brd.readLocation(sc);
      boolean[][] possibleMoves = game.possibleMoves(ogLoc);
      //clear screen
      //print game with possible locations marked
      System.out.print("Select location to move to: ");
      Position tgtLoc = game.brd.readLocation(sc);
      Piece captPiece = game.move(ogLoc, tgtLoc);
      if (captPiece != null ){
        captured.add(captPiece);
      }
      if(game.promoted != null){
        System.out.println("Select the character of the piece to promote to:");
        String type = sc.nextLine();
        game.promotePiece(type);
      }

    }
    //clear screen
    //print match status
  }
}
