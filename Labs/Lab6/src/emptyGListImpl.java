public class emptyGListImpl<G> implements GList<G> {
    @Override
    public GList<G> add(G val) {
        return new GListImpl<>(val);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public G getVal(int index) throws IllegalArgumentException {
        throw new IllegalArgumentException(("This list is empty. No value to be shown"));
    }

    @Override
    public GList<G> getNext() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int find(G val) {
        return -1;
    }

    @Override
    public GList<G> remove(int index) throws IllegalArgumentException {
        throw new IllegalArgumentException("Cannot remove anything from an empty list");
    }

    @Override
    public String toString(){
        return "[Empty]";
    }
}
