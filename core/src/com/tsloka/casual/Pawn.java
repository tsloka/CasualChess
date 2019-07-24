package com.tsloka.casual;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Figure {
    protected final FigureType figureType = FigureType.PAWN;
    protected final Colour colour;
    private int actualRow;
    private int actualColumn;
    private boolean isFirstMove;

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

    public Pawn(Colour colour) {
        this.colour = colour;
        isFirstMove = true;
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
        List<Field> availableMoves = new ArrayList<>();
//        for (int i = 0; )

            return null;
    }
}
