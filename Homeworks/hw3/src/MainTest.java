public class MainTest {
    public static void main(String[] args) {
        Term term = new Term(1,1,"x",null);
        PolynomialImpl poly = new PolynomialImpl(term);
        System.out.println(poly);
        poly.addTerm(3,3);
        System.out.println(poly);
        poly.addTerm(2,2);
        System.out.println(poly);
        poly.addTerm(4,4);
        System.out.println(poly);
        poly.removeTerm(2);
        System.out.println(poly);
        poly.addTerm(4,4);
        System.out.println(poly);
        poly.addTerm(1,1);
        System.out.println(poly);
        poly.addTerm(2,2);
        System.out.println(poly);
        poly.addTerm(1,0);
        System.out.println(poly);
        System.out.println(poly.add(poly));
        System.out.println((poly.evaluate(2)));
        poly.removeTerm(2);
        System.out.println((poly));
        Term term1 = new Term(3, 2, "x", null);
        PolynomialImpl poly1 = new PolynomialImpl(term1);
        Term term2 = new Term(3, 1, "x", null);
        PolynomialImpl poly2 = new PolynomialImpl(term2);
        Term term3 = new Term(3, 3, "x", null);
        PolynomialImpl poly3 = new PolynomialImpl(term3);
        PolynomialImpl poly4 = new PolynomialImpl("2x^2 +3x^1 -2x^0");
        System.out.println(poly4);
    }
}
