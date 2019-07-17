package com.tsloka.casual;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public interface Figure {
    FigureType getType();
    Colour getColour();
    List<Field> availableMoves();
    Texture getTexture();
}
