import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//A JUnit test class for the CSuiteManager class
public class CSuiteManagerTest {
    private CSuiteManager Manager1;

    @Before
    public void Setup(){
        Manager1 = new CSuiteManager("Lucy",30,"1234","77770",10,
        "Chief Technical Officer");
    }

    @Test
    public void validOptions() {
        int stockOptions = -10;
        assertFalse(Manager1.validOptions(stockOptions));
    }

    @Test
    public void getStockOptions() {
        int stockOptions = 10000;
        assertEquals(10000,Manager1.getStockOptions(stockOptions));
    }

    @Test
    public void getStrikePrice() {
        double strikePrice = Manager1.getStrikePrice(300.0);
        assertEquals(300,strikePrice,0.1);
    }

    @Test
    public void setStrikePrice() {
        double strikePrice = Manager1.setStrikePrice(500);
        assertEquals(500,strikePrice,0.1);
    }

    @Test
    public void getCost() {
        int stockOptions = Manager1.getStockOptions(100);
        double strikePrice = Manager1.getStrikePrice(300);
        assertEquals(stockOptions*strikePrice,Manager1.getCost(),0.1);
    }

    @Test
    public void increaseOptions() {
        int stockOptions = Manager1.getStockOptions(100);
        int n = Manager1.increaseOptions(500);
        assertEquals(stockOptions+n,Manager1.increaseOptions(n));
    }

    @Test
    public void capitalGains() {
        double marketPrice = 400;
        int stockOptions = 100;
        double strikePrice = 300;
        double gains = marketPrice*stockOptions - strikePrice*stockOptions;
        assertEquals(gains,Manager1.capitalGains(marketPrice,strikePrice,stockOptions),0.1);
    }

    @Test
    public void getFancyTitle() {
        assertEquals("Chief Technical Officer",Manager1.getFancyTitle());
    }

    @Test
    public void testToString() {
        assertEquals("This is Manager,Name:Lucy Age:30,Title:Chief Technical Officer",Manager1.toString());
    }
}