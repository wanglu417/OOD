package View;

import Controller.OperationController;

import javax.swing.*;
import java.awt.*;

/**
 * A class to set up the static game panel.
 */
public class StaticPanel extends JPanel {
    //Eight button on the panel
    public static JButton start;
    public OperationController.ButtonControl left;
    public OperationController.ButtonControl right;
    public OperationController.ButtonControl down;
    public OperationController.ButtonControl rotate;
    public JButton settings;
    public JButton login;
    public JButton ranks;

    /**
     * A constructor takes in an object from the game controller.
     * @param operationController an object of the Operation class.
     */
    public StaticPanel(OperationController operationController){
        left = operationController.left;
        right = operationController.right;
        down = operationController.down;
        rotate = operationController.rotate;
        start = operationController.start;
        settings = operationController.settings;
        login = operationController.login;
        ranks = operationController.ranks;
        //Set up the location, size, color,and layout of the whole panel
        this.setBounds(0,0,360,600);
        this.setOpaque(false);
        this.setLayout(null);
        //Set up the location and size of the eight buttons.
        left.setBounds(233,255,45,45);
        right.setBounds(278,255,45,45);
        down.setBounds(233,300,45,45);
        rotate.setBounds(278,300,45,45);
        start.setBounds(233,360,90,53);
        settings.setBounds(230,480,48,48);
        login.setBounds(280,480,48,48);
        ranks.setBounds(11,375,220,200);
        this.add(left);
        this.add(right);
        this.add(down);
        this.add(rotate);
        this.add(start);
        this.add(settings);
        this.add(login);
        this.add(ranks);
        setStart();
    }

    /**
     * A helper method to set the start button.
     */
    private void setStart(){
        start.setContentAreaFilled(false);
        start.setFocusPainted(false);
        start.setFont(new Font("SansSerif",Font.PLAIN,20));
        start.setForeground(new Color(100, 100, 200));
        start.setFocusable(false);
    }

    /**
     *Paint the static panel.
     * @param g Graphics g.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //Set the color
        g.setColor(new Color(150,200,200,70));
        //draw the main window
        g.fillRect(15,30,200,360);
        //draw the ranking area
        g.fillRect(15,405,200,130);
        //draw area on the right
        g.fillRect(223,20,110,400);
        //reset the color
        g.setColor(new Color(2,2,2,30));
        //draw different sections
        g.fillRect(233,30,90,70);
        g.fillRect(233,105,90,140);
        g.fillRect(233,255,90,90);
        //reset the color
        g.setColor(Color.white);
        //draw the border
        ((Graphics2D)g).setStroke(new BasicStroke(3L));
        g.drawRect(13,28,204,364);
        g.drawRect(13,403,204,134);
        g.setFont(new Font("SansSerif",Font.PLAIN,23));
        g.setColor(new Color(100,100,200));
        g.drawString("Score",250,55);
        g.drawString("Next",253,135);
    }


}
