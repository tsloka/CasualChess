package com.tsloka.casual;

import java.util.ArrayList;
import java.util.List;

public class FigureMover {
    Figure figure;
    Board board;
    Field startingField;
    Field endingField;

    public FigureMover() {
    }

    public List<Field> highlightAvailableMoves(Field startingField) {
        List<Field> availableMoves = new ArrayList<>();
        boolean white = false;

        if(startingField.getFigure().getColour()==Colour.WHITE){
            white = true;
        }

        switch (startingField.getFigure().getType()) {
            case PAWN:
                if(white) {
                    board.getFields().
                }
                break;
        }
        return availableMoves;
    }

    public void moveFigure (Field startingField, Field endingField) {

    }
}
