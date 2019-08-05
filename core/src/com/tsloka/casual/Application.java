package com.tsloka.casual;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Application extends ApplicationAdapter {
    private static final String TAG = Application.class.getName();
    private static Sprite backgroundSprite;
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
    private final int leftEndX = 400;
    private final int leftEndY = 50;
    Board board = new Board();
    ClickListener mouseClick;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private Stage stage;
    private int resolutionX = 1600;
    private int resolutionY = 900;

    @Override
    public void create() {
        Gdx.app.log(TAG, "Creation");
        stage = new Stage(new ScreenViewport());
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
        mouseClick = new ClickListener();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "Resized");
        float aspectRatio = 1.0f * width / height;
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void render() {
        Gdx.app.log(TAG, "Rendered");
//        long startTimeNs = System.nanoTime();
        Gdx.gl.glClearColor(1, 1, 1, 1);
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

            // ToDo Refine background of texture to fully transparent and position set to centre of field
            if (!field.isEmpty()) {
                spriteBatch.begin();
                Sprite figureSprite = new Sprite((selectFigureTexture(field.getFigure().getType(),
                        field.getFigure().getColour())), 0, 0, 90, 90);
                figureSprite.setBounds((float) ((field.getColumn() * 100) + leftEndX + 5),
                        (float) ((field.getRow() * 100) + leftEndY + 5), 90, 90);
                figureSprite.draw(spriteBatch);
                spriteBatch.end();
            }

        }


    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "Paused");
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "Disposed:");
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "Resumed");
    }

// Additional methods

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

    public void setMouseClick(ClickListener mouseClick) {
        this.mouseClick = mouseClick;
        float clickX = mouseClick.getTouchDownX();
        float clickY = mouseClick.getTouchDownY();


    }
}
