import Controller.GameController;
import Controller.OperationController;
import Model.GameStateImpl;
import View.MainWin;

/**
 * Main class for the Java Tetris project
 * @author Lu Wang
 * @version V1
 * @date 2021/8/20
 */
public class Main {
    public static void main(String[] args) {
        OperationController operationController = new OperationController();
        GameStateImpl gameStateImpl = new GameStateImpl();
        MainWin mainwin = new MainWin(operationController, gameStateImpl);
        operationController.setWin(mainwin);
        operationController.setData(gameStateImpl);
        new GameController(gameStateImpl,mainwin);
        new GameController(gameStateImpl,mainwin).start();
        mainwin.setVisible(true);
    }
}