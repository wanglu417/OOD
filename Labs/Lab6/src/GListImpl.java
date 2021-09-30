public class GListImpl<G> implements GList<G> {
    emptyGListImpl<G> emptyGList;
    G val;
    GListImpl<G> innerList;

    //constructor for myself and return myself
    public GListImpl<G> returnMyself() {
        return this;
    }

    //Constructor for a GList with G val parameter
    public GListImpl(G val){
        this.val = val;
        this.innerList = null;
    }

    //add a val to the list
    @Override
    public GList<G> add(G val) {
        if(this.val == null){
            return emptyGList.add(val);
        }
        else if (this.val !=null &&innerList == null){
            innerList = new GListImpl<G>(val);
            return innerList;
        }
        return innerList.add(val);
    }

    //check the size of the list
    @Override
    public int size() {
        if (innerList == null){
            return 1;
        }else{
            int sizeOfInner = innerList.size();
            return 1 + sizeOfInner;
        }
    }

    //get the val of a given index
    @Override
    public G getVal(int index) {
        if (index < 0 || index > size()){
            throw new IllegalArgumentException(("Invalid index given."));
        }
        else if(index == 0){
            return this.val;
        } else{
            return innerList.getVal(index-1);
        }
    }

    //get the next list of the given list.If next is null,return an empty list
    @Override
    public GList<G> getNext() {
        if(innerList == null){
            return emptyGList;
        }
        else{
            return innerList;
        }

    }

    //check whether the list is empty
    @Override
    public boolean isEmpty() {
        return false;
    }

    //find the index of the first occurrence of a given val
    @Override
    public int find(G val) {
        if (this.val == null) {
            return emptyGList.find(val);
        }
        else if (this.val == val){
            return 0;
        }
        else {
            return innerList.find(val)+1;
        }
    }

    //remove a val with the given index and return the modified list
    @Override
    public GList<G> remove(int index) {
        if (index < 0 || index > size()){
            throw new IllegalArgumentException(("Invalid index given."));
        }
        else if (index == 0){
            return innerList;
        }else{
            innerList = (GListImpl<G>) innerList.remove(index-1);
            return this;
        }
    }

    //string representation of the list
    @Override
    public String toString(){
        if (innerList == null){
            return val + " ";
        }
        String fromInnerList = innerList.toString();
        return this.val + " " + fromInnerList;
    }

}
