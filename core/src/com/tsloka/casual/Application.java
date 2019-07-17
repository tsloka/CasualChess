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

    public void createFiguresTextures() {
        Sprite blackBishop = new Sprite(new Texture("core/assets/BlackBishop.png"));
        Sprite blackKing = new Sprite(new Texture("core/assets/BlackKing.png"));
        Sprite blackKnight = new Sprite(new Texture("core/assets/BlackKnight.png"));
        Sprite blackPawn = new Sprite(new Texture("core/assets/BlackPawn.png"));
        Sprite blackQueen = new Sprite(new Texture("core/assets/BlackQueen.png"));
        Sprite blackRook = new Sprite(new Texture("core/assets/BlackRook.png"));
        Sprite whiteBishop = new Sprite(new Texture("core/assets/WhiteBishop.png"));
        Sprite whiteKing = new Sprite(new Texture("core/assets/WhiteKing.png"));
        Sprite whiteKnight = new Sprite(new Texture("core/assets/WhiteKnight.png"));
        Sprite whitePawn = new Sprite(new Texture("core/assets/WhitePawn.png"));
        Sprite whiteQueen = new Sprite(new Texture("core/assets/WhiteQueen.png"));
        Sprite whiteRook = new Sprite(new Texture("core/assets/WhiteRook.png"));
    }

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera(resolutionX, resolutionY);
        backgroundSprite = new Sprite(new Texture("core/assets/indigo-leather.png"));
        createFiguresTextures();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        camera.update();
        spriteBatch.end();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Field field : board.getFields()) {
            if (!field.isEmpty()) {
                Sprite figureSprite = new Sprite();
                        leftEndX + 5 + (field.getColumn() * 100),
                        leftEndY + 5 + (field.getRow() * 100),
                        90, 90);
                figureSprite.draw(spriteBatch);
            }
            if (field.getColour() == Colour.WHITE) {
                shapeRenderer.setColor(Color.LIGHT_GRAY);
            } else {
                shapeRenderer.setColor(Color.DARK_GRAY);
            }
            shapeRenderer.rect(leftEndX + (field.getColumn() * 100),
                    leftEndY + (field.getRow() * 100),
                    100, 100);
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        backgroundTexture.dispose();
    }
}