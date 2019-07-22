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

    private static Texture blackBishop;
    private static Texture blackKing;
    private static Texture blackKnight;
    private static Texture blackPawn;
    private static Texture blackQueen;
    private static Texture blackRook;
    private static Texture whiteBishop;
    private static Texture whiteKing;
    private static Texture whiteKnight;
    private static Texture whitePawn;
    private static Texture whiteQueen;
    private static Texture whiteRook;

    public Texture selectFigureTexture(FigureType figureType, Colour colour) {
        Texture returnTexture = null;
        switch (figureType) {
            case BISHOP:
                if (colour == Colour.BLACK) {
                    returnTexture = blackBishop;
                } else {
                    returnTexture = whiteBishop;
                }
                break;
            case KING:
                if (colour == Colour.BLACK) {
                    returnTexture = blackKing;
                } else {
                    returnTexture = whiteKing;
                }
                break;
            case KNIGHT:
                if (colour == Colour.BLACK) {
                    returnTexture = blackKnight;
                } else {
                    returnTexture = whiteKnight;
                }
                break;
            case PAWN:
                if (colour == Colour.BLACK) {
                    returnTexture = blackPawn;
                } else {
                    returnTexture = whitePawn;
                }
                break;
            case QUEEN:
                if (colour == Colour.BLACK) {
                    returnTexture = blackQueen;
                } else {
                    returnTexture = whiteQueen;
                }
                break;
            case ROOK:
                if (colour == Colour.BLACK) {
                    returnTexture = blackRook;
                } else {
                    returnTexture = whiteRook;
                }
                break;
        }
        return returnTexture;
    }

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera(resolutionX, resolutionY);
        backgroundSprite = new Sprite(new Texture("core/assets/indigo-leather.png"));
        blackBishop = new Texture("core/assets/BlackBishop.png");
        blackKing = new Texture("core/assets/BlackKing.png");
        blackKnight = new Texture("core/assets/BlackKnight.png");
        blackPawn = new Texture("core/assets/BlackPawn.png");
        blackQueen = new Texture("core/assets/BlackQueen.png");
        blackRook = new Texture("core/assets/BlackRook.png");
        whiteBishop = new Texture("core/assets/WhiteBishop.png");
        whiteKing = new Texture("core/assets/WhiteKing.png");
        whiteKnight = new Texture("core/assets/WhiteKnight.png");
        whitePawn = new Texture("core/assets/WhitePawn.png");
        whiteQueen = new Texture("core/assets/WhiteQueen.png");
        whiteRook = new Texture("core/assets/WhiteRook.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        camera.update();
        spriteBatch.end();

        for (Field field : board.getFields()) {
            shapeRenderer.setProjectionMatrix(camera.combined);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            if (field.getColour() == Colour.WHITE) {
                shapeRenderer.setColor(Color.LIGHT_GRAY);
            } else {
                shapeRenderer.setColor(Color.DARK_GRAY);
            }
            shapeRenderer.rect(leftEndX + (field.getColumn() * 100),
                    leftEndY + (field.getRow() * 100),
                    100, 100);
            shapeRenderer.end();

            //This part either doesn`t work or creates figures in lower left corner
            if (!field.isEmpty()) {
                spriteBatch.begin();
                Sprite figureSprite = new Sprite((selectFigureTexture(field.getFigure().getType(), field.getFigure().getColour())),
                        leftEndX + 5 + (field.getColumn() * 100),
                        leftEndY + 5 + (field.getRow() * 100),
                        90, 90);
                figureSprite.draw(spriteBatch);
                spriteBatch.end();
            }

        }


    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }
}