package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Knight implements Figure {
    final FigureType figureType = FigureType.KNIGHT;
    final Colour colour;
    final Texture texture;

    public Knight(Colour colour) {
        this.colour = colour;
        if(colour == Colour.WHITE) {
            texture = new Texture("core/assets/WhiteKnight.png");
        } else {
            texture = new Texture("core/assets/BlackKnight.png");
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
        //ToDo
        return null;
    }
}
