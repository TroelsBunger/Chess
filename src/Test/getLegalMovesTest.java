package Test;

import Helpers.getLegalMoves;
import Model.Board;
import Enums.Color;
import Model.Pieces.Piece;
import Model.Square;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class getLegalMovesTest {
    @Test
    public void getLegalStraightMovesSquare_0_0_Returns14_LegalMoves() throws Exception {

        Board board = new Board();
        Square square = new Square(0,0);

        List<Square> result = getLegalMoves.getLegalStraightMoves(square,board, Color.WHITE);

        Assert.assertEquals(14, result.size());

    }

    @Test
    public void getLegalStraightMovesSquare_0_0_Blocked_Returns_0_LegalMoves() throws Exception {

        Board board = new Board();

        Square square = new Square(0,0);

        List<Square> result = getLegalMoves.getLegalStraightMoves(square,board, Color.WHITE);

        Assert.assertEquals(14, result.size());

    }

    @Test
    public void getLegalDiagonalMovesReturns7_LegalMovesWhenGiven0_0() throws Exception {

        Board board = new Board();

        Square square = new Square(0,0);

        List<Square> result = getLegalMoves.getLegalDiagonalMoves(square,board, Color.WHITE);

        Assert.assertEquals(7, result.size());
    }

    @Test
    public void getLegalDiagonalMovesReturns13_LegalMovesWhenGiven3_3() throws Exception {

        Board board = new Board();

        Square square = new Square(3,3);

        List<Square> result = getLegalMoves.getLegalDiagonalMoves(square,board, Color.WHITE);

        for (Square s : result){
            System.out.println("Row: " + s.getRowNumber() + " Column: " + s.getColumnNumber());
        }

        Assert.assertEquals(13, result.size());
    }

    @Test
    public void setupOfBoardGives40legalMovesForBlackAndWhite() throws Exception {

        Board board = new Board();
        List<Square> possiblemoves = new ArrayList<>();

        for(int i = 0; i<=7; i++){
            for(int j = 0; j<=7; j++){
                Piece piece = board.getSquare(i,j).getPieceFromSquare();
                if(piece != null){
                    possiblemoves.addAll(piece.getLegalMovesOnBoard(board.getSquare(i,j), board));
                }
            }
        }

        Assert.assertEquals(40, possiblemoves.size());

    }

}