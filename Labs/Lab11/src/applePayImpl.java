public class applePayImpl implements donationStrategy{
    @Override
    public void dntStrategy(String amount) {
        System.out.println("Processing "+ amount +" "+ "through ApplePay.");
    }
}
