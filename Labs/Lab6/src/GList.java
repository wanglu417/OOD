//Interface for the GList<G>
public interface GList<G> {
    GList add(G val);
    int size();
    G getVal(int index) throws IllegalArgumentException;
    GList<G> getNext();
    boolean isEmpty();
    int find(G val);
    GList<G> remove(int index) throws IllegalArgumentException;
}
