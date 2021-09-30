import java.util.Objects;

/**
 * The TListImpl class implements TList interface.
 * Represents a linked list with TNodes in different types.
 * @param <T>Type of value stored in the linked list
 *
 * @author Lu Wang
 * @version 1.0
 * @since 2021-06-17
 */
public class TListImpl<T> implements TList<T> {
    /**
     * private field TNode.
     */
    private TNode head;

    /**
     * Constructor for a TListImpl.
     * Create an empty list.
     */
    public TListImpl() {
        head = null;
    }

    /**
     * Constructor for a TListImpl with TNode.
     *
     * @param n The TNode to store.
     */
    public TListImpl(TNode n) {
        head = n;
    }

    /**
     * Add a TNode to the linked list.
     *
     * @param val The val of the TNode.
     * @return true.
     */
    @Override
    public boolean add(T val) {
        if (head == null) {
            // this is an empty linked list
            // just assign val to the head
            head = new TNode(val, null);
            return true;
        }

        TNode traversePtr = head;

        while (traversePtr.next != null) {
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        // when we reach here, traversePtr is
        // pointing to the last node of the linked list
        traversePtr.next = new TNode(val, null);

        return true;
    }

    /**
     * toString method to display the string to the standard output.
     *
     * @return The string representation of the TListImpl.
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        TNode traversePtr = head;

        while (traversePtr != null) {
            // we jump out of the loop when we're at the null ptr
            res.append(traversePtr.toString());
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return res.toString();
    }

    /**
     * Get the val of the TNode with a specified index.
     *
     * @param index The index of the val we want.
     * @return The TNode object.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        TNode traversePtr = head;
        while (traversePtr != null && pos != index) {
            //increment the pos
            pos++;
            //jump to the next node
            traversePtr = traversePtr.next;
        }
        //'traversePtr' is pointing to the target index
        return (T) traversePtr.val;

    }

    /**
     * Check if the linked list is empty.
     *
     * @return true if it's empty; Otherwise, return false.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes a specific TNode with a specified index.
     *
     * @param index of the TNode we want to remove.
     * @return returns the value of the linked list after removal.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int pos = 0;
        TNode traversePtr = head;
        TNode prevPtr = null;
        while (pos != index) {
            // increment the pos
            pos++;
            // before we jump to the next node
            // set the 'prevPtr' to point to the current node
            prevPtr = traversePtr;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        // when we reach here, we know 'traversePtr' is
        // pointing to the node at the target index
        // now remove the node that 'traversePtr' is
        // pointing to, by setting .next of 'prevPtr' to
        // the next of 'traversePtr'.
        if (prevPtr == null) {
            // we're removing the first node,
            // set the head to the next of 'traversePtr'
            head = traversePtr.next;
            return (T) traversePtr.val;
        }

        prevPtr.next = traversePtr.next;
        return (T) traversePtr.val;
    }

    /**
     * Get the size of the linked list.
     *
     * @return returns the size.
     */
    @Override
    public int size() {
        int counter = 0;
        TNode traversePtr = head;

        while (traversePtr != null) {
            // increment the counter
            counter++;
            // jump to the next node
            traversePtr = traversePtr.next;
        }

        return counter;
    }

    /**
     * Get the list of odd numbered value only.
     *
     * @param size The size of the linked list.
     * @return returns a linked list.
     */
    @Override
    //Returns list of odd numbered words only
    public String oddTs(int size) {
        //Create an empty string
        StringBuilder SList = new StringBuilder(" ");
        TNode traversePtr = head;
        while (traversePtr != null) {
            SList.append(traversePtr.val).append(" ");
            traversePtr = traversePtr.next;
            //If traversePtr is pointing to null,
            // we know we are reaching the end
            //Otherwise, increment the position
            if (traversePtr != null) {
                traversePtr = traversePtr.next;
            }
        }
        return SList.toString();
    }

    /**
     * Get the list of even numbered value only.
     *
     * @param size The size of the linked list.
     * @return returns a linked list.
     */
    @Override
    //Returns list of even numbered words only
    public String evenTs(int size) {
        StringBuilder SList = new StringBuilder(" ");
        TNode traversePtr = head.next;
        while (traversePtr != null && size >= 2) {
            SList.append(traversePtr.val).append(" ");
            traversePtr = traversePtr.next;
            //If traversePtr is pointing to null
            // we know we are reaching the end
            //Otherwise, increment the position
            if (traversePtr != null) {
                traversePtr = traversePtr.next;
            }
        }
        return SList.toString();
    }

    /**
     * Checks if two objects are equal.
     * @param o another object
     * @return true if they are equal,otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TListImpl<T> tList = (TListImpl<T>) o;
        return Objects.equals(head, tList.head);
    }

    /**
     * Get the hash code of a non-null argument and 0 for a null argument.
     * @return returns the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}


