package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;

/**
 * Mushroom power-up that can be collected by the player.
 */
public class Mushroom extends GameObject {
    /**
     * Creates a new Mushroom.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Mushroom(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(500, 680);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("mushroom.png", position.getX(), position.getY(), 2.0, rotation);
    }

}
