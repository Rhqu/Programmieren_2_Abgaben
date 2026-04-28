package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * Solid block that serves as a platform in the level.
 */
public class Block extends GameObject {

    /**
     * Crates a new Block.
     *
     * @param gameView GameView to show the game object on.
     */
    public Block(GameView gameView) {
        super(gameView);
        position.updateCoordinates(500, 600);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("brick.png", position.getX(), position.getY(), 2.5, rotation);
    }

}
