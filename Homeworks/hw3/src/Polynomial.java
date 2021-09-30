/**
 * Interface Polynomial that has the following methods
 */
public interface Polynomial {
    boolean addTerm(int coe, int power) throws IllegalArgumentException;
    void removeTerm(int power);
    int getDegree();
    int getCoefficient(int power);
    double evaluate(double num);
}
