package View;
import Model.GameStateImpl;

import javax.swing.*;
import java.awt.*;

/**
 * A class to handle the show next function
 */
public class ShowNext extends JPanel {
    //Tetris in the square shape and long strip shape have deviation when appears in the "Next" area.
    int[] deviation = new int[]{0,-10,0,0,-10,0,0};

    private GameStateImpl gameStateImpl;

    /**
     * A constructor takes in an object of the GameStateImpl as its parameter.
     * @param gameStateImpl an object of the GameStateImpl.
     */
    public ShowNext(GameStateImpl gameStateImpl) {
        this.setOpaque(false);
        this.setBounds(233, 30, 90, 215);
        this.gameStateImpl= gameStateImpl;

    }

    /**
     *Paint the "Next" area.
     * @param g Graphics g.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setFont(new Font("SansSerif",Font.PLAIN,23));
        g.drawString(gameStateImpl.getScore(),25,60);
        for(Point point : gameStateImpl.TETRIS[gameStateImpl.nextTetris].points){
            g.setColor(gameStateImpl.colors[gameStateImpl.nextTetris]);
            g.fill3DRect((point.x)*20 + 35 + deviation[gameStateImpl.nextTetris], (point.y )*20 + 140, 20,20,false);
        }


    }

}
