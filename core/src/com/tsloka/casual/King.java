package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class King implements Figure {
    final FigureType figureType = FigureType.KING;
    final Colour colour;
    final Texture texture;

    public King(Colour colour) {
        this.colour = colour;
        if(colour == Colour.WHITE) {
            texture = new Texture("core/assets/WhiteKing.png");
        } else {
            texture = new Texture("core/assets/BlackKing.png");
        }
    }

    @Override
    public FigureType getType() {
        return FigureType.KING;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public List<Field> availableMoves() {
        //ToDo
        return null;
    }
}
