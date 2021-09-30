import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetRockTest {
    private PetRock rocky;

    //Create a new object Rocky
    @Before
    public void myTestSetUp()  {
        rocky = new PetRock("Rocky", 62.0);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Rocky",rocky.getName());
    }


    @Test
    public void compareMass() throws Exception{
        assertNotSame(62.0,rocky.getMass());

    }

    @Test
    public void testUnhappyToStart() throws Exception {
        assertFalse(rocky.isHappy());
    }
    @Test
    public void testHappyAfterPlay() throws Exception {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Ignore("Exception throwing not yet defined")
    @Test(expected = IllegalStateException.class)
    public void testNameFail() throws Exception{
        rocky.getHappyMessage();
    }

    @Test
    public void testHappyMessage() throws Exception{
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!",msg);
    }

    @Test (expected = IllegalStateException.class)
    public void testEmptyNameFail() throws Exception{
        new PetRock("",62.0);
    }

    @Test
    public void testFavNum () {
        assertEquals(42,rocky.getFavNumber());
    }

    @Test
    public void testToString() {
        String msg2 = rocky.toString();
        assertEquals("I am a Happy PetRock!",msg2);

    }
}