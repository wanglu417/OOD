package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class MarbleSolitaireControllerImplTest {

    public void testHelper(String in, String out) throws IOException {
        Reader input = new StringReader(in);
        StringBuilder output = new StringBuilder();
        MarbleSolitaireController controller =
                new MarbleSolitaireControllerImpl(input, output);
        controller.playGame(new MarbleSolitaireModelImpl());
        assertEquals(out, output.toString());
    }


    @Test
    public void testPlayGame1() throws IOException {
        testHelper("q", "Quit game!\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O X O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Your score is: 32\n");
    }

    @Test
    public void testPlayGame2() throws IOException {
        testHelper("c q", "Please input a number.Quit game!\n"+
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O X O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Your score is: 32\n");
    }

}