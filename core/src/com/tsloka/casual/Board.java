package com.tsloka.casual;

import com.badlogic.gdx.utils.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    public Field[][] getBoard() {
        return board;
    }

    public List<Field> getFields() {
        return Arrays.stream(board).flatMap(fields -> Arrays.stream(fields)).collect(toList());
    }

    public void fillWithChess() {
        fillFigures(Colour.WHITE, 0);
        for (int i = 0; i < 8; i++){
            board[1][i].setFigure(new Pawn(Colour.WHITE));
            board[6][i].setFigure(new Pawn(Colour.BLACK));
        }
        fillFigures(Colour.BLACK, 7);
    }

    public void fillFigures(Colour colour, int row) {
        board[row][0].setFigure(new Rook(colour));
        board[row][1].setFigure(new Knight(colour));
        board[row][2].setFigure(new Bishop(colour));
        board[row][3].setFigure(new Queen(colour));
        board[row][4].setFigure(new King(colour));
        board[row][5].setFigure(new Bishop(colour));
        board[row][6].setFigure(new Knight(colour));
        board[row][7].setFigure(new Rook(colour));
    }

}
