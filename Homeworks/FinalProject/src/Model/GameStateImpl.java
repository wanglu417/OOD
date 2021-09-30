package Model;

import java.awt.*;
import java.util.Random;

/**
 * A class to implement the GameState interface.
 */
public class GameStateImpl implements GameState {
    public int x;
    public int y;
    public static int[][] totalBlocks;
    private int[] linesToRemove;
    public Tetris tetris;
    private Random random;
    public int nextTetris;
    public static int currentTetris;
    private int score;
    public static int state;
    public String[] stateText = new String[]{"START","PAUSE","CONT","RST"};
    //Seven types of Tetris blocks
    public static Tetris[] TETRIS = new Tetris[]{
            new Tetris(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            new Tetris(new int[]{-1, 0, 1, 2}, new int[]{0, 0, 0, 0}),
            new Tetris(new int[]{-1, -1, 0, 1}, new int[]{0, 1, 0, 0}),
            new Tetris(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 1}),
            new Tetris(new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1}),
            new Tetris(new int[]{-1, 0, 0, 1}, new int[]{1, 0, 1, 0}),
            new Tetris(new int[]{-1, 0, 0, 1}, new int[]{0, 0, 1, 0})};

    //Seven colors for Tetris
    public static Color[] colors = new Color[]{
            new Color(200, 50, 80),
            new Color(200, 150, 0),
            new Color(150, 150, 20),
            new Color(245, 150, 200),
            new Color(100, 100, 200),
            new Color(100, 150, 230),
            new Color(150, 150, 150),};


    /**
     * Constructor takes no parameter,initialize the game board and calls.
     * the helper method initialize().
     */
    public GameStateImpl() {
        initialize();
    }

    /**
     * Initialize the game board.
     */
    @Override
    public void initialize(){
        //Use 2D array to represent the total blocks on the game board;
        totalBlocks = new int[10][20];
        random = new Random();
        //Randomly generalize the next Tetris
        nextTetris = random.nextInt(7);
        resetBlocks();
    }

    /**
     * Make the block fall down
     * @param isHorizontal determine if its moving horizontally or vertically.
     * @param step move steps.
     * @return false.
     */
    @Override
    public boolean move(boolean isHorizontal, int step) {
        Boolean canRemoveLines = false;
        if (isHorizontal) {
            for (Point point : tetris.points) {
                if (x + point.x + +step < 0 || x + point.x + step > 9
                        || totalBlocks[point.x + x + step][point.y + y + 2] != 0) {
                    return false;
                }
            }

            x += step;

        } else {
            for (Point point : tetris.points) {
                if (y + point.y + step > 17 || totalBlocks[point.x + x][point.y + y + 2 + step] != 0) {
                    saveData();
                    canRemoveLines = canRemoveLines();
                    if (canRemoveLines) {
                        removeLines();
                    }
                    if(gameIsOver()){
                        state = 3;
                    }
                    resetBlocks();
                    return true;
                }
            }

            y += step;
        }
        return false;
    }

    /**
     * Rotate current Tetris clockwise.
     */
    @Override
    public void rotate() {
        for (Point point : tetris.points) {
            //coordinate x of the center point will be -y
            int tempX = -point.y + x;
            //coordinate y of the center point will be x
            int tempY = point.x + y;
            //Handle corner cases
            if (x < 0 || x > 9) {
                return;
            }
            if (y<-2 ||y > 17) {
                return;
            }
            if(currentTetris ==4){
                return;
            }
            if(totalBlocks[tempX][tempY+2]!=0){
                return;
            }
        }
        for (Point point : tetris.points) {
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }

    /**
     * Save data of blocks when Tetris are dropping.
     */
    @Override
    public void saveData() {
        for (Point point : tetris.points) {
            totalBlocks[point.x + x][point.y + y + 2] = currentTetris + 1;
        }

    }

    /**
     * A helper method to reset the blocks
     */
    private void resetBlocks() {
        x = 4;
        y = -2;
        linesToRemove = new int[20];
        currentTetris = nextTetris;
        this.tetris = new Tetris(TETRIS[nextTetris]);
        nextTetris = random.nextInt(7);

    }

    /**
     * Determine if there are lines can be deleted.
     * @return false.
     */
    @Override
    public boolean canRemoveLines(){
        boolean canRemoveLines = false;
        boolean isEmpty;
        //loop bottom up
        for(int i =19; i>=2; i--){
            isEmpty = false;
            for(int j=0; j<10; j++){
                //If there is an empty block, break
                if(totalBlocks[j][i] == 0){
                    isEmpty = true;
                    break;
                }
            }
            if(!isEmpty){
                canRemoveLines = true;
                linesToRemove[i-1] = linesToRemove[i] +1;
            }
            else{
                linesToRemove[i-1] = linesToRemove[i];
            }
        }
        return canRemoveLines;

    }

    /**
     * Remove lines that do not have empty block.
     */
    @Override
    public void removeLines(){
        for(int j = 19; j>=2 ; j--){
            for(int i =0; i<10; i++ ){
                totalBlocks[i][j+ linesToRemove[j]] = totalBlocks[i][j];
            }
        }
        //Delete one line get 10 points
        score += linesToRemove[2]*10;
    }

    /**
     * Determine whether game is over.
     * @return false.
     */
    @Override
    public boolean gameIsOver() {
        for (int j = 0; j < 10; j++) {
            //when Tetris is located at the top two lines
            if (totalBlocks[j][2] != 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * Get score when game is ove.
     * @return s string.
     */
    @Override
    public String getScore(){
        return " " + score;
    }
}
