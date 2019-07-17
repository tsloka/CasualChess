package com.tsloka.casual;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Application extends ApplicationAdapter {
    Board board = new Board();

    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;

    private static Texture backgroundTexture;
    private static Sprite backgroundSprite;

    private int resolutionX = 1600;
    private int resolutionY = 900;
    private final int leftEndX = -400;
    private final int leftEndY = -400;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera(resolutionX, resolutionY);
        backgroundTexture = new Texture("core/assets/indigo-leather.png");
        backgroundSprite = new Sprite(backgroundTexture);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Field field : board.getFields()) {
            if (field.isEmpty() == false) {
                Sprite figureSprite = new Sprite(field.getFigure().getTexture());
                figureSprite.draw(spriteBatch);
            }
            if (field.getColour() == Colour.WHITE) {
                shapeRenderer.setColor(Color.LIGHT_GRAY);
            } else {
                shapeRenderer.setColor(Color.DARK_GRAY);
            }
            shapeRenderer.rect(leftEndX + (field.getColumn() * 100), leftEndY + (field.getRow() * 100),
                    100, 100);

        }

        shapeRenderer.end();
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        backgroundTexture.dispose();
    }
}