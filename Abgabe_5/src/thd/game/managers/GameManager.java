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

class GameManager extends GamePlayManager {

    /**
     * Creates a new GameManager with the given GameView.
     *
     * @param gameView the GameView used to display game objects.
     */

    public GameManager(GameView gameView) {
        super(gameView);
        mario = new Mario(gameView, this);
        star = new Star(gameView, this);
        block = new Block(gameView, this);
        luckyBlock = new LuckyBlock(gameView, this);
        usedBrick = new UsedBrick(gameView, this);
        goomba = new Goomba(gameView, this);
        mushroom = new Mushroom(gameView, this);
        koopa = new Koopa(gameView, this);
        coin = new Coin(gameView, this);
        spawnGameObject(mario);
        spawnGameObject(star);
        spawnGameObject(block);
        spawnGameObject(luckyBlock);
        spawnGameObject(usedBrick);
        spawnGameObject(goomba);
        spawnGameObject(mushroom);
        spawnGameObject(coin);
        spawnGameObject(koopa);
    }

    private void gameManagement() {
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameManagement();
    }
}
