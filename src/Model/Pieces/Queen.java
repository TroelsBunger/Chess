package Model.Pieces;

import Enums.Color;
import Enums.PieceType;
import Helpers.getLegalMoves;
import Model.Board;
import Model.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
        setType(PieceType.QUEEN);
    }

    @Override
    public Boolean isNewSquareWithinReach(Square startSquare, Square endSquare) {

        Board board = new Board();
        List<Square> possibleDiagonalSquares = getLegalMoves.getLegalDiagonalMoves(startSquare,board,this.color);
        List<Square> possibleStraightSquares = getLegalMoves.getLegalStraightMoves(startSquare,board,this.color);

        for(Square s: possibleDiagonalSquares){
            if(s.equals(endSquare)) return true;
        }

        for(Square s: possibleStraightSquares ){
            if(s.equals(endSquare)) return true;
        }

        return false;
    }

    @Override
    public List<Square> getLegalMovesOnBoard(Square startSquare, Board board) {
        List<Square> possibleDiagonalSquares = getLegalMoves.getLegalDiagonalMoves(startSquare,board,this.color);
        List<Square> possibleStraightSquares = getLegalMoves.getLegalStraightMoves(startSquare,board,this.color);

        possibleDiagonalSquares.addAll(possibleStraightSquares);

        return possibleDiagonalSquares;

    }
}
