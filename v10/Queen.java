import java.util.ArrayList;

public class Queen extends Piece{

  public Queen(/*Board board, */int clr, Location where){
     super(/* board, */clr, where);
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
    output += "Q";
    output += colorText(RESET);
    return output;
  }

  public void checkMoves(){

  }
}
