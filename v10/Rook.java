import java.util.ArrayList;

public class Rook extends Piece{
  public Rook(/*Board board, */int clr, Location where){
     super( /*board, */clr, where);
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
    output += "R";
    output += colorText(RESET);
    return output;
  }

//   public void checkMoves(){
//
//
//
//
//
//       for(int x = _current._row+1; x<8;x++  ){//up
//         if(_current.thereIsAPiece(x, _current._column){
//           _possibleMoves.add(x,_current._column);
//           break;
//         }
//         else{
//           _possibleMoves.add(x,_current._column);
//         }
//   }
//   for(int x = _current._row-1; x>0;x--  ){//up
//     if(_current.thereIsAPiece(x, _current._column){
//       _possibleMoves.add(x,_current._column);
//       break;
//     }
//     else{
//       _possibleMoves.add(x,_current._column);
//     }
// }
//   for(int x = _current._column+1; x<8;x++  ){//up
//     if(_current.thereIsAPiece(_current._row, x){
//       _possibleMoves.add(_current._row, x);
//       break;
//     }
//     else{
//       _possibleMoves.add(_current._row, x);
//     }
//   }
//     for(int x = _current._column-1; x>0;x--  ){//up
//       if(_current.thereIsAPiece(_current._row, x){
//         _possibleMoves.add(_current._row, x);
//         break;
//       }
//       else{
//         _possibleMoves.add(_current._row, x);
//       }
//     }
//   } // end checkMoves


}
