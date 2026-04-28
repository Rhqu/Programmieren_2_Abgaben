package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;
import thd.gameobjects.movable.Goomba;
import thd.gameobjects.movable.Koopa;
import thd.gameobjects.movable.Mario;
import thd.gameobjects.movable.Star;
import thd.gameobjects.unmovable.*;

/**
 * Manages the game objects and game logic.
 */

class GameManager extends UserControlledGameObjectPool {
    private final GameObjectManager gameObjectManager;

    /**
     * Creates a new GameManager with the given GameView.
     *
     * @param gameView the GameView used to display game objects.
     */

    public GameManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
        mario = new Mario(gameView);
        star = new Star(gameView);
        block = new Block(gameView);
        luckyBlock = new LuckyBlock(gameView);
        usedBrick = new UsedBrick(gameView);
        goomba = new Goomba(gameView);
        mushroom = new Mushroom(gameView);
        koopa = new Koopa(gameView);
        coin = new Coin(gameView);
        gameObjectManager.add(mario);
        gameObjectManager.add(star);
        gameObjectManager.add(block);
        gameObjectManager.add(luckyBlock);
        gameObjectManager.add(usedBrick);
        gameObjectManager.add(goomba);
        gameObjectManager.add(mushroom);
        gameObjectManager.add(coin);
        gameObjectManager.add(koopa);
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameObjectManager.processFrame();
    }
}
