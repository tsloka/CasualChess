package com.tsloka.casual;

import java.util.List;

public interface Figure {
    FigureType getType();
    Colour getColour();
    List<Field> availableMoves();
    int getActualColumn();
    int getActualRow();
    void setActualColumn(int column);
    void setActualRow(int row);
}
