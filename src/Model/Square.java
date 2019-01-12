package Model;

public class Square {

    private int vertialPlacement;
    private int horiznotalPlacement;
    private Piece pieceonSquare;

    public Square(int vertialPlacement, int horiznotalPlacement) {
        this.vertialPlacement = vertialPlacement;
        this.horiznotalPlacement = horiznotalPlacement;
    }

    public int getVertialPlacement() {
        return vertialPlacement;
    }

    public int getHoriznotalPlacement() {
        return horiznotalPlacement;
    }

    public void addPiecetoSquare(Piece pieceonSquare) {
        this.pieceonSquare = pieceonSquare;
    }

    public void removePieceFromSquare(){

    }
}
