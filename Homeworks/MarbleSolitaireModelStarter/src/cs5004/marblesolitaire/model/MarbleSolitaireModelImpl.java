package cs5004.marblesolitaire.model;
import cs5004.marblesolitaire.model.Marble.*;

import static cs5004.marblesolitaire.model.Marble.*;

/**
 * A class to implement the MarbleSolitaireModel interface.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
    private Marble[][] board;

    /**
     * The first constructor that takes no parameters, and initializes the game board
     * as shown above (arm thickness 3 with the empty slot at the center).
     */
    public MarbleSolitaireModelImpl(){
        board = new Marble[7][7];
        for (int i = 0;i < 7; i++){
            for(int j = 0; j <7; j++){
                if((i < 2 || i >4) && (j <2 ||j >4)){
                    board[i][j] = INVALID;
                }else{
                    board[i][j] = O;
                }
            }
        }
        board[3][3] = EMPTY;
    }

    /**
     * A second constructor initializes the game board so that the arm thickness
     * is 3 and the empty slot is at the position (sRow, sCol).
     * If this specified position is invalid, it should throw an IllegalArgumentException
     * @param sRow int row.
     * @param sCol int column.
     * @throws IllegalArgumentException If this specified position is invalid. It should throw an exception
     * with a message "Invalid empty cell position (r,c)" with 𝑟 and 𝑐 replaced with the
     * row and column passed to it.
     */
    public MarbleSolitaireModelImpl(int sRow,int sCol) throws IllegalArgumentException{
        board = new Marble[7][7];
        for(int i = 0; i <7; i ++){
            for(int j = 0; j <7; j++){
                if((i < 2 || i > 4) && (j < 2 || j > 4)){
                    board[i][j] = INVALID;
                }else{
                    board[i][j] = O;
                }
            }
            if (board[sRow][sCol] == INVALID || sRow < 0 ||sRow >7 || sCol < 0 || sCol >7){
                throw new IllegalArgumentException(String.format(
                        "Invalid empty cell position (%r,%c)",sRow, sCol));
            }
            else{
                board[sRow][sCol] = EMPTY;
            }
        }
    }

    /**
     * The third constructor takes the arm thickness as its only parameter and
     * initialize a game board with the empty slot at the center.
     * @param armThickness int armThickness.
     * @throws IllegalArgumentException if the arm thickness is not a positive odd number.
     */
    public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException{
        if(armThickness < 3 || armThickness %2 != 1){
            throw new IllegalArgumentException("The arm thickness should be a positive odd number.");
        }
        int boardSize = armThickness * 3 - 2;
        int center = (boardSize - 1)/2;
        int leftEdge = (boardSize - armThickness)/2;
        int rightEdge = boardSize - armThickness;
        board = new Marble[boardSize][boardSize];
        for(int i = 0; i < boardSize;i++){
            for(int j = 0; j < boardSize; j++){
                if(( i < leftEdge || i > rightEdge) && (j < leftEdge || j > rightEdge)){
                    board[i][j] = INVALID;
                }
                if(( i == center) && (j == center)){
                    board[i][j] = EMPTY;
                }
                else{
                    board[i][j] = O;
                }
            }
        }
    }

    /**
     * A fourth constructor that takes the arm thickness, row and column of the empty slot in that order.
     * @param armThickness int armThickness
     * @param sRow int Row
     * @param sCol int Column
     * @throws IllegalArgumentException if the arm thickness is not a positive odd number,
     * or the empty cell position is invalid.
     */
    public MarbleSolitaireModelImpl(int armThickness,int sRow,int sCol) throws IllegalArgumentException{
        if(armThickness < 3 || armThickness %2 != 1){
            throw new IllegalArgumentException("The arm thickness should be a positive odd number.");
        }
        int boardSize = armThickness * 3 - 2;
        int center = (boardSize - 1)/2;
        int leftEdge = (boardSize - armThickness)/2;
        int rightEdge = boardSize - armThickness;
        board = new Marble[boardSize][boardSize];
        if(sRow < 0 || sRow > boardSize || sCol < 0 || sCol > boardSize ||board[sRow][sCol] == INVALID){
            throw new IllegalArgumentException("The arm thickness should be a positive odd number and the empty cell " +
                    "position should be valid");
        }
        else{
            board[sRow][sCol] = EMPTY;
        }
    }

    /**
     * Move a single marble from a given position to another given position.
     * A move is valid only if the from and to positions are valid. Specific
     * implementations may place additional constraints on the validity of a move.
     *
     * @param fromRow the row number of the position to be moved from
     *                (starts at 0)
     * @param fromCol the column number of the position to be moved from
     *                (starts at 0)
     * @param toRow   the row number of the position to be moved to
     *                (starts at 0)
     * @param toCol   the column number of the position to be moved to
     *                (starts at 0)
     * @throws IllegalArgumentException if the move is not possible
     */
    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
        if(fromRow < 0 || fromRow > board.length -1 || fromCol <0 || fromCol > board.length-1 ||
        toRow < 0 || toRow > board.length -1 || toCol < 0 || toCol > board.length -1){
            throw new IllegalArgumentException("Move is invalid.");
        }
        if(board[fromRow][fromCol] != O){
            throw new IllegalArgumentException("You should start with a nonempty marble.");
        }
        if(board[toRow][toCol] != EMPTY){
            throw new IllegalArgumentException("You should move to an empty marble.");
        }
        if(Math.abs(fromRow - toRow) != 2 && Math.abs(fromCol - toCol) !=2){
            throw new IllegalArgumentException("You should move the marble to two positions away.");
        }
        if(board[(fromRow + toRow)/2][fromCol] != O || board[fromRow][(fromCol + toCol)/2] != O ){
            throw new IllegalArgumentException("There should be a non-empty marble between from and to");
        }
        board[fromRow][fromCol] = EMPTY;
        board[toRow][toCol] = O;
        if(fromRow == toRow){
            board[fromRow][(fromCol + toCol)/2] = EMPTY;
        }
        if(fromCol == toCol){
            board[(fromRow + toRow)/2][fromCol] = EMPTY;
        }

    }

    /**
     * Determine and return if the game is over or not. A game is over if no
     * more moves can be made.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        for(int i = 0;i< board.length;i++){
            for(int j = 0; j< board.length;j++){
                if(board[i][j] == O){
                    //Case 1: move from left to right
                    if(i+2 < board.length){
                        if(board[i+1][j] == O){
                            if (board[i+2][j] == EMPTY){
                                return false;
                            }
                        }
                    }
                    //case 2: move from right to left
                    if(i-2 >= 0){
                        if(board[i-1][j] == O){
                            if(board[i-2][i] == EMPTY){
                                return false;
                            }
                        }
                    }
                    //case 3: move from up to down
                    if(j-2>=0){
                        if(board[i][j-1] == O){
                            if(board[i][j-2] == EMPTY){
                                return false;
                            }
                        }
                    }
                    //case 4: move from down to up
                    if(j+2 < board.length){
                        if(board[i][j+1] == O){
                            if(board[i][j+2] == EMPTY){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Return a string that represents the current state of the board. The
     * string should have one line per row of the game board. Each slot on the
     * game board is a single character (O, X or space for a marble, empty and
     * invalid position respectively). Slots in a row should be separated by a
     * space. Each row has no space before the first slot and after the last slot.
     *
     * @return the game state as a string
     */
    @Override
    public String getGameState() {
        StringBuilder res = new StringBuilder();
        int armThickness = (board.length + 2) / 3;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if (board[i][j] == INVALID && j > (board.length - armThickness)) {
                    continue;
                } else{
                    if(i<(board.length -armThickness)/2 || i > ( board.length - armThickness)/2 + armThickness - 1){
                        if(j == board.length - armThickness){
                            res.append(board[i][j].toString());
                        }
                        else{
                            res.append(board[i][j].toString()).append(" ");
                        }
                    }
                    else{
                        if( j == board.length - 1){
                            res.append(board[i][j].toString());
                        }
                        else{
                            res.append(board[i][j].toString()).append(" ");
                        }
                    }
                }
            }
            if (i == board.length -1){
                continue;
            }
            else{
                res.append("\n");
            }
        }
        return res.toString();
    }

    /**
     * Return the number of marbles currently on the board.
     *
     * @return the number of marbles currently on the board
     */
    @Override
    public int getScore() {
        int scoreCount = 0;
        for(Marble[] member : board){
            for(int i =0;i< board.length;i++){
                if(member[i] == O){
                    scoreCount+=1;
                }
            }

        }
        return scoreCount;
    }
}