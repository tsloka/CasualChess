package com.tsloka.casual;

public class Pawn implements Figure {
    protected final FigureType figureType = FigureType.PAWN;
    protected final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean isFirstMove() {
        return isFirstMove;
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

}