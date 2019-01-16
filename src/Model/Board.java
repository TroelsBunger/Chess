package Model;

import Enums.Color;
import Model.Pieces.*;

public class Board {
    private Square[][] squares;
    private final int BOARDWIDTH = 8;
    private final int BOARDHEIGHT = 8;

    public Board() {
        setupBoard();
    }

    private void setupBoard(){

        squares = new Square [BOARDHEIGHT][BOARDWIDTH] ;

        //create squares on board
        for (int i = 0 ; i <=7 ; i++){
            for (int j = 0 ; j<=7; j++){
               squares[i][j] = new Square(i,j);
            }
        }

        //put pieces on board

        //black pieces
        squares[0][0].addPiecetoSquare(new Rook(Color.BLACK));
        squares[0][7].addPiecetoSquare(new Rook(Color.BLACK));
        squares[0][1].addPiecetoSquare(new Knight(Color.BLACK));
        squares[0][6].addPiecetoSquare(new Knight(Color.BLACK));
        squares[0][2].addPiecetoSquare(new Bishop(Color.BLACK));
        squares[0][5].addPiecetoSquare(new Bishop(Color.BLACK));
        squares[0][3].addPiecetoSquare(new Queen(Color.BLACK));
        squares[0][4].addPiecetoSquare(new King(Color.BLACK));

        for(int i = 0; i<=7 ; i++){
            squares[1][i].addPiecetoSquare(new Pawn(Color.BLACK));
        }
        //white pieces
        squares[7][0].addPiecetoSquare(new Rook(Color.WHITE));
        squares[7][7].addPiecetoSquare(new Rook(Color.WHITE));
        squares[7][1].addPiecetoSquare(new Knight(Color.WHITE));
        squares[7][6].addPiecetoSquare(new Knight(Color.WHITE));
        squares[7][2].addPiecetoSquare(new Bishop(Color.WHITE));
        squares[7][5].addPiecetoSquare(new Bishop(Color.WHITE));
        squares[7][3].addPiecetoSquare(new Queen(Color.WHITE));
        squares[7][4].addPiecetoSquare(new King(Color.WHITE));

        for(int i = 0; i <= 7; i++){
            squares[6][i].addPiecetoSquare(new Pawn(Color.WHITE));
        }


    }

    public Square getSquare(int row, int column){
        return squares[row][column];
    }

}
