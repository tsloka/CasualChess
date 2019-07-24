package com.tsloka.casual;

public class Bishop implements Figure {
    final FigureType figureType = FigureType.BISHOP;
    final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return false;
    }

    public Bishop(Colour colour) {
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
}
