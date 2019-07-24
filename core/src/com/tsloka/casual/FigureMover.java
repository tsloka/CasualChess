package com.tsloka.casual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FigureMover {
    private Board board;
    private Field startingField;
    private Field endingField;

    public FigureMover() {
    }

    public List<Field> highlightAvailableMoves(Field startingField) {
        List<Field> availableMoves = new ArrayList<>();
        List<Field> temporary = board.getFields().stream().filter(Field::isEmpty).collect(Collectors.toList());
        switch (startingField.getFigure().getType()) {
            case QUEEN:
                List<Field> diagonalQueenFields = checkDiagonal(7,startingField,temporary);
                List<Field> axialQueenFields = checkInAxis(7,startingField,temporary);
                availableMoves.addAll(diagonalQueenFields);
                availableMoves.addAll(axialQueenFields);

                break;
            case KING:
                List<Field> diagonalKingFields = checkDiagonal(1,startingField,temporary);
                List<Field> axialKingFields = checkInAxis(1,startingField,temporary);
                availableMoves.addAll(diagonalKingFields);
                availableMoves.addAll(axialKingFields);

                // ToDo Castling
                break;
            case ROOK:
                availableMoves.addAll(checkInAxis(7,startingField,temporary));
                // ToDo Castling
                break;
            case BISHOP:
                availableMoves.addAll(checkDiagonal(7,startingField,temporary));

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
                    board.getFields().stream().filter(Field::isEmpty)
                            .filter(field -> field.getColumn() == startingField.getColumn()
                                    && field.getRow() != startingField.getRow())
                            .filter(field -> (field.getRow() - startingField.getRow()) == 1
                                    && (field.getRow() - startingField.getRow()) == -1)
                            .forEach(availableMoves::add);
                }
                if (startingField.getFigure().getColour() == Colour.BLACK) {
                    availableMoves.stream().filter(field -> (field.getRow() - startingField.getRow()) > 0)
                            .forEach(availableMoves::add);
                } else {
                    availableMoves.stream().filter(field -> (field.getRow() - startingField.getRow()) < 0)
                            .forEach(availableMoves::add);
                }
                // ToDo Pawn en passant
                // ToDo check finder
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

    public static List<Field> checkDiagonal(int j, Field startingField, List<Field> tList) {
        List<Field> returnList = new ArrayList<>();
        for (int i = 1; i <= j; i++) {
            for (Field field : tList) {
                if ((field.getRow() == (startingField.getRow() + i)) &&
                        (field.getColumn() == (startingField.getColumn() + i)) ||
                        (field.getRow() == (startingField.getRow() - i)) &&
                                (field.getColumn() == (startingField.getColumn() - i)) ||
                        (field.getRow() == (startingField.getRow() + i)) &&
                                (field.getColumn() == (startingField.getColumn() - i)) ||
                        (field.getRow() == (startingField.getRow() - i)) &&
                                (field.getColumn() == (startingField.getColumn() + i))) {
                    returnList.add(field);
                }
            }
        }
        return returnList;
    }

    public static List<Field> checkInAxis(int j, Field startingField, List<Field> tList) {
        List<Field> returnList = new ArrayList<>();
        for (int i = 1; i <= j; i++) {
            for (Field field : tList) {
                if ((field.getRow() == startingField.getRow()) &&
                        (field.getColumn() == (startingField.getColumn() + i)) ||
                        (field.getRow() == startingField.getRow()) &&
                                (field.getColumn() == (startingField.getColumn() - i)) ||
                        (field.getRow() == (startingField.getRow() - i)) &&
                                (field.getColumn() == startingField.getColumn()) ||
                        (field.getRow() == (startingField.getRow() + i)) &&
                                (field.getColumn() == startingField.getColumn())) {
                    returnList.add(field);
                }
            }
        }
        return returnList;
    }
}
