package game;

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
        speedInPixel = 3;
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
        this.position.right();
        this.rotation++;
    }

    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 0, true, Color.yellow);
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width - size, height, 0, true, Color.green);
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 5, false, Color.white);
        gameView.addTextToCanvas("Objekt 2", position.getX(), position.getY(),
                size, true, Color.blue, 0);
    }

}
