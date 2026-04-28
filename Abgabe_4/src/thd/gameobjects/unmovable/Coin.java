package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Coin item that can be collected by the player.
 */
public class Coin extends GameObject {
    /**
     * Crates a new Mushroom.
     *
     * @param gameView GameView to show the game object on.
     */
    public Coin(GameView gameView) {
        super(gameView);
        position.updateCoordinates(510, 555);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("coin.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
