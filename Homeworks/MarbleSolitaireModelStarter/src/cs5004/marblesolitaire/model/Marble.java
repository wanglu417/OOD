package cs5004.marblesolitaire.model;

/**
 * Enum class to represent each step of the Marble Solitaire game.
 */
public enum Marble {
    EMPTY, O,INVALID;

    /**
     * toString method for enum members
      * @return a string
     */
    public String toString(){
    if(this == O) {
        return "O";
    }
    else if( this == EMPTY){
        return "X";
    }
    else{
        return " ";
    }
}
}
