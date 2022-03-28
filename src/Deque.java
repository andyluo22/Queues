import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    Either use a resizing array for a deque or a Linkedlist data structure to insert, remove, or iterate.
    Since we are unable to use a linkedlist or arraylist, probably best to use resizing array.

    LinkedList Implementation
    - Every operation takes constant time in worst case
    - However, uses extra time and space to deal with the links

    Resizing-array Implementation
    - Every operation takes constant amortized time
    - Less wasted space

    Amortized Analysis:  Average running time per operation over a worst-case sequence of operations
 */
public class Deque<Item> implements Iterable<Item> {

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return 0;
    }

    // add the item to the front
    public void addFirst(Item item) {
        return;
    }

    // add the item to the back
    public void addLast(Item item) {
        return;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        return null;
    }

    // remove and return the item from the back
    public Item removeLast() {
        return null;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}

