package Model.Pieces;

import Enums.Color;
import Enums.PieceType;
import Model.Board;
import Model.Square;

import java.util.List;

public abstract class Piece {

    protected String name;
    protected PieceType type;
    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public abstract Boolean isNewSquareWithinReach(Square startSquare, Square endSquare);

    public abstract List<Square> getLegalMovesOnBoard(Square startSquare, Board board);

}
