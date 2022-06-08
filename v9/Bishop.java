import java.util.ArrayList;

public class Bishop extends Piece{
  public Bishop(/* Board board, */ int clr, Location where){
     super( /*board, */clr, where);
  }
  public String toString(){
    return "B";
  }
  public void checkMoves(Board brd){ // this is just the board that the piece is on


        int[][] directions = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} }; // NE, NW, SE, SW
        for(int[] coors : directions){
          // adds the translation until you ucan't go anymore
          // start at the current location plus translation once
          // end when you either hit a piece
          Location temp = new Location(_current._row, _current._column );

          for (int i = 1; i < 8; i++){ // you can, at most, add the translation 7 times provided you don't break before then
            temp.setValues(temp.getRow() + coors[0], temp.getColumn() + coors[1]);
            if (brd.thereIsAPiece(temp) ){ // is there a piece there?

              if (brd.piece(temp)._color == this._color ){ // if the color of the piece at temp is the same
                break;
              }
             _possibleMoves.add(temp);
              break;// do you need two breaks to break two for loops?
            }
            _possibleMoves.add(temp);
          }
//
//           for (int r = _current._row + coors[0]; 0 <= r && r < 8; r+=coors[0]){ //
//             for (int c = _current._column + coors[1]; 0 <= c && c < 8; c+=coors[1]){
//               temp = new Location(r, c); //temp is just the coordinates for this iteration in location form
//               if (brd.thereIsAPiece(temp) ){ // is there a piece there?
//                 if (brd.piece(temp)._color = this._color ){ // if the color of the piece at temp is the same
//                   break;
//                   break;
//                 }
// `               _possibleMoves.add(temp);
//                 break;
//                 break; // do you need two breaks to break two for loops?
//               }
//               _possibleMoves.add(temp);
//             }
//           }



      }
    }

  }
