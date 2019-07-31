package com.tsloka.casual;

public class Rook implements Figure {
    private final FigureType figureType = FigureType.ROOK;
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
