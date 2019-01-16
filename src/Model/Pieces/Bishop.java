package Model.Pieces;

import Enums.Color;
import Enums.PieceType;
import Helpers.getLegalMoves;
import Model.*;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
        setType(PieceType.BISHOP);
    }

    @Override
    public Boolean isNewSquareWithinReach(Square startSquare, Square endSquare) {

        Board board = new Board();
        List<Square> possibleSquares = getLegalMoves.getLegalDiagonalMoves(startSquare,board,this.color);

        for(Square s: possibleSquares){
            if(s.equals(endSquare)) return true;
        }
        return false;

    }

    @Override
    public List<Square> getLegalMovesOnBoard(Square startSquare, Board board) {
        return getLegalMoves.getLegalDiagonalMoves(startSquare,board,this.color);
    }
}
