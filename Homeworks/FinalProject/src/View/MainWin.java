package View;

import Controller.OperationController;
import Model.GameStateImpl;

import javax.swing.*;
import java.awt.*;

/**
 * A class to manage the game panel and connect the window to the runtime game panel.
 */
public class MainWin extends JFrame {
    OperationController operationController;
    GameStateImpl gameStateImpl;
    Container mainPanel;
    GamePanel gamePanel ;
    ShowNext showNext;

    /**
     * A constructor that takes two object from Operation class and GamestateImpl class as its parameters.
     * @param operationController an object of Operation
     * @param gameStateImpl an object of gameStateImpl
     */
    public MainWin(OperationController operationController, GameStateImpl gameStateImpl){
        this.gameStateImpl= gameStateImpl;
        this.operationController = operationController;
        this.mainPanel = getLayeredPane();
        //Set tile of the whole panel
        this.setTitle("Java Tetris");
        //Set bounds
        this.setBounds(100,50,360,600);
        //Make the panel not resizable
        this.setResizable(false);
        //Absolute positioning
        this.setLayout(null);
        //Exit the game when close the panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.drawBackground();
        StaticPanel mypanel = new StaticPanel(operationController);
        mainPanel.add(mypanel);
        setGamePanel();
        //show next Tetris
        setShowNext();
        setFocusable(true);

    }

    /**gameModelImpl
     * A helper method for showing the next Tetris.
     */
    private void setShowNext() {
        showNext = new ShowNext(gameStateImpl);
        mainPanel.add(showNext);

    }

    /**
     * A method to draw the background of the whole panel.
     */
    public void drawBackground(){
        ImageIcon img = new ImageIcon("Graphics/bg.jpg");
        JLabel jl = new JLabel((img));
        jl.setBounds(0,0,360,600);
        getContentPane().add(jl);
    }

    /**
     * Setter method to set the game panel
     */
    public void setGamePanel(){
        //Connect with the current game state
        this.gamePanel = new GamePanel(gameStateImpl);
        //Add the current game panel to the main panel
        mainPanel.add(gamePanel);

    }

    /**
     * Getter method to get the runtime game panel.
     * @return an object of the GamePanel class.
     */
    public GamePanel getGamePanel(){
        return gamePanel;
    }

    /**
     * Getter method for ShowNext.
     * @return an object of the ShowNext.
     */
    public ShowNext getShowNext(){
        return showNext;
    }

    /**
     * Getter method to get the start button.
     * @return an object of the JButton based on the relative game state.
     */
    public JButton getStart(){
        return StaticPanel.start;
    }

    /**
     * Message alert when game is over.
     * @param s String message.
     */
    public void gameOverAlert(String s) {
        JOptionPane.showMessageDialog(this,s);
    }
}
