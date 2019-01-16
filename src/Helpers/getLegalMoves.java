package Helpers;

import Model.Board;
import Enums.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.List;

public class getLegalMoves {

    @SuppressWarnings("Duplicates")

    public static List<Square> getLegalStraightMoves(Square square, Board board, Color pc) {

        List<Square> squares = new ArrayList<>();

        int rowPlacement = square.getRowNumber();
        int columnPlacement = square.getColumnNumber();

       //move north on board
        for (int i = rowPlacement - 1; i >= 0; i--) {
            Square oneSquareUp = board.getSquare(i, columnPlacement);
            if(squareEmpty(oneSquareUp)) {
                squares.add(oneSquareUp);
                continue;
            }
            if(capturePossible(oneSquareUp, pc)) {
                squares.add(oneSquareUp);
                break;
            }
            break;
        }

        //move left on board
        for (int i = columnPlacement - 1; i >= 0; i--) {

            Square oneSquareLeft = board.getSquare(rowPlacement,i);

            if(squareEmpty(oneSquareLeft)) {
                squares.add(oneSquareLeft);
                continue;
            }
            if(capturePossible(oneSquareLeft, pc)) {
                squares.add(oneSquareLeft);
                break;
            }
            break;
        }

        //move south on board
        for (int i = rowPlacement +1 ; i <= 7; i++) {
            Square oneSquareDown = board.getSquare(i, columnPlacement);

            if(squareEmpty(oneSquareDown)) {
                squares.add(oneSquareDown);
                continue;
            }
            if(capturePossible(oneSquareDown, pc)) {
                squares.add(oneSquareDown);
                break;
            }
            break;
        }


        //move right on board
        for (int i = columnPlacement + 1; i <= 7; i++) {
            Square oneSquareRight = board.getSquare(rowPlacement,i);

            if(squareEmpty(oneSquareRight)) {
                squares.add(oneSquareRight);
                continue;
            }
            if(capturePossible(oneSquareRight, pc)) {
                squares.add(oneSquareRight);
                break;
                }
            break;
            }

        return squares;
    }

    @SuppressWarnings("Duplicates")
    public static List<Square> getLegalDiagonalMoves(Square square, Board board, Color pc){
        List<Square> squares = new ArrayList<>();

        int rowPlacement = square.getRowNumber();
        int columnPlacement = square.getColumnNumber();


        //move northeast on board
        for (int i = 1; rowPlacement - i  >= 0 && columnPlacement + i <=7; i++) {

            Square oneSquareUp = board.getSquare(rowPlacement-i, columnPlacement+i);
            if(squareEmpty(oneSquareUp)) {
                squares.add(oneSquareUp);
                continue;
            }
            if(capturePossible(oneSquareUp, pc)) {
                squares.add(oneSquareUp);
                break;
            }
            break;
        }

        //move northwest on board
        for (int i = 1; rowPlacement-i >=0 && columnPlacement -i >=0 ; i++) {

            Square oneSquareLeft = board.getSquare(rowPlacement-i,columnPlacement-i);

            if(squareEmpty(oneSquareLeft)) {
                squares.add(oneSquareLeft);
                continue;
            }
            if(capturePossible(oneSquareLeft, pc)) {
                squares.add(oneSquareLeft);
                break;
            }
            break;
        }

        //move southwest on board
        for (int i = 1; rowPlacement + i <=7 && columnPlacement -i >= 0; i++) {
            Square oneSquareDown = board.getSquare(rowPlacement + i, columnPlacement - i);

            if(squareEmpty(oneSquareDown)) {
                squares.add(oneSquareDown);
                continue;
            }
            if(capturePossible(oneSquareDown, pc)) {
                squares.add(oneSquareDown);
                break;
            }
            break;
        }

        //move southeast on board
        for (int i = 1; rowPlacement + i <=7 && columnPlacement + i <=7 ; i++) {
            Square oneSquareRight = board.getSquare(rowPlacement+i, columnPlacement+i);

            if(squareEmpty(oneSquareRight)) {
                squares.add(oneSquareRight);
                continue;
            }
            if(capturePossible(oneSquareRight, pc)) {
                squares.add(oneSquareRight);
                break;
            }
            break;
        }

        return squares;
    }

