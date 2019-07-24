package com.tsloka.casual;

import java.util.Objects;

public class Field {
    private Figure figure;
    private final Colour colour;
    private final int column;
    private final int row;

    public Field(Colour colour, int column, int row) {
        this.colour = colour;
        this.column = column;
        this.row = row;
    }

    public Field(Figure figure, Colour colour, int column, int row) {
        this.figure = figure;
        this.colour = colour;
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return column == field.column &&
                row == field.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public Colour getColour() {
        return colour;
    }

    public boolean isEmpty() {
        return figure == null;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}