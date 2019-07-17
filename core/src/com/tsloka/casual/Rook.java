package com.tsloka.casual;

import java.util.List;

public class Rook implements Figure {
    final FigureType figureType = FigureType.ROOK;
    final Colour colour;

    public Rook(Colour colour) {
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
