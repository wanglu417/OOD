import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector3DTest {
    private Vector3D v1;

    //Create an objects v1
    @Before
    public void myTestSetup() {
        v1 = new Vector3D(5.1, 7.1, 9.2);
    }

    ///Tests for different methods
    @Test
    public void getX() {
        assertEquals(5.1, v1.getX(),0.1);
    }

    @Test
    public void getY() {
        assertEquals(7.1, v1.getY(),0.1);
    }

    @Test
    public void getZ() {
        assertEquals(9.2, v1.getZ(),0.1);
    }


    @Test
    public void getMagnitude() {
        assertEquals(12.69, v1.getMagnitude(),0.1);
    }

    @Test
    public void testToString() {
        assertEquals("(5.10,7.10,9.20)", v1.toString());
    }

    @Test
    public void normalize() throws Exception{
        Vector3D norm = v1.normalize();
        assertEquals(0.4018614331447463,norm.getX(),0.1);
    }

    @Test
    public void add() {
        Vector3D v2 = new Vector3D(6.67, 3.45, 9.23);
        assertEquals(11.77,v1.add(v2).getX(),0.1);
    }

    @Test
    public void multiply() {
        int n = 10;
        assertEquals(51.0,v1.multiply(n).getX(),0.1);
    }

    @Test
    public void dotProduct() {
        Vector3D v2 = new Vector3D(6.67, 3.45, 9.23);
        assertEquals(143.428,v1.dotProduct(v2),0.1);
    }

    @Test
    public void angleBetween() throws Exception{
        Vector3D v2 = new Vector3D(6.67, 3.45, 9.23);
        double angle = v1.angleBetween(v2);
        assertEquals(18.23,angle,0.1);

    }
}

