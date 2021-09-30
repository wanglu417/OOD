package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class to draw the navigation button on the screen
 */

public abstract class Button extends JButton {

    public Button(ImageIcon img) {
        //set the background transparent
        this.setContentAreaFilled(false);
        //set the image
        this.setIcon(img);
        //remove the border
        this.setBorder(null);
        this.setFocusable(false);
        //add action listener
        addActionListener(new ActionListener() {


            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();

            }
        });
    }

    /**
     * An abstract class handling click.
     */
    public abstract void onClick();
}
