/**
 * Represents a node for a linked list
 * @param <T> A node stored in the linked list with value in any type
 *
 * @author Lu Wang
 * @version 1.0
 * @since 2021-06-17
 */
public class TNode<T> {
    // val -- String
    public T val;
    // a pointer, pointing to the next node
    // if there's no next, pointing to null
    public TNode next;

    /**
     * Constructor for a TNode
     * @param val The val of the node.
     * @param next A reference to the next node, if any.
     */
    public TNode(T val, TNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Display the string to the standard output.
     * @return returns the string val.
     */
    @Override
    public String toString() {
        return " " + val + " ";
    }
}
