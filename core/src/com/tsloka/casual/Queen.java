package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Queen implements Figure {
    final FigureType figureType=FigureType.QUEEN;
    final Colour colour;
    final Texture texture;

    public Queen(Colour colour) {
        this.colour = colour;
        if(colour == Colour.WHITE) {
            texture = new Texture("core/assets/WhiteQueen.png");
        } else {
            texture = new Texture("core/assets/BlackQueen.png");
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

    @Override
    public Texture getTexture() {
        return texture;
    }
}
