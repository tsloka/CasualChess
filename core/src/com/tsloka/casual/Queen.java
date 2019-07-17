package com.tsloka.casual;

import java.util.List;

public class Queen implements Figure {
    final FigureType figureType = FigureType.QUEEN;
    final Colour colour;


    public Queen(Colour colour) {
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
