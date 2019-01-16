package Model.Pieces;

import Enums.Color;
import Enums.PieceType;
import Helpers.getLegalMoves;
import Model.Board;
import Model.Square;
import java.util.List;

public class Knight extends Piece {


    public Knight(Color color) {
        super(color);
        setType(PieceType.KNIGHT);
    }

    @Override
    public Boolean isNewSquareWithinReach(Square startSquare, Square endSquare) {
        Board board = new Board();
        List<Square> possibleSquares = getLegalMoves.getLegalKnightMoves(startSquare,board,this.color);

        for(Square s: possibleSquares){
            if (s.equals(endSquare)) return true;
        }

        return false;

    }

    @Override
    public List<Square> getLegalMovesOnBoard(Square startSquare, Board board) {
        return getLegalMoves.getLegalKnightMoves(startSquare,board,this.color);
    }
}
