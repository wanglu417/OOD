import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Card implements Comparable<Card> {
    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    private static List<Card> deck = new ArrayList<Card>();

    public Value getValue(){
        return value;}

    public void setValue(Value val){
        this.value = val;}

    public Suit getSuit(){
        return suit;}

    public void setSuit(Suit suit){
        this.suit = suit;}

    public static List<Card> getDeck(){
        return deck;}

    public String toString(){
        return value + " of " + suit;}

    static {
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
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
        switch (deck.get(ranVal).getSuit()) {
            case Spades -> System.out.println("Spades bet $10");
            case Clubs -> System.out.println("Clubs bet $20");
            case Hearts -> System.out.println("Hearts bet $30");
            case Diamonds -> System.out.println("Diamonds bet $50");
            default -> System.out.println("There is no bet");
        }
    }


    //A helper class for the compareTo method
    private int compSuit(){
        return switch (getSuit()) {
            case Spades -> 10;
            case Hearts -> 9;
            case Diamonds -> 8;
            case Clubs -> 7;
            default -> throw new IllegalArgumentException("No such Suit");
        };
    }


    //A helper class for the compareTo method
    private int compValue() {
        return switch (getValue()) {
            case ACE -> 14;
            case KING -> 13;
            case QUEEN -> 12;
            case JACK -> 11;
            case TEN -> 10;
            case NINE -> 9;
            case EIGHT -> 8;
            case SEVEN -> 7;
            case SIX -> 6;
            case FIVE -> 5;
            case FOUR -> 4;
            case THREE -> 3;
            case TWO -> 2;
            default -> throw new IllegalArgumentException("No such Value");
        };
    }


    @Override
    public int compareTo(Card o) {
        if(this.compSuit() == o.compSuit()){
            if(this.compValue() == o.compValue()){
                return 0;
            }
            else if(this.compValue()>o.compValue()){
                return 1;
            }
            else if(this.compValue() < o.compValue()){
                return -1;
            }
        }
        else if(this.compSuit() < o.compSuit()){
            return -1;
        }
        else if(this.compSuit() > o.compSuit()){
            return 1;
        }
        return -10;
    }



    public static void main(String[] args) {
        //Create a Collection (Array, List, ArrayList -- whichever you prefer)
        //containing the 26 uppercase characters of the alphabet. Use an iterator to
        //remove just the vowels ('A', 'E', 'I', 'O', 'U'-- treat 'Y' as a
        //consonant). Also use an iterator to print the result. The point is to practice
        //with iterators, so please do not solve in some other way.
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] tokens = upperChars.split("");
        ArrayList upperList = new ArrayList();
        for(int i=0; i < tokens.length;i++){
            String token = tokens[i];
            upperList.add(token);
        }
        //Print out the whole list with 26 uppercase character.
        System.out.println(upperList);
        //remove just the vowels and print out the remaining.
        for(Iterator n = upperList.iterator(); n.hasNext();) {
            String str = (String) n.next();
            if(str.equals("A") || str.equals("E") || str.equals("I") || str.equals("O") || str.equals("U")){
                n.remove();
            }
        }
        for(Iterator n = upperList.iterator(); n.hasNext();) {
            String str = (String) n.next();
            System.out.print(str+" ");
        }
        System.out.println();

        //Test the compareTo method
        Card diamondAce = new Card(Value.ACE, Suit.Diamonds);
        Card clubTwo = new Card(Value.TWO,Suit.Clubs);
        System.out.println(diamondAce.compareTo(clubTwo) > 0);//True
        Card diamondTwo = new Card(Value.TWO, Suit.Diamonds);
        System.out.println(diamondAce.compareTo(diamondTwo) > 0); //True
        Card heartsThree = new Card(Value.THREE, Suit.Hearts);
        Card spadesThree = new Card(Value.THREE, Suit.Spades);
        System.out.println(heartsThree.compareTo(spadesThree) < 0); //True

    }
}
