// Engineer "is a" Person
public class Engineer extends Person {
    private String favProgLang;

    public Engineer(String name, int age, String SSN, String password, String favProgLang) {
        // call the Person' constructor to create the internal Person object
        super(name, age, SSN, password);

        // initialize Engineer's own member variable
        this.favProgLang = favProgLang;
    }

    // Overloading the constructor method
    public Engineer(String name, int age, String SSN, String password) {
        super(name, age, SSN, password);

        // I just simply don't want to init favProgLang for now...
    }

    // We don't like toString() inherited from the parent Object class,
    // so *override* it with our own version
    @Override
    public String toString() {
        // string concatenation
        return "This is Engineer Name: " + getName() + " Age: " + getAge();
    }
}
