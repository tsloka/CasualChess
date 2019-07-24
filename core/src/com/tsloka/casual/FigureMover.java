package com.tsloka.casual;

import java.util.ArrayList;
import java.util.List;

public class FigureMover {
    private Board board;
    private Field startingField;
    private Field endingField;

    public FigureMover() {
    }

    public List<Field> highlightAvailableMoves(Field startingField) {
        List<Field> availableMoves = new ArrayList<>();

        switch (startingField.getFigure().getType()) {
            case QUEEN:

                break;
            case KING:

                // ToDo Castling
                break;
            case ROOK:

                // ToDo Castling
                break;
            case BISHOP:

                break;
            case PAWN:
                if (startingField.getFigure().isFirstMove()) {
                    board.getFields().stream().filter(Field::isEmpty)
                            .filter(field -> field.getColumn() == startingField.getColumn()
                            && field.getRow() != startingField.getRow())
                            .filter(field -> (field.getRow() - startingField.getRow()) <= 2
                                    && (field.getRow() - startingField.getRow()) >= -2)
                            .forEach(availableMoves::add);
                } else {
                    board.getFields().stream().filter(field -> field.getColumn() == startingField.getColumn()
                            && field.getRow() != startingField.getRow())
                            .filter(field -> (field.getRow() - startingField.getRow()) <= 1
                                    && (field.getRow() - startingField.getRow()) >= -1)
                            .forEach(availableMoves::add);
                }
                if (startingField.getFigure().getColour() == Colour.BLACK) {
                    availableMoves.stream().filter(field -> (field.getRow() - startingField.getRow()) > 0)
                            .forEach(availableMoves::add);
                } else {
                    availableMoves.stream().filter(field -> (field.getRow() - startingField.getRow()) > 0)
                            .forEach(availableMoves::add);
                }
                // ToDo Pawn en passant

                break;
            case KNIGHT:

                break;
        }
        return availableMoves;
    }

    public void moveFigure(Field startingField, Field endingField) {
        // ToDo
        // Remember pawn promotion, pawn en passant
        // Remember king castling, check, checkmate

    }
}
