package Controller;

import Model.GameStateImpl;
import View.MainWin;

/**
 * A class to control the data flow into model object and update the view whenever data changes
 */
public class GameController extends Thread {
    private final GameStateImpl gameStateImpl;
    private final MainWin mainWin;

    /**
     * A constructor takes in an object from the game model and game view as its two parameters
     * @param gameStateImpl an object of GameStateImpl class.
     * @param mainWin an object of MainWin class.
     */
    public GameController(GameStateImpl gameStateImpl, MainWin mainWin) {
        this.gameStateImpl= gameStateImpl;
        this.mainWin = mainWin;
    }

    /**
     * A method to represent different game window under different game state.
     */
    @Override
    public void run() {
        while (true) {
            try {
                //Only when the gameState == 1, the Tetris will automatically dropping down.
                if (GameStateImpl.state == 1) {
                    //when the player clicks down button
                    if (gameStateImpl.move(false, 1)) {
                        //repaint the window and show the next block
                        mainWin.getShowNext().repaint();
                    }
                    mainWin.getGamePanel().repaint();
                    sleep(300);
                //When the game is over
                } else if (GameStateImpl.state ==3){
                    gameStateImpl.initialize();
                    mainWin.gameOverAlert("Game is over. Your score is" + gameStateImpl.getScore());
                    mainWin.getStart().setText(gameStateImpl.stateText[GameStateImpl.state]);
                    GameStateImpl.state = 10;
                }
                //Otherwise, do nothing.Use "sleep" to prevent endless loop.
                else{
                    sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
