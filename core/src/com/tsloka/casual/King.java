package com.tsloka.casual;

import java.util.List;

public class King implements Figure {
    final FigureType figureType = FigureType.KING;
    final Colour colour;
    private int actualRow;
    private int actualColumn;

    public int getActualRow() {
        return actualRow;
    }

    public void setActualRow(int actualRow) {
        this.actualRow = actualRow;
    }

    public int getActualColumn() {
        return actualColumn;
    }

    public void setActualColumn(int actualColumn) {
        this.actualColumn = actualColumn;
    }

    public King(Colour colour) {
        this.colour = colour;
    }

    @Override
    public FigureType getType() {
        return FigureType.KING;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public List<Field> availableMoves() {
        //ToDo
        return null;
    }
}
