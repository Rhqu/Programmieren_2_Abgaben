package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;
import thd.gameobjects.movable.MarioShot;

/**
 * Solid block that serves as a platform in the level.
 */
public class Block extends CollidingGameObject {
    private boolean destroyed;

    /**
     * Creates a new Block.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Block(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(500, 600);
        size = 30;
        rotation = 0;
        width = 46;
        height = 46;
        hitBoxOffsets(0, 0, -6, -8);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof MarioShot) {
            gamePlayManager.destroyGameObject(this);
        }
    }


    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("brick.png", position.getX(), position.getY(), 2.5, rotation);
    }

}
