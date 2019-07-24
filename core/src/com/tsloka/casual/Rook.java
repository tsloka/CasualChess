package com.tsloka.casual;

public class Rook implements Figure {
    final FigureType figureType = FigureType.ROOK;
    final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return isFirstMove;
    }

    public Rook(Colour colour) {
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
