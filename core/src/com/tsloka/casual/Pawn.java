package com.tsloka.casual;

public class Pawn implements Figure {
    private final FigureType figureType = FigureType.PAWN;
    private final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean getIsFirstMove() {
        return isFirstMove;
    }

    @Override
    public void otherThanFirstMove() {
        isFirstMove = false;
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