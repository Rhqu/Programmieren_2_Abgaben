package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.game.managers.GamePlayManager;

/**
 * Lucky block that releases an item when hit from below.
 */
public class LuckyBlock extends GameObject {
    /**
     * Creates a new LuckyBlock.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public LuckyBlock(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
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
