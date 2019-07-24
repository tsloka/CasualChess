package com.tsloka.casual;

import java.util.List;

public class Knight implements Figure {
    final FigureType figureType = FigureType.KNIGHT;
    final Colour colour;

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

    private int actualRow;
    private int actualColumn;

    public Knight(Colour colour) {
        this.colour = colour;
    }

    @Override
    public FigureType getType() {
        return figureType;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public List<Field> availableMoves() {
        // ToDo
        return null;
    }

}
