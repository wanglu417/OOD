package Model;

import java.awt.*;

/**
 * A class to represent every single Tetris block.
 */

public class Tetris {
    //Coordinates of center point
    public Point[] points;
    //Initialize the location
    int InitX = 4;
    int InitY = 1;
    //Location after rotation
    int rotateX;
    int rotateY;

    /**
     * First constructor takes two coordinates of the four blocks as its parameters(Each Tetris has 4 blocks)
     * @param x array of coordinates x.
     * @param y array of coordinates y.
     */
    public Tetris(int[] x, int[] y) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(x[i], y[i]);
        }
    }

    /**
     * Second constructor takes another Tetris as its parameter for rotation purposes.
     * @param tetris another tetris
     */
    public Tetris(Tetris tetris) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(( tetris.points[i].x ), ( tetris.points[i].y ));
        }
        rotateX = InitX;
        rotateY = InitY;
    }

}


