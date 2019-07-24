package com.tsloka.casual;

public class Queen implements Figure {
    final FigureType figureType = FigureType.QUEEN;
    final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return isFirstMove;
    }

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

}
