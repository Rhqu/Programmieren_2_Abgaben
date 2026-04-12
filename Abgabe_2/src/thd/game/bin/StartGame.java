package thd.game.bin;

import thd.game.managers.GameViewManager;

/**
 * Entry point for starting the game.
 */

public class StartGame {
    /**
     * The main method to start the program.
     *
     * @param args command line arguments are not used.
     */

    public static void main(String[] args) {
        new GameViewManager();
    }
}
