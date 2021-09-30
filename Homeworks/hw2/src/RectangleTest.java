import org.junit.Before;
import org.junit.Test;

import java.awt.print.PrinterAbortException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle r1,r2,r3;


    @Test
    //The other rectangle is on the top of the rectangle and intersects with it
    public void overlap1() {
        r1 = new Rectangle(100,150,100,200);
        r2 = new Rectangle(100,200,50,100);
        assertTrue(r1.overlap(r2));
    }

    @Test
    //The two rectangles do not overlap
    public void overlap2() {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(400,600,30,40);
        assertFalse(r1.overlap(r2));
    }

    @Test
    //The two rectangles have exactly the same x,y,width,and height
    public void overlap3() {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(50,50,100,200);
        assertTrue(r1.overlap(r2));
    }

    @Test
    //The other rectangle is "inside" the rectangle and they have the same height but different width
    public void overlap4() {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(80,50,100,50);
        assertTrue(r1.overlap(r2));
    }

    @Test
    //The other rectangle is "inside" the rectangle and they have different x,y,width,height
    public void overlap5() {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(10,10,500,500);
        assertTrue(r1.overlap(r2));
    }

    @Test
    //Rectangles that touch each other are not considered to be overlapping
    public void overlap6() {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(250,50,100,100);
        assertFalse(r1.overlap(r2));
    }

    @Test(expected = NoSuchElementException.class)
    //When the two rectangles do not overlap,expect a NoSuchElement Exception
    public void TestNoSuchElementException () {
        r1 = new Rectangle(50,50,100,200);
        r2 = new Rectangle(400,600,30,40);
        Rectangle rInter = new Rectangle(30,30,20,20);
        assertEquals(r1.intersect(r2),rInter);
    }

    @Test
    public void intersect1 () {
        r1 = new Rectangle(100,150,100,200);
        r2 = new Rectangle(100,200,50,100);
        r3 = new Rectangle(100,200,50,100);
        assertEquals(r1.intersect(r2),r3);
    }

    @Test
    public void intersect2 () {
        r1 = new Rectangle(10, 10, 50, 70);
        r2 = new Rectangle(50, 45, 75, 60);
        r3 = new Rectangle(50, 45, 15, 30);
        assertEquals(r1.intersect(r2), r3);
    }

    @Test
    public void union () {
        r1 = new Rectangle(10, 10, 50, 70);
        r2 = new Rectangle(50, 45, 75, 60);
        r3 = new Rectangle(10, 10, 115, 95);
        assertEquals(r1.union(r2), r3);
    }

    @Test
    public void testToString () {
        r1 = new Rectangle(10, 10, 50, 70);
        assertEquals("x:10, y:10, h:50, w:70",r1.toString());
        }

    @Test
    public void equals() {
        r1 = new Rectangle(100,150,100,200);
        Rectangle other = new Rectangle(100,150,100,200);
        assertTrue(r1.equals(other));
    }
}