    public static List<Square> getLegalKingMoves(Square square, Board board, Color pc){

        List<Square> squares = new ArrayList<>();

        int rowPlacement = square.getRowNumber();
        int columnPlacement = square.getColumnNumber();

        for (int i = rowPlacement -1; i<=rowPlacement+1; i++){
            for(int j = columnPlacement -1 ; j <= columnPlacement +1; j++){

                if(j>=0 && j<=7 &&i>=0 && i<=7){
                    Square possibleSquare = board.getSquare(i,j);
                    if(possibleSquare.getPieceFromSquare() == null ||
                            possibleSquare.getPieceFromSquare().getColor() != pc){
                        squares.add(possibleSquare);
                    }
                }

            }
        }

        return squares;

    }

    public static List<Square> getLegalKnightMoves(Square square, Board board, Color pc){

        List<Square> squares = new ArrayList<>();

        int rowPlacement = square.getRowNumber();
        int columnPlacement = square.getColumnNumber();

        List<Square> candidateSquares = List.of(
                        new Square(rowPlacement-1, columnPlacement-2),
                        new Square(rowPlacement-1, columnPlacement+2),
                        new Square(rowPlacement-2, columnPlacement+1),
                        new Square(rowPlacement-2, columnPlacement-1),
                        new Square(rowPlacement+1, columnPlacement-2),
                        new Square(rowPlacement+1, columnPlacement+2),
                        new Square(rowPlacement+2, columnPlacement-1),
                        new Square(rowPlacement+2, columnPlacement+1)
                        );

        for(Square s: candidateSquares){
            if(withinBoard(s)){
                Square boardSquare = board.getSquare(s.getRowNumber(),s.getColumnNumber());
                if(boardSquare.getPieceFromSquare() == null
                        || boardSquare.getPieceFromSquare().getColor() != pc)
                    squares.add(s);
            }
        }

        return squares;
    }

    public static List<Square> getLegalPawnMoves(Square square, Board board, Color pc){
        List<Square> squares = new ArrayList<>();

        int rowPlacement = square.getRowNumber();
        int columnPlacement = square.getColumnNumber();

        if (pc == Color.WHITE && rowPlacement >= 1){
            Square oneAhead = board.getSquare(rowPlacement-1, columnPlacement);
            if (oneAhead.getPieceFromSquare()==null){
                squares.add(oneAhead);
                if (rowPlacement == 6){
                    Square twoAhead = board.getSquare(rowPlacement-2, columnPlacement);
                    if(twoAhead.getPieceFromSquare() == null) squares.add(twoAhead);
                }
            }
            if(columnPlacement != 7){
                Square takeRight = board.getSquare(rowPlacement-1,columnPlacement + 1);
                if(takeRight.getPieceFromSquare() != null && takeRight.getPieceFromSquare().getColor()!= pc) squares.add(takeRight);
            }
            if(columnPlacement != 0){
                Square takeLeft = board.getSquare(rowPlacement-1, columnPlacement-1);
                if(takeLeft.getPieceFromSquare()!= null && takeLeft.getPieceFromSquare().getColor() != pc) squares.add(takeLeft);
                }
            }

        if(pc == Color.BLACK && rowPlacement <= 6){
            Square oneAhead = board.getSquare(rowPlacement+1, columnPlacement);
            if (oneAhead.getPieceFromSquare()==null){
                squares.add(oneAhead);
                if (rowPlacement == 1){
                    Square twoAhead = board.getSquare(rowPlacement+2, columnPlacement);
                    if(twoAhead.getPieceFromSquare() == null) squares.add(twoAhead);
                }
            }
            if(columnPlacement != 7) {
                Square takeLeft = board.getSquare(rowPlacement + 1, columnPlacement + 1);
                if (takeLeft.getPieceFromSquare() != null && takeLeft.getPieceFromSquare().getColor() != pc) squares.add(takeLeft);
            }
            if(columnPlacement != 0){
                Square takeRight = board.getSquare(rowPlacement+1,columnPlacement - 1);
                if(takeRight.getPieceFromSquare()!= null && takeRight.getPieceFromSquare().getColor()!= pc) squares.add(takeRight);
            }

        }
            return squares;

    }

    private static boolean capturePossible(Square square, Color thisColor) {
        return square.getPieceFromSquare() != null && square.getPieceFromSquare().getColor() != thisColor;
    }

    private static boolean squareEmpty(Square square) {
        return square.getPieceFromSquare() == null;
    }

    private static boolean withinBoard(Square s){
        return s.getColumnNumber() <=7 && s.getColumnNumber() >=0
                && s.getRowNumber() >= 0 && s.getRowNumber() <= 7;
    }


}
