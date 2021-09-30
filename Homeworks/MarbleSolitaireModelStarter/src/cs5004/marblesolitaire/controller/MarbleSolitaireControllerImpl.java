package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Implements MarbleSolitaireController.
 * Readable rd is to read inputs.
 * Appendable ap is to append outputs.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
    private Readable rd;
    private Appendable ap;

    /**
     * Constructor for MarbleSolitaireController Impl.
     * @param rd readable for input
     * @param ap appendable for output
     * @throws IllegalArgumentException if readable or appendable is null
     */
    public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
        if (rd == null || ap == null) {
            throw new IllegalArgumentException("Readable or appendable is invalid");
        }
        this.rd = rd;
        this.ap = ap;
    }

    /**
     * Plays the game using the model.
     * -Throws IllegalArgumentException if the given model is null.
     * -Throws IllegalStateException if unable to read or append inputs.
     *
     * @param model is the provided model
     * @throws IllegalStateException if model is null or unable to read or append
     *
     */
    @Override
    public void playGame(MarbleSolitaireModel model) throws IllegalStateException {
        if (model == null) {
            throw new IllegalArgumentException("Model is invalid. Please try again.");
        }
        boolean quit = false;
        Scanner s = new Scanner(rd);
        while (!quit && !model.isGameOver()) {
            ArrayList<Integer> moves = new ArrayList<>(4);
            String userInputs;
            while ((moves.size() < 4) && !quit) {
                try {
                    userInputs = s.next();
                }
                catch (NoSuchElementException e) {
                    throw new IllegalStateException("Inputs out of range.");
                }

                if (userInputs.equalsIgnoreCase("q")) {
                    this.quitHelper(model);
                    quit = true;
                } else {
                    this.userInput(userInputs, moves);
                }
            }
            if (!quit) {
                this.move(moves, model);
            }
        }
        if (!quit) {
            this.gameOver(model);
        }
        s.close();
    }

    /**
     * A helper class to append string.
     * Catches IOException and throws IllegalStateException if unable to append.
     *
     * @param s string to append
     * @throws IllegalStateException if unable to append
     */
    private void appendString(String s) throws IllegalStateException {
        try {
            this.ap.append(s);
        }
        catch (IOException e) {
            throw new IllegalStateException("Unable to append");
        }
    }

    /**
     * A helper class to handle the game state if user quit the game.
     * @param model the game model
     */
    private void quitHelper(MarbleSolitaireModel model) {
        this.appendString("Quit game!\n");
        this.appendString(model.getGameState() + "\n");
        this.appendString("Your score is: " + model.getScore() + "\n");
    }

    /**
     * Class to add the user input.
     * @param input the player's input
     * @param moves is the list of coordinates for moves
     */
    private void userInput(String input, ArrayList<Integer> moves) {
        try {
            int inputNum = Integer.parseInt(input) - 1;
            if (inputNum < 0) {
                this.appendString("Please enter a positive number.");
            }
            else {
                moves.add(inputNum);
            }
        } catch (NumberFormatException e) {
            this.appendString("Please input a number.");
        }
    }

    /**
     * Make move.  If unable to move, ask the user to try again.
     * @param moves the list of coordinates for the move.
     * @param model the given model.
     */
    private void move(ArrayList<Integer> moves, MarbleSolitaireModel model) {
        try {
            model.move(moves.get(0), moves.get(1), moves.get(2), moves.get(3));
        } catch (IllegalArgumentException e) {
            this.appendString("Invalid move. Please try again.");
        }
        this.appendString(model.getGameState() + "\n");
        this.appendString("Score: " + model.getScore() + "\n");
    }

    /**
     * Handle "Game over" state.
     * @param model the given model
     */
    private void gameOver(MarbleSolitaireModel model) {
        this.appendString("Game is over!");
        this.appendString(model.getGameState() + "\n");
        this.appendString("Your score is: " + model.getScore() + "\n");
    }
}