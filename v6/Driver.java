import java.util.ArrayList;

public class Driver{
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
    
  }
}
