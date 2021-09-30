public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {
    public Node<E> head;
    public int capacity_limit;
    public int current_len;
    public Node<E> tail;

    public OrderedListImpl (int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity is invalid.");
        }
        head = null;
        tail = null;
        current_len = 0;
        this.capacity_limit = capacity;
    }

    @Override
    public E getMax() {
        if (head == null) {
            return null;
        }
        return tail.val;
    }

    @Override
    public void add(E cand) {
        Node<E> temp = new Node<>(cand, null);
        Node<E> dummy = new Node<>(null);
        dummy.next = head;
        Node<E> prev = dummy;
        Node<E> current = head;
        if (current_len==0){
            head = new Node<>(cand,null);
            tail=head;
            current_len++;
        }
        else{
            while(current!=null){
                if (current.val.compareTo(cand)<=0){
                    current=current.next;
                    prev=prev.next;
                    if(current==null){
                        prev.next=temp;
                        tail=temp;
                        current_len++;
                    }
                }
                else{
                    if(prev.next==head){
                        head=new Node<>(cand,null);
                        head.next=current;
                        current_len++;
                        break;
                    }
                    else{
                        prev.next=temp;
                        temp.next=current;
                        current_len++;
                        break;
                    }
                }
            }
        }
        if (current_len > capacity_limit) {
            head=head.next;
            current_len=capacity_limit;
            }
    }
        /*while (current != null) {
            if (current.val.compareTo(cand) >= 0 && prev.val.compareTo(cand) < 0) {
                prev.next = temp;
                temp.next = current;
                current_len++;
                added = true;
                break;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }
        if (!added) {
            prev.next = temp;
            if (current_len == 0) {
                head = temp;
            }
            current_len++;
            tail = temp;
        }
        if (current_len > capacity_limit) {
            head = dummy.next.next;
        }
    }
*/

    @Override
    public OrderedList<E> merge(OrderedList<E> o) {
        OrderedListImpl<E> other = (OrderedListImpl<E>) o;
        if (o instanceof OrderedList) {
            Node<E> current1 = head;
            Node<E> current2 = other.head;
            Node<E> dummy = new Node<>(null);
            Node<E> current3 = dummy;
            while (current1 != null && current2 != null) {
                if (current1.val.compareTo(current2.val) <= 0) {
                    current3.next = new Node<E>(current1.val, null);
                    current1 = current1.next;
                    current3 = current3.next;
                } else if (current1.val.compareTo(current2.val) > 0) {
                    current3.next = new Node<E>(current2.val, null);
                    current2 = current2.next;
                    current3 = current3.next;
                }
            }
            while (current1 != null) {
                current3.next = new Node<>(current1.val, null);
                current1 = current1.next;
                current3 = current3.next;
            }
            while (current2 != null) {
                current3.next = new Node<E>(current2.val, null);
                current2 = current2.next;
                current3 = current3.next;
            }
            OrderedListImpl<E> res = new OrderedListImpl<E>(this.capacity_limit + other.capacity_limit);
            current3 = dummy.next;
            while (current3 != null) {
                res.add(current3.val);
                current3 = current3.next;
            }
            return res;
        }
        else{
            throw new IllegalArgumentException("Other is not in the same concrete class.");
        }
    }

    @Override
    public void resize(int newCapacity) {
        Node<E> dummy = new Node<>(null);
        dummy.next = head;
        Node<E> current = head;
        if(capacity_limit <= newCapacity){
            return;
        }
        else{
            for(int i = 0; i < (current_len - newCapacity);i++ ){
                current = current.next;
            }
            head = current;
            capacity_limit=newCapacity;
        }
    }

    @Override
    public String toString() {
       String res = "[";
       int length = 0;
       Node<E> current = head;
       while(current!= null) {
           res = res + String.valueOf(current.val) + " ";
           current = current.next;
           length ++;
       }
       if(length < capacity_limit) {
           for(int i = 0;i < capacity_limit - length; i++) {
               res = res + "?"+" ";
           }
       }
       res = res.substring(0,res.length()-1);
       res = res + "]";
       return res;
    }
}
