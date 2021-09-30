

/**
 * Concrete class PolynomialImpl implements Polynomial
 */
public class PolynomialImpl implements Polynomial {
    public Term head;

    /**
     * A constructor with no parameters that creates a polynomial with no terms.
     */
    public PolynomialImpl() {
        head = null;
    }

    /**
     * Create a linked list with head(Term) n.
     *
     * @param n This is the first term of the polynomial.
     */
    public PolynomialImpl(Term n) {
        head = n;
    }

    public PolynomialImpl(String n) {
        String[] tokens = n.split(" ");
        Term dummy = new Term(-1, -1, "x", null);
        Term current = dummy;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            int x_position = token.indexOf("x");
            String coe_str = token.substring(0, x_position);
            String power_str = token.substring(x_position + 2);
            int coe_num = Integer.parseInt(coe_str);
            int power_num = Integer.parseInt(power_str);
            current.next = new Term(power_num, coe_num, "x", null);
            current = current.next;
        }
        head = dummy.next;
    }


    /**
     * A method addTerm that takes a coefficient and a power (both integral numbers)
     * and adds the resulting term to the polynomial.
     *
     * @param coe   This is the coefficient of the added term.
     * @param power This is the power of the added term.
     * @return Returns the added result. ****merge and sort
     */
    @Override
    public boolean addTerm(int coe, int power) {
        if (power >= 0) {
            if (head == null) {
                head = new Term(power, coe, "x", null);
                return true;
            }
            Term traversePtr = head;
            Term traversePtr1 = head;
            if (head.getPower() < power) {
                head = new Term(power, coe, "x", null);
                head.next = traversePtr;
                return true;
            } else if (head.getPower() == power) {
                head.setCoe(traversePtr.getCoe() + coe);
                return true;
            } else {
                while (traversePtr != null) {
                    if (traversePtr.getPower() < power) {
                        traversePtr1.next = new Term(power, coe, "x", null);
                        traversePtr1.next.next = traversePtr;
                        return true;
                    } else if (traversePtr.getPower() == power) {
                        traversePtr.setCoe(traversePtr.getCoe() + coe);
                        return true;
                    } else {
                        traversePtr1 = traversePtr;
                        traversePtr = traversePtr.next;
                    }
                }
                traversePtr1.next = new Term(power, coe, "x", null);
                return true;
            }
        } else {
            throw new IllegalArgumentException("Invalid input power.");
        }
    }

    /**
     * A method getDegree that returns the degree of this polynomial.
     *
     * @return Returns the degree.
     */
    @Override
    public int getDegree() {
        Term traversePtr = head;
        Term dummy = head;
        while (traversePtr != null) {
            if (traversePtr.next != null && traversePtr.next.getPower() > traversePtr.power) {
                dummy = traversePtr.next;
            }
            traversePtr = traversePtr.next;
        }
        return dummy.getPower();
    }


    /**
     * Method that removes a term with specified power.
     *
     * @param power This is the power of a term that we want to move.
     */

    @Override
    public void removeTerm(int power){
        Term dummy = new Term(-1,-1,"x",null);
        //Anchor the previous head and make prev pointing to the current, which is head before entering the loop.
        dummy.next = head;
        Term prev = dummy;
        Term current = head;
        while(current != null){
            if(current.power == power){
                //skip the term we want to remove by making the prev.next point to current.next.
                prev.next = current.next;
                break;
            }
            else{
                prev = prev.next;
                current = current.next;
            }
        }
        //In case the head will be removed, we use dummy to anchor the new head.
        head = dummy.next;
    }


    /**
     * A method that takes a power and returns the coefficient for the term with that power.
     *
     * @param power The power of the term that we want to get the coefficient.
     * @return Returns the coefficient.
     */
    @Override
    public int getCoefficient(int power) {
        Term traversePtr = head;
        while (traversePtr != null) {
            if (traversePtr.power == power) {
                return traversePtr.getCoe();
            }
            traversePtr = traversePtr.next;
        }
        return traversePtr.getCoe();
    }

    /**
     * A method that takes a double-precision decimal number and returns a double-precision result.
     *
     * @param num The value of x;
     * @return Returns the value of the polynomial with given value num.
     */
    @Override
    public double evaluate(double num) {
        double result = 0.0;
        Term traversePtr = head;
        while (traversePtr != null) {
            result = result + traversePtr.getCoe() * Math.pow(num, traversePtr.getPower());
            traversePtr = traversePtr.next;
        }
        return result;
    }

    /**
     * A method add that takes another object and returns the obtained by adding the two polynomials.
     *
     * @param other This is another polynomialImpl object.
     * @return Returns the added result.
     */
    public PolynomialImpl add(PolynomialImpl other) {
        if (other instanceof Polynomial) {
            Term traversePtr1 = head;
            Term traversePtr2 = other.head;
            Term dummy = new Term(-1, -1, "x", null);
            Term traversePtr3 = dummy;
            while (traversePtr1 != null && traversePtr2 != null) {
                if (traversePtr1.getPower() == traversePtr2.getPower()) {
                    int val = traversePtr1.getCoe() + traversePtr2.getCoe();
                    traversePtr3.next = new Term(traversePtr1.getPower(), val, "x", null);
                    traversePtr1 = traversePtr1.next;
                    traversePtr2 = traversePtr2.next;
                    traversePtr3 = traversePtr3.next;
                } else if (traversePtr1.getPower() > traversePtr2.getPower()) {
                    traversePtr3.next = new Term(traversePtr1.getPower(), traversePtr1.getCoe(), "x", null);
                    traversePtr1 = traversePtr1.next;
                    traversePtr3 = traversePtr3.next;
                } else {
                    traversePtr3.next = new Term(traversePtr2.getPower(), traversePtr2.getCoe(), "x", null);
                    traversePtr2 = traversePtr2.next;
                    traversePtr3 = traversePtr3.next;
                }
            }
            while (traversePtr1 != null) {
                traversePtr3.next = new Term(traversePtr1.getPower(), traversePtr1.getCoe(), "x", null);
                traversePtr1 = traversePtr1.next;
                traversePtr3 = traversePtr3.next;
            }
            while (traversePtr2 != null) {
                traversePtr3.next = new Term(traversePtr2.getPower(), traversePtr2.getCoe(), "x", null);
                traversePtr2 = traversePtr2.next;
                traversePtr3 = traversePtr3.next;
            }
            PolynomialImpl res = new PolynomialImpl(dummy.next);
            return res;
        } else {
            throw new IllegalArgumentException("Other is not in the same concrete class");
        }

    }

    /**
     * A method to represent the string output.
     *
     * @return Returns the string representation.
     */
    @Override
    public String toString() {
        String res = "";
        Term traversePtr = head;
        while (traversePtr != null) {
            res = res + traversePtr.toString() + " ";
            traversePtr = traversePtr.next;
        }
        return res;
    }

    /**
     * A method to compare two objects.
     *
     * @param o other object.
     * @return true.
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PolynomialImpl that = (PolynomialImpl) o;
        Term traversePtr1 = head;
        Term traversePtr2 = that.head;
        while (traversePtr1 != null && traversePtr2 != null) {
            if (!traversePtr1.equals(traversePtr2)) {
                return false;
            } else {
                traversePtr1 = traversePtr1.next;
                traversePtr2 = traversePtr2.next;
            }
        }
        if (traversePtr1 != null || traversePtr2 != null) {
            return false;
        }
        return true;
    }

}



