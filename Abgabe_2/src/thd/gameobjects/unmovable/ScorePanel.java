package thd.gameobjects.unmoveable;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

public class ScorePanel {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;
    double width;
    double height;

    public ScorePanel(GameView gameView) {
        this.gameView = gameView;
        double width = 150;
        double height = 33;
        this.position = new Position(GameView.WIDTH - width + 50, 2 * height);
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
        gameView.addTextToCanvas("Objekt 3", position.getX(), position.getY(),
                size, true, Color.white, 90);
    }

}
