import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A junit test for the TListImpl class.
 * @param <T>val in any type stored in the linked list
 *
 * @author Lu Wang
 * @version 1.0
 * @since 2021-06-17
 */

public class TListImplTest<T> {

    /**
     * Test for the oddTs method.
     */
    @Test
    public void oddTs() {
        TListImpl TList1 = new TListImpl();
        TList1.add("Hi");
        TList1.add(",");
        TList1.add("My");
        TList1.add("Name");
        TList1.add("Is");
        TList1.add("Ada");
        TList1.add("Lu");
        TList1.add("Wang");
        TList1.add(".");
        assertEquals(" Hi My Is Lu . ", TList1.oddTs(TList1.size()));
    }

    /**
     * Test for the evenTs method.
     */
    @Test
    public void evenTs() {
        TListImpl TList1 = new TListImpl();
        TList1.add("Thanks");
        TList1.add("God");
        TList1.add(",");
        TList1.add("It's");
        TList1.add("Friday");
        assertEquals(" God It's ", TList1.evenTs(TList1.size()));
    }

    /**
     * Test for the oddTs method with integer.
     */
    @Test
    public void oddTs2() {
        TListImpl TList1 = new TListImpl();
        TList1.add(1);
        TList1.add(2);
        TList1.add(3);
        TList1.add(4);
        TList1.add(5);
        TList1.add(6);
        TList1.add(7);
        TList1.add(8);
        TList1.add(9);
        assertEquals(" 1 3 5 7 9 ", TList1.oddTs(TList1.size()));
    }

    /**
     * Test for the evenTs method with integer.
     */
    @Test
    public void evenTs2() {
        TListImpl TList1 = new TListImpl();
        TList1.add(1);
        TList1.add(2);
        TList1.add(3);
        TList1.add(4);
        TList1.add(5);
        TList1.add(6);
        TList1.add(7);
        TList1.add(8);
        TList1.add(9);
        assertEquals(" 2 4 6 8 ", TList1.evenTs(TList1.size()));
    }

}
