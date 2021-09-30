//CSuiteManager is also a manager
public class CSuiteManager extends Manager{
    private int stockOptions;
    private double strikePrice;
    private String fancyTitle;

    //Arguments to check the stockOptions member is not accidentally decreased and is always positive.
    public boolean validOptions(int stockOptions){
        if (this.stockOptions < stockOptions) {
            return true;
        }
        return false;
    }

    public CSuiteManager(String name, int age, String SSN, String passwd,int numSubordinates,String fancyTitle){
        //call PrimitivePerson's constructor
        super(name, age, SSN, passwd,numSubordinates);
        //A constructor assumes defaults of 0 for stockOptions and $1.00 for strikePrice.
        this.stockOptions = 0;
        this.strikePrice = 1;
        this.fancyTitle = fancyTitle;
    }

    //Accessor method to get the stockOptions of the CSuiteManager
    public int getStockOptions(int stockOptions){
        return this.stockOptions = stockOptions;
    }

    //Accessor method to get the current stock price
    public double getStrikePrice(double strikePrice){
        return this.strikePrice = strikePrice;
    }

    //Mutator method to set the value of the stock price
    public double setStrikePrice(double strikePrice){
        return strikePrice;
    }

    //Accessor method to get the cost to exercise all of their options
    public double getCost(){
        return strikePrice * stockOptions;
    }

    //Mutator method to increase their stockOptions
    public int increaseOptions(int n){
        return this.stockOptions + n;
    }

    //Method to compute the manager's capital gains
    public double capitalGains(double marketPrice,double strikePrice,int stockOptions){
        double cost = stockOptions * strikePrice;
        double gains = stockOptions * marketPrice;
        return gains-cost;
    }

    //Method to get the manager's fancy title
    public String getFancyTitle(){
        return this.fancyTitle;
    }

    //Method to return the manager's name and specialty
    @Override
    public String toString(){
        return "This is Manager," + "Name:"+ getName() +" "+"Age:"+ this.getAge()+","+"Title:" + this.getFancyTitle();
    }


}