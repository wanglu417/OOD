public class SListImpl implements SList {
    //Head as the member variable
    private Node head;

    public SListImpl() {
        head = null;
        //Create an empty list
    }

    // creates a linked list with head n
    public SListImpl(Node n) {
        head = n;
    }

    @Override
    public boolean add(String val) {
        if (head == null) {
            // this is an empty linked list
            // just assign val to the head
            head = new Node(val, null);
            return true;
        }

        Node traversePtr = head;

        while (traversePtr.next != null) { // we keep traversing when the .next is not null
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        // when we reach here, traversePtr is pointing to the last node of the linked list
        traversePtr.next = new Node(val, null);

        return true;
    }

    @Override
    public String toString() {
        String res = "";
        Node traversePtr = head;

        while (traversePtr != null) { // we jump out of the loop when we're at the null ptr
            res = res + traversePtr.toString();
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return res;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        Node traversePtr = head;
        while (traversePtr != null && pos != index) {
            //increment the pos
            pos++;
            //jump to the next node
            traversePtr = traversePtr.next;
        }
        //shen we reach here, we know 'traversePtr' is pointing to the target index
        return traversePtr.val;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int pos = 0;
        Node traversePtr = head;
        Node prevPtr = null;
        while (pos != index) {
      /*
      if (pos == index) {
        // we've reached the target position.
        // get out of the loop
        break;
      }
       */

            // increment the pos
            pos++;
            // before we jump to the next node, set the 'prevPtr' to point to the current node
            prevPtr = traversePtr;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        // when we reach here, we know 'traversePtr' is pointing to the node at the target index
        // now remove the node that 'traversePtr' is pointing to, by setting .next of 'prevPtr' to
        // the next of 'traversePtr'.
        if (prevPtr == null) {
            // we're removing the first node,
            // set the head to the next of 'traversePtr'
            head = traversePtr.next;
            return traversePtr.val;
        }

        prevPtr.next = traversePtr.next;
        return traversePtr.val;
    }

    @Override
    public int size() {
        int counter = 0;
        Node traversePtr = head;

        while (traversePtr != null) { //jump out of the loop when we're at the null ptr
            // increment the counter
            counter++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return counter;
    }

    @Override
    //Returns list of odd numbered words only
    public String oddWords(int size) {
        //Create an empty string
        String SList = " ";
        Node traversePtr = head;
        while (traversePtr != null) {
            SList = SList + traversePtr.val + " ";
            traversePtr = traversePtr.next;
            //If traversePtr is pointing to null, we know we are reaching the end
            //Otherwise, increment the position
            if (traversePtr != null) {
                traversePtr = traversePtr.next;
            }
        }
        return SList;
    }

    @Override
    //Returns list of even numbered words only
    public String evenWords(int size) {
        String SList = " ";
        Node traversePtr = head.next;
        while (traversePtr != null && size >= 2) {
            SList = SList + traversePtr.val+ " ";
            traversePtr = traversePtr.next;
            //If traversePtr is pointing to null, we know we are reaching the end
            //Otherwise, increment the position
            if (traversePtr != null) {
                traversePtr = traversePtr.next;
            }
        }
        return SList;
    }


}



