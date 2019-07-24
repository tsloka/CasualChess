package com.tsloka.casual;

public class King implements Figure {
    final FigureType figureType = FigureType.KING;
    final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return isFirstMove;
    }

    public King(Colour colour) {
        this.colour = colour;
        isFirstMove = true;
    }

    @Override
    public FigureType getType() {
        return FigureType.KING;
    }

    @Override
    public Colour getColour() {
        return colour;
    }
}
