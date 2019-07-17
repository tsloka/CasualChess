package com.tsloka.casual;

import java.util.List;

public class Bishop implements Figure {
    final FigureType figureType = FigureType.BISHOP;
    final Colour colour;

    public Bishop(Colour colour) {
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
