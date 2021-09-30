import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cards {
    private Value value;
    private Suit suit;

    public Cards(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    private static List<Cards> deck = new ArrayList<Cards>();

    public Value getValue(){
        return value;}

    public void setValue(Value val){
        this.value = val;}

    public Suit getSuit(){
        return suit;}

    public void setSuit(Suit suit){
        this.suit = suit;}

    public static List<Cards> getDeck(){
        return deck;}

    public String toString(){
        return value + " of " + suit;}

    static {
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Cards(value, suit));
            }
        }
    }

    public static String playCards(){
        Random random = new Random();
        int ranVal = random.nextInt(deck.size());
        return deck.get(ranVal) + " ";}

    public static void bet(){
        Random ran = new Random();
        int ranVal = ran.nextInt(deck.size());
        switch (deck.get(ranVal).getSuit()){
            case Spades:
                System.out.println("Spades bet $10");
                break;
            case Clubs:
                System.out.println("Clubs bet $20");
                break;
            case Hearts:
                System.out.println("Hearts bet $30");
                break;
            case Diamonds:
                System.out.println("Diamonds bet $50");
                break;
            default:
                System.out.println("There is no bet");
        }
}

    public static void main(String[] args) {
        System.out.println("A list of 52 cards:");
        final List<Cards> total = getDeck();
        System.out.println(total);
        //total = new ArrayList<>();
        // shows error,see folder "other"

        System.out.println("Randomly choose 5 cards:");
        for(int i =0;i<5;i++){
            System.out.println(playCards());
        }
        System.out.println("Bet on cards:");
        for(int i =0;i<5;i++){
            bet();
        }
        System.out.println();
    }


}
