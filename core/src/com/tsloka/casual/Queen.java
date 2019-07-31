package com.tsloka.casual;

public class Queen implements Figure {
    private final FigureType figureType = FigureType.QUEEN;
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
