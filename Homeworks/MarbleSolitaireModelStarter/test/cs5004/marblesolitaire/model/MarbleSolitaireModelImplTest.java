package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the MarbleSolitaireImpl class.
 */
public class MarbleSolitaireModelImplTest {
    private MarbleSolitaireModelImpl game1 = new MarbleSolitaireModelImpl();
    private MarbleSolitaireModelImpl game2 = new MarbleSolitaireModelImpl(2, 3);


    @Test(expected = IllegalArgumentException.class)
    public void TestConstructor2() {
        MarbleSolitaireModel marble1 = new MarbleSolitaireModelImpl(2);
        MarbleSolitaireModel marble2 = new MarbleSolitaireModelImpl(4);
        MarbleSolitaireModel marble3 = new MarbleSolitaireModelImpl(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructor3() {
        MarbleSolitaireModel marble1 = new MarbleSolitaireModelImpl(0, 0);
        MarbleSolitaireModel marble2 = new MarbleSolitaireModelImpl(3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructor4() {
        MarbleSolitaireModel marble1 = new MarbleSolitaireModelImpl(4, 1, 1);
        MarbleSolitaireModel marble2 = new MarbleSolitaireModelImpl(5, 10, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestMove() {
        game1.move(0, 0, 1, 9);
        game1.move(1, 1, 3, 3);
        game1.move(4, 4, 0, 0);
    }

    @Test
    public void TestMove2() {
        game1.move(3, 1, 3, 3);
        assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O X X O O O O\n" + "O O O O O O O\n" + "    O O O\n" +
                "    O O O", game1.getGameState());
    }

    @Test
    public void TestGetGameState(){
        assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O X O O O\n" +
                "O O O O O O O\n" + "    O O O\n" + "    O O O", game1.getGameState());
        assertEquals("    O O O\n" +
                "    O O O\n" + "O O O X O O O\n" + "O O O O O O O\n" + "O O O O O O O\n" + "    O O O\n" +
                "    O O O", game2.getGameState());
        game1.move(3, 1, 3, 3);
        game1.move(5,2,3,2);
        game1.move(2,2,4,2);
        game1.move(3,4,3,2);
        game1.move(0,2,2,2);
        assertEquals("    X O O\n" + "    X O O\n"+ "O O O O O O O\n" + "O X O X X O O\n"+
                "O O O O O O O\n" + "    X O O\n" + "    O O O",game1.getGameState());
    }

    @Test
    public void TestIsGameOver(){
        game1.move(3, 1, 3, 3);
        game1.move(5,2,3,2);
        game1.move(2,2,4,2);
        game1.move(3,4,3,2);
        game1.move(0,2,2,2);
        assertFalse(game1.isGameOver());
        game1.move(1,3,3,3);
        game1.move(3,2,5,2);
        game1.move(6,2,4,2);
        game1.move(2,1,2,3);
        assertFalse(game1.isGameOver());
    }

    @Test
    public void TestGetScore(){
        game1.move(3, 1, 3, 3);
        game1.move(5,2,3,2);
        game1.move(2,2,4,2);
        game1.move(3,4,3,2);
        game1.move(0,2,2,2);
        assertEquals(27,game1.getScore());

    }

}
