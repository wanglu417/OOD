
public class SListTest {

    public static void main (String[] args) {
        SList list1 = new SListImpl();
        System.out.println(list1.isEmpty());
        list1.add("My");
        list1.add("Name");
        list1.add("Is");
        list1.add("Ada");
        list1.add("Lu");
        list1.add("Wang");
        System.out.println(list1.oddWords(list1.size()));
    }
}



