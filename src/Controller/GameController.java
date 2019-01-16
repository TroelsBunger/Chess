package Controller;

import Enums.Color;
import Model.Board;
import Model.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Player player1;
    private Player player2;
    private Board board;
    private List<Piece> player1Pieces;
    private List<Piece> player2Pieces;
    private List<Move> gameMoves;

    public GameController() {
        player1 = new Player(Color.WHITE, "Player 1");
        player2 = new Player(Color.BLACK, "Player 2");
        board = new Board();
        player1Pieces = new ArrayList<>();
        player2Pieces = new ArrayList<>();
        gameMoves = new ArrayList<>();
    }

}
