import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//A JUnit test class for the Scientist class
public class ScientistTest {
    private Scientist CScientist;

    //Create a new object computer scientist

    @Before
    public void Setup(){
        CScientist = new Scientist("Lucy",30,"1234","123456","Machine Learning");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validSpecialty() throws IllegalArgumentException{
        Scientist Lucy = new Scientist("Lucy",30,"1234","123456","");
        Lucy.getSpecialty();
    }

    //Test a method inherited from Person without change still works correctly.
    @Test
    public void getSSN() {
        assertEquals("1234",CScientist.getSSN());
    }

    @Test
    public void getSpeciality() {
        CScientist.getSpecialty();
        assertEquals("Machine Learning", CScientist.getSpecialty());
    }

    @Test
    public void setSpecialty() {
        Scientist John = new Scientist("John",44,"5678", "5678","Web Development");
        String specialty = "Web Development";
        assertEquals("Web Development", John.setSpecialty(specialty));
    }

    @Test
    public void testToString() {
        CScientist.toString();
        assertEquals("The specialty of the scientist is Machine Learning", CScientist.toString());

    }
}





