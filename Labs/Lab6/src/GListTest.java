import java.awt.event.HierarchyBoundsAdapter;

//Test methods for emptyGListImpl and GListImpl
public class GListTest<G> {

    public static void main(String[] args) {
        GListImpl list1 = new GListImpl("Hi");
        emptyGListImpl list2 = new emptyGListImpl();
        GListImpl list3 = new GListImpl("Hi");
        list1.add("My");
        list1.add("Name");
        list1.add("Is");
        list1.add("Ada");
        list1.add("Lu");
        list1.add("Wang");
        list1.add(".");
        System.out.println(list1.isEmpty());
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.getVal(6));
        System.out.println(list1.remove(4));
        System.out.println(list1.find("Lu"));
        System.out.println(list1.getNext());
        System.out.println(list1.toString());

        System.out.println(list2.isEmpty());
        System.out.println(list2);
        System.out.println(list2.size());
        System.out.println(list2.getVal(6));
        System.out.println(list2.remove(4));
        System.out.println(list2.find("Lu"));
        System.out.println(list2.getNext());
        System.out.println(list2.toString());
    }
}
