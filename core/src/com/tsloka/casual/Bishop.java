package com.tsloka.casual;

public class Bishop implements Figure {
    private final FigureType figureType = FigureType.BISHOP;
    private final Colour colour;
    private boolean isFirstMove;

    @Override
    public boolean getIsFirstMove() {
        return false;
    }

    @Override
    public void otherThanFirstMove() {
        isFirstMove = false;
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
