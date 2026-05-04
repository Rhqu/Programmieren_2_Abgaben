package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Represents a shot fired by Mario.
 */
class MarioShot extends GameObject {
    private Mario mario;

    /**
     * Creates a new GameObject.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     * @param mario           the Mario that fired the shot.
     */
    MarioShot(GameView gameView, GamePlayManager gamePlayManager, Mario mario) {
        super(gameView, gamePlayManager);
        this.mario = mario;
        this.position.updateCoordinates(mario.getPosition());
        speedInPixel = 4;
    }

    @Override
    public void updatePosition() {
        position.right(speedInPixel);
    }

    @Override
    public void updateStatus() {
        if (position.getX() > 1280 || position.getY() > 720 || position.getX() < 0 || position.getY() < 0) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("blast.png", position.getX() + 15, position.getY() + 15, 2, 0);
    }
}
