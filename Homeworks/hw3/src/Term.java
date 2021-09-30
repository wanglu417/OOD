/**
 * A class for every term in the polynomial.
 */
public class Term {
    private String variable;
    public int power;
    private int coe;
    public Term next;

    /**
     * Constructor for the Term.
     *
     * @param power This is the power of the term.
     * @param coe   This is the coefficient of the term.
     */
    public Term(int power, int coe, String variable, Term next) {
        this.variable = "x";
        this.power = power;
        this.coe = coe;
        this.next = next;
    }

    /**
     * Method to get the power of a term.
     *
     * @return Returns the power.
     * @throws IllegalArgumentException If the given number is negative or not integer, throws exception.
     */
    public int getPower() {
        return power;
    }

    /**
     * Method to get the coefficient of the term.
     *
     * @return Returns the coefficient.
     * @throws IllegalArgumentException If the given number is not integer, throws exception.
     */
    public int getCoe() {
            return coe;
    }

    /**
     * Method to set coefficient of the term.
     * @param val This is the val we want to give to the coefficient.
     */
    public void setCoe(int val) {
        coe = val;
    }

    /**
     * Method for the variable
     * @return always returns "x".
     */
    public String getVariable() {
        return "x";
    }

    /**
     * Method to represent the string.
     * @return returns the string.
     */
    @Override
    public String toString() {
        if (coe > 0) {
            return "+" + coe + "x"+"^" + power;
        } else {
            return coe + "x" + "^" + power;
        }
    }

    /**
     * Method to define two objects are equal
     * @param o This is another object
     * @return true if they have the same power and coefficient.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Term that = (Term) o;
        return power == that.power && coe == that.coe;
    }
}








