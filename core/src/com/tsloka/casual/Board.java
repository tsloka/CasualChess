package com.tsloka.casual;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Board {
    final Field[][] board = new Field[8][8];

    public Board() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                boolean isBlack = false;
                if ((i + j) % 2 == 0) {
                    isBlack = true;
                } else {
                    isBlack = false;
                }
                if (isBlack) {
                    board[i][j] = new Field(Colour.BLACK, i, j);
                } else {
                    board[i][j] = new Field(Colour.WHITE, i, j);
                }
            }
        }
        fillWithChess();
    }

    public Field[][] getBoard() {
        return board;
    }

    public List<Field> getFields() {
        return Arrays.stream(board).flatMap(Arrays::stream).collect(toList());
    }

    public void fillWithChess() {
        fillFigures(Colour.WHITE, 0);
        for (int i = 0; i < 8; i++){
            board[i][1].setFigure(new Pawn(Colour.WHITE));
            board[i][6].setFigure(new Pawn(Colour.BLACK));
        }
        fillFigures(Colour.BLACK, 7);
    }

    public void fillFigures(Colour colour, int row) {
        board[0][row].setFigure(new Rook(colour));
        board[1][row].setFigure(new Knight(colour));
        board[2][row].setFigure(new Bishop(colour));
        board[3][row].setFigure(new Queen(colour));
        board[4][row].setFigure(new King(colour));
        board[5][row].setFigure(new Bishop(colour));
        board[6][row].setFigure(new Knight(colour));
        board[7][row].setFigure(new Rook(colour));
    }

}
