package Model;

/**
 *This interface represents the operation offered by the Tetris
 * model. One object of the model represents one game of Tetris.
 */
public interface GameState {
    /**
     * Initialize the game
     */
    void initialize();

    /**
     * Move a Tetris horizontally or vertically on a square by square basis
     *
     * @param isHorizontal whether is moving horizontal
     * @param step         every step Tetris moves
     * @return true if move horizontally;
     */
    boolean move(boolean isHorizontal, int step);

    /**
     * Rotate the Tetris from a randomly given shape to another.
     */
    void rotate();

    /**
     * Save the existing dropped blocks and update the game data.
     */
    void saveData();

    /**
     * Evaluate whether the existing dropped Tetris blocks can delete lines.
     *
     * @return true if can remove lines.
     */
    boolean canRemoveLines();

    /**
     * Remove lines when the block it not empty.
     */
    void removeLines();

    /**
     * Determine if the game is over or not. A game is over if no
     * more moves can be made.
     *
     * @return true if game is over.
     */
    boolean gameIsOver();

    /**
     * Get game score.
     *
     * @return a string showing the score.
     */
    String getScore();

}