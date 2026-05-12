package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;

/**
 * Coin item that can be collected by the player.
 */
public class Coin extends GameObject {
    /**
     * Creates a new Coin.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Coin(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
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
