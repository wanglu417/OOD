public class Main {
    public static void main(String[] args) {
        donationStrategy JG = new justGivingImpl();
        JG.dntStrategy("$500");

        donationStrategy AP = new applePayImpl();
        AP.dntStrategy("$200");
    }
}
