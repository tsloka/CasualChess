package com.tsloka.casual;

public interface Figure {
    FigureType getType();
    Colour getColour();
    boolean getIsFirstMove();
    void otherThanFirstMove();
}
