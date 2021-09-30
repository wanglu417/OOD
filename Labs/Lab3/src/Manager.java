// Manager also "is a" Person
public class Manager extends Person {
    private int numSubordinates;

    public Manager(String name, int age, String SSN, String passwd, int numSubordinates) {
        // use "super" to invoke the constructor of the Person class,
        // to create an internal Person object
        super(name, age, SSN, passwd);

        this.numSubordinates = numSubordinates;
    }

    @Override
    public String toString() {
        return "This is Manage, Name: " + getName() + " Age: " + getAge();
    }

    public int getNumSubordinates() {
        return this.numSubordinates;
    }

    //public String printName() {
    //  System.out.println(this.name);
    //}
}
