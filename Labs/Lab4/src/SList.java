public interface SList {
    boolean add(String val); //Add val to the end of list. Any string is OK
    String get(int index); //index is from 0 to n-1
    boolean isEmpty();
    String remove(int index); // index is from 0 to n-1
    int size();
    String oddWords(int size);
    String evenWords(int size);
}

    // SList oddWords(SList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.

