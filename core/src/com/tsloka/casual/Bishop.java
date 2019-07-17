package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Bishop implements Figure {
    final FigureType figureType=FigureType.BISHOP;
    final Colour colour;
    final Texture texture;

    public Bishop(Colour colour) {
        this.colour = colour;
        if(colour == Colour.WHITE) {
            texture = new Texture("core/assets/WhiteBishop.png");
        } else {
            texture = new Texture("core/assets/BlackBishop.png");
        }
    }

    @Override
    public FigureType getType() {
        return figureType;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public List<Field> availableMoves() {
        // ToDo
        return null;
    }
}
