package game;

public class GameViewManager {
    private final GameView gameView;
    private Ufo ufo;
    private UfoShot ufoShot;

    public GameViewManager() {
        gameView = new GameView();
        ufo = new Ufo(gameView);
        ufoShot = new UfoShot(gameView);
        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            ufo.updatePosition();
            ufo.addToCanvas();
            ufoShot.addToCanvas();
            gameView.plotCanvas();
        }
    }
}