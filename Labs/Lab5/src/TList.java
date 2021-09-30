/**
 * Interface class TList that has the following methods.
 * @param <T> Represents the type of val stored in a linked list
 *
 * @author Lu Wang
 * @version 1.0
 * @since 2021-06-17
 */
public interface TList<T> {
    /**
     * @param val value stored in the object
     */
    boolean add(T val);

    /**
     * Get index is from 0 to n-1
     */
    T get(int index);

    /**
     * Checks if a linked list is empty;
     */
    boolean isEmpty();

    /**
     * Remove a node.
     * @param index of the Node
     */
    T remove(int index);

    /**
     * Size of the linked list.
     */
    int size();

    /**
     * Odd numbered objects of the linked list.
     * @param size of the linked list
     * @return returns val of the linked list
     */
    String oddTs(int size);

    /**
     * Even numbered objects of the linked list.
     * @param size of the linked list
     * @return returns val of the linked list
     */
    String evenTs(int size);
}
