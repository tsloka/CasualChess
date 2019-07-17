package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Pawn implements Figure {
    final FigureType figureType = FigureType.PAWN;
    final Colour colour;
    final Texture texture;

    public Pawn(Colour colour) {
        this.colour = colour;
        if(colour == Colour.WHITE) {
            texture = new Texture("core/assets/WhitePawn.png");
        } else {
            texture = new Texture("core/assets/BlackPawn.png");
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
