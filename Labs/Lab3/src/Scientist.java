//Scientist "is a" Person
public class Scientist extends Person{
    // fields or member variables
    //private String name;
    private String specialty;

    public Scientist(String name, int age, String SSN, String password, String specialty) {
        // call the Person' constructor to create the internal Person object
        super(name, age, SSN, password);
        this.validSpecialty(specialty);
        this.specialty = specialty;
}
    // Accessor method to get the specialty of scientist
    // Specialty is required and should not be an empty string
    public String validSpecialty(String specialty){
        if(this.specialty == " " || specialty.isEmpty()){
            throw new IllegalArgumentException("Fail to get the specialty. Please try again.");}
        System.out.println("The scientist's specialty is" + specialty);
        return this.specialty;
    }

    //Accessor method to get the specialty
    public String getSpecialty(){
        this.validSpecialty(specialty);
        return this.specialty;
    }

    // Mutator method to set the speciality
    public String setSpecialty(String specialty){
        return this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "The specialty of the scientist is " + getSpecialty();
    }
}
