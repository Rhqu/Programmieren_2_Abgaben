package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Used brick block that remains after a lucky block has been triggered.
 */
public class UsedBrick extends GameObject {

    /**
     * Crates a new Block.
     *
     * @param gameView GameView to show the game object on.
     */
    public UsedBrick(GameView gameView) {
        super(gameView);
        position.updateCoordinates(600, 600);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("brick_after_lucky.png", position.getX(), position.getY(), 2.5, rotation);
    }

}
