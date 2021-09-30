package cs5004.marblesolitaire.controller;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;

public interface MarbleSolitaireController {
    /**
     * This method should play a new game of Marble Solitaire using the provided model
     * @param model the provided model
     */
    void playGame(MarbleSolitaireModel model);
}

