package com.tsloka.casual;

public class Knight implements Figure {
    final FigureType figureType = FigureType.KNIGHT;
    final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return isFirstMove;
    }

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

}
