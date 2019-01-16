package Model;

import Model.Pieces.Piece;

public class Square {

    private int rowNumber;
    private int columnNumber;
    private Piece pieceOnSquare;

    public Square(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void addPiecetoSquare(Piece pieceonSquare) {
        this.pieceOnSquare = pieceonSquare;
    }

    public void removePieceFromSquare(){
    }

    public Piece getPieceFromSquare(){
        if (pieceOnSquare!=null) return pieceOnSquare;
        return null;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;

        if(!(o instanceof Square)) return false;

        Square s = (Square) o;

        return s.getRowNumber()==this.getRowNumber()
                && s.getColumnNumber()==this.getColumnNumber();


    }
}
