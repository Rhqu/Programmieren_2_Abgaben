package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;

/**
 * Koopa enemy that moves along a quadratic path.
 */
public class Koopa extends GameObject {

    /**
     * Creates a new Koopa.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Koopa(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(200, 650);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
        speedInPixel = 2;
    }

    /**
     * Updates the status of Koopa.
     */
    @Override
    public void updateStatus() {
        if (position.getX() > 1280 || position.getY() > 720 || position.getX() < 0 || position.getY() < 0) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    @Override
    public void updatePosition() {
        position.left(speedInPixel);
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("koopa_resized.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
