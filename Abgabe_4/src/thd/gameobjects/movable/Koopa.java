package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Koopa enemy that moves along a quadratic path.
 */
public class Koopa extends GameObject {

    /**
     * Crates a new Koopa.
     *
     * @param gameView GameView to show the game object on.
     */
    public Koopa(GameView gameView) {
        super(gameView);
        position.updateCoordinates(200, 650);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("koopa_resized.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
