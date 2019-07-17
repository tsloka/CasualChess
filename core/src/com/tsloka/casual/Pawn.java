package com.tsloka.casual;

import java.util.List;

public class Pawn implements Figure {
    final FigureType figureType = FigureType.PAWN;
    final Colour colour;

    public Pawn(Colour colour) {
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
