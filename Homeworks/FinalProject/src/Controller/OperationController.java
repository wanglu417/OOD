package Controller;

import Model.GameStateImpl;
import View.Button;
import View.MainWin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is to control user’s moving and rotating blocks on key press or button click
 * and connects the game data with the main window
 */
public class OperationController {
    private MainWin mainWin;
    private GameStateImpl gameStateImpl;
    public ButtonControl left;
    public ButtonControl right;
    public ButtonControl down;
    public ButtonControl rotate;
    public JButton start;
    public Button settings;
    public Button login;
    public Button ranks;

    /**
     * A constructor takes no parameter and initializes game buttons. Everytime a button is clicked, repaint the game
     * panel based on the game state respectively.
     */
    public OperationController() {
        left = new ButtonControl(new ImageIcon("Graphics/left.jpg")) {
            @Override
            public void continueClick() {
                gameStateImpl.move(true, -1);
                mainWin.getGamePanel().repaint();
            }
        };

        right = new ButtonControl(new ImageIcon("Graphics/right.jpg")) {
            @Override
            public void continueClick() {
                gameStateImpl.move(true, 1);
                mainWin.getGamePanel().repaint();
            }
        };

        down = new ButtonControl(new ImageIcon("Graphics/down.jpg")) {
            @Override
            public void continueClick() {
                //If the game is running, show next Tetris.
                if (gameStateImpl.move(false, 1)) {
                    mainWin.getShowNext().repaint();
                }
                mainWin.getGamePanel().repaint();
            }
        };

        rotate = new ButtonControl(new ImageIcon("Graphics/rotate.jpg")) {
            @Override
            public void continueClick() {
                gameStateImpl.rotate();
                mainWin.getGamePanel().repaint();
            }
        };

        start = new JButton("START");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //If the game is running, we can only switch to "PAUSE" state
                if (GameStateImpl.state == 1) {
                    GameStateImpl.state = 2;
                }
                //In other cases, we can only switch it to 1.
                else {
                    GameStateImpl.state = 1;
                }
                //show different text reminder under different states.
                start.setText(gameStateImpl.stateText[GameStateImpl.state]);
            }
        });

        settings = new Button(new ImageIcon("Graphics/settings.png")) {
            @Override
            public void onClick() {

            }
        };

        ranks = new Button(new ImageIcon("Graphics/ranks.png")) {
            @Override
            public void onClick() {

            }
        };


        login = new Button(new ImageIcon("Graphics/login.png")) {
            @Override
            public void onClick() {

            }
        };

    }

    /**
     * A setter method to get the main window connected with keyboard action.
     * @param mainwin an object of the MainWin class.
     */
    public void setWin(MainWin mainwin) {
        this.mainWin = mainwin;
        this.mainWin.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            //Add keyboard control
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    down.onClick();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left.onClick();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right.onClick();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    rotate.onClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    /**
     * Method to disable the navigation button when the game is paused.
     */
    public abstract class ButtonControl extends Button {
        public ButtonControl(ImageIcon img){
            super(img);
        }
        @Override
        public void onClick(){
            //If the game is running, activate the direction button.Otherwise,prohibit it.
            if(GameStateImpl.state == 1){
                continueClick();
            }
        }

        protected abstract void continueClick();


    }

    /**
     * Setter method to connect to the game model.
     * @param gameStateImpl an object of the GameStateImpl class.
     */
    public void setData(GameStateImpl gameStateImpl) {
        this.gameStateImpl= gameStateImpl; }
}
