/**
 * Junit test for methods in the PolynomialImpl class
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialImplTest {

    @org.junit.Test
    public void testAddTerm() {
        PolynomialImpl poly1 = new PolynomialImpl("4x^3 +2x^2");
        assertTrue("4x^3 +2x^2 -3x^1", poly1.addTerm(-3, 1));
    }

    @org.junit.Test
    public void testGetDegree() {
        PolynomialImpl poly1 = new PolynomialImpl("5x^5 +3x^4 +2x^1 +1x^0");
        assertEquals(5, poly1.getDegree());
    }


    @org.junit.Test
    public void testGetCoefficient() {
        PolynomialImpl poly1 = new PolynomialImpl("3x^3 +2x^1 +1x^0");
        assertEquals(3, poly1.getCoefficient(3));
    }

    @org.junit.Test
    public void testEvaluate() {
        Term term1 = new Term(3, 2, "x", null);
        PolynomialImpl poly1 = new PolynomialImpl(term1);
        assertEquals(2, poly1.evaluate(1), 0.1);

    }

    @org.junit.Test
    public void testRemoveTerm() {
        PolynomialImpl poly1 = new PolynomialImpl("3x^2 +2x^1 +1x^0");
        poly1.removeTerm(0);
        PolynomialImpl poly2 = new PolynomialImpl("+3x^2 +2x^1");
        assertEquals(poly2,poly1);
        poly1.removeTerm(1);
        PolynomialImpl poly3 = new PolynomialImpl("+3x^2");
        assertEquals(poly3,poly1);

    }


    @org.junit.Test
    public void testAdd() {
        Term term1 = new Term(3, 2, "x", null);
        PolynomialImpl poly1 = new PolynomialImpl(term1);
        Term term2 = new Term(2, 1, "x", null);
        PolynomialImpl poly2 = new PolynomialImpl(term2);
        PolynomialImpl poly3 = poly1.add(poly2);
        PolynomialImpl poly_ref = new PolynomialImpl("2x^3 +1x^2");
        assertEquals(poly3,poly_ref);
    }

    @org.junit.Test
    public void testToString() {
        Term term2 = new Term(3,1,"x",null);
        PolynomialImpl poly2 = new PolynomialImpl(term2);
        assertEquals("+1x^3 ",poly2.toString());
    }
}
