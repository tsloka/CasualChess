package com.tsloka.casual;

public class King implements Figure {
    private final FigureType figureType = FigureType.KING;
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
