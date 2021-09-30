import java.util.NoSuchElementException;

/**
 * This class represents a rectangle.
 */
public class Rectangle {
    private int x;
    private int y;
    private int height;
    private int width;

    /**
     * Constructs a rectangle object with the given locations of its lower-left
     * corner and dimensions
     *
     * @param x      x coordinates of its lower left corner
     * @param y      y coordinates of its lower left corner
     * @param height height of this rectangle
     * @param width  width of this rectangle
     */
    public Rectangle(int x, int y, int height, int width) {
        //The rectangle should have a positive height and a positive width
        //Otherwise it's not allowed
        if (height > 0) {
            this.height = height;
            if (width > 0)
                this.width = width;
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Method:overlap(Rectangle other)
     *
     * @param other the other rectangle
     * @return returns true if the two rectangles overlap,otherwise return false
     */
    public boolean overlap(Rectangle other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }

    /**
     * Method: intersect
     *
     * @param other rectangle
     * @return Returns a Rectangle object with x,y,width,height, which represents the intersect part of the two rectangles
     * If there is no overlap, throw a NoSuchElementException
     */
    public Rectangle intersect(Rectangle other) {
        if (!this.overlap(other)) {
            throw new NoSuchElementException("There is no intersection");
        } else {
            //Initiate a rectangle
            Rectangle interRec = null;
            int xInter = Math.max(x, other.x);
            int yInter = Math.max(y, other.y);
            int wInter = Math.min(x + width, other.x + other.width) - Math.max(x, other.x);
            int hInter = Math.min(y + height, other.y + other.height) - Math.max(y, other.y);
            interRec = new Rectangle(xInter, yInter, hInter, wInter);
            return interRec;
        }
    }

    /**
     * Method : union
     *
     * @param other rectangle
     * @return Returns a rectangle that represents the union of the two given rectangles.
     */
    public Rectangle union(Rectangle other) {
        //Create a Rectangle object null
        Rectangle rec = null;
        //Find coordinates of the union
        int xMin = Math.min(this.x, other.x);
        int yMin = Math.min(this.y, other.y);
        int xMax = Math.max((this.x + this.height), (other.x + other.height));
        int yMax = Math.max((this.y + this.width), (other.y + other.width));
        int UnionHeight = xMax - xMin;
        int UnionWidth = yMax - yMin;
        rec = new Rectangle(xMin, yMin, UnionHeight, UnionWidth);
        return rec;
        }

    /**
     * Method: toString
     *
     * @return Returns a string formatted exactly as: “x:2, y:3, w:4, h:5”
     */
    @Override
    public String toString() {
        return "x:" + x + ", y:" + y + ", h:" + height + ", w:" + width;
    }

    /**
     * Method This method compares a given string to the specified object;
     * @param obj Rectangle object other
     * @return Returns true when two are equal
     */
    @Override
    public boolean equals(Object obj) {
        Rectangle other = (Rectangle)obj;
        boolean b = !(x != other.x || y != other.y || width != other.width ||height != other.height);
        return  b;
    }
    }




