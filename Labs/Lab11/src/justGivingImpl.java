public class justGivingImpl implements donationStrategy{
    @Override
    public void dntStrategy(String amount) {
        System.out.println("Processing " + amount +" "+ "through JustGiving.");
    }
}
