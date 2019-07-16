package com.tsloka.casual;

public class Board {
    Field[][] board = new Field[8][8];

    public Board() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                boolean isBlack = false;
                if (i % 2 == 0) {
                    isBlack = true;
                }
                if (j % 2 == 0) {
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

    public void fillWithChess() {


    }

}
