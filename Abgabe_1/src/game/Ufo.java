package game;

import java.awt.*;

public class Ufo {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;

    public Ufo(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, (double) GameView.HEIGHT / 2);
        speedInPixel = 3;
        size = 30;
        rotation = 0;
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
        gameView.addTextToCanvas("Objekt 1", position.getX(), position.getY(),
                size, true, Color.YELLOW, rotation);
    }

}
