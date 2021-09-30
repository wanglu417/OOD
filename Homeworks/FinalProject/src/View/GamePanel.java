package View;

import Model.GameStateImpl;

import javax.swing.*;
import java.awt.*;

/**
 * A class to handle static painting
 */

public class GamePanel extends JPanel {

    private GameStateImpl gameStateImpl;


    /**
     * A constructor takes an object from the model.
     * @param gameStateImpl
     */
    public GamePanel(GameStateImpl gameStateImpl) {
        setOpaque(false);
        setBounds(15, 30, 200, 360);
        this.gameStateImpl = gameStateImpl;

    }

    /**
     * Paint the game panel.
     * @param g graphics g.
     */
    @Override
    public void paintComponent(Graphics g) {
        for(Point point : gameStateImpl.tetris.points){
            g.setColor(gameStateImpl.colors[GameStateImpl.currentTetris]);
            //Draw 20*20 blocks
            g.fill3DRect((point.x + gameStateImpl.x)*20, (point.y + gameStateImpl.y)*20, 20,20,false);
        }
        //bottom up
        for(int i =19; i>=2; i--){
            for(int j=0; j<10;j++){
                if(gameStateImpl.totalBlocks[j][i] != 0){
                    g.setColor(GameStateImpl.colors[GameStateImpl.totalBlocks[j][i] -1]);
                    g.fill3DRect((j)*20,(i-2)*20,20,20,false);
                }

            }
        }

    }

}
