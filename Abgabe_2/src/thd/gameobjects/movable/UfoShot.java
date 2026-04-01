package thd.gameobjects.movable;

import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

public class UfoShot {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;
    double width;
    double height;

    public UfoShot(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(1100, 650);
        speedInPixel = 2;
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public String toString() {
        return "Ufo: " + position;
    }


    public void updatePosition() {
        this.position.left(speedInPixel);
    }

    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 0, true, Color.YELLOW);
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width - size, height, 0, true, Color.GREEN);
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 5, false, Color.WHITE);
        gameView.addTextToCanvas("Objekt 2", position.getX(), position.getY(),
                size, true, Color.blue, 0);
    }

}
