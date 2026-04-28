package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Lucky block that releases an item when hit from below.
 */
public class LuckyBlock extends GameObject {
    /**
     * Crates a new Block.
     *
     * @param gameView GameView to show the game object on.
     */
    public LuckyBlock(GameView gameView) {
        super(gameView);
        position.updateCoordinates(550, 600);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("lucky_block.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
