package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;
import thd.gameobjects.movable.MarioShot;

/**
 * Used brick block that remains after a lucky block has been triggered.
 */
public class UsedBrick extends Block {

    /**
     * Creates a new UsedBrick.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public UsedBrick(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(600, 680);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
        width = 46;
        height = 46;
        hitBoxOffsets(0, 0, -6, -8);
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("brick_after_lucky.png", position.getX(), position.getY(), 2.5, rotation);
    }

}
