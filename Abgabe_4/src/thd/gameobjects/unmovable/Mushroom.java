package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Mushroom power-up that can be collected by the player.
 */
public class Mushroom extends GameObject {
    /**
     * Crates a new Mushroom.
     *
     * @param gameView GameView to show the game object on.
     */
    public Mushroom(GameView gameView) {
        super(gameView);
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
