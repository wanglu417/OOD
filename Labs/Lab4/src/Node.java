public class Node {
    // 1. val -- String
    public String val;
    // 2. a pointer, pointing to the next node
    // if there's no next, pointing to null
    public Node next;

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }
    //
    //public String oddList(){
    //Node odd = new Node();
    //}
    //

    @Override
    public String toString() {
        return " " + val + " ";
    }
}