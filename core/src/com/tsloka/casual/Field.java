package com.tsloka.casual;

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