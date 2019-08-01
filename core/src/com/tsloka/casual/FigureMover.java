package com.tsloka.casual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FigureMover {
    private Board board;
    private Field startingField;
    private Field endingField;
    private boolean checkFinder = true;
    private Colour actualPlayer = Colour.WHITE;

    public FigureMover() {
    }

    public List<Field> highlightAvailableMoves(Field startingField) {
        List<Field> availableMoves = new ArrayList<>();
        List<Field> allFields = board.getFields().stream().filter(Field::isEmpty).collect(Collectors.toList());
        switch (startingField.getFigure().getType()) {
            case QUEEN:
                List<Field> diagonalQueenFields = checkDiagonal(7, startingField, allFields);
                List<Field> axialQueenFields = checkAxial(7, startingField, allFields);
                availableMoves.addAll(diagonalQueenFields);
                availableMoves.addAll(axialQueenFields);

                break;
            case KING:
                List<Field> diagonalKingFields = checkDiagonal(1, startingField, allFields);
                List<Field> axialKingFields = checkAxial(1, startingField, allFields);
                availableMoves.addAll(diagonalKingFields);
                availableMoves.addAll(axialKingFields);

                // ToDo Castling
                // ToDo Checkfinder
                break;
            case ROOK:
                availableMoves.addAll(checkAxial(7, startingField, allFields));
                // ToDo Castling
                break;
            case BISHOP:
                availableMoves.addAll(checkDiagonal(7, startingField, allFields));

                break;
            case PAWN:
                if (startingField.getFigure().getIsFirstMove()) {
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
        // ToDo moveFigure method
        // Remember pawn promotion, pawn en passant
        // Remember king castling, check, checkmate
        // Remember to change boolean getIsFirstMove to false

        // if (checkFinder()) break execution, sout Move unavailable, your King is checked;
        // if check and no available moves execute checkmate
        Figure figureMoved;
        endingField.setFigure(startingField.getFigure());
        endingField.getFigure().otherThanFirstMove();
        if (actualPlayer.equals(Colour.WHITE)) {
            actualPlayer = Colour.BLACK;
        } else {
            actualPlayer = Colour.WHITE;
        }
    }

    public static List<Field> checkDiagonal(int j, Field startingField, List<Field> tList) {
        List<Field> diagonalFields = new ArrayList<>();
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
                    if (field.isEmpty()) {
                        diagonalFields.add(field);
                    }
                }
            }
        }
        return diagonalFields;
    }

    public static List<Field> checkAxial(int j, Field startingField, List<Field> tList) {
        List<Field> axialFields = new ArrayList<>();
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
                    axialFields.add(field);
                }
            }
        }
        return axialFields;
    }

    public boolean checkFinder () {
        // ToDo CheckFinder method

        //if () {

        //}
        return checkFinder;
    }

    public void executeEnding() {
        // check mate

        //
    }
}
