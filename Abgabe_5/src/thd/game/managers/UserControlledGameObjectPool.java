package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.Goomba;
import thd.gameobjects.movable.Koopa;
import thd.gameobjects.movable.Mario;
import thd.gameobjects.movable.Star;
import thd.gameobjects.unmovable.*;

import java.awt.*;
import java.awt.event.KeyEvent;

class UserControlledGameObjectPool {
    protected final GameView gameView;
    protected Mario mario;
    protected Star star;
    protected Block block;
    protected LuckyBlock luckyBlock;
    protected Mushroom mushroom;
    protected Koopa koopa;
    protected Goomba goomba;
    protected Coin coin;
    protected UsedBrick usedBrick;

    UserControlledGameObjectPool(GameView gameView) {
        this.gameView = gameView;
    }

    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            mario.left();
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            mario.right();
        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            mario.jump();
        } else if (keyCode == KeyEvent.VK_SPACE) {
            mario.shoot();

        }
    }

    protected void processFrame() {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            processKeyCode(keyCode);
        }
    }
}
