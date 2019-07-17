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

    public List<Field> getFields(){
        return Arrays.stream(board).flatMap(fields -> Arrays.stream(fields)).collect(toList());
    }

    public void fillWithChess() {
        //ToDo

    }

}
