import java.util.Iterator;

//Probably want to use resizing array and then shuffle every cycle and remove the first or last part of the array
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private DLLNode header;
    private DLLNode trailer;

    // construct an empty randomized queue
    public RandomizedQueue() {
        trailer = new DLLNode(null, null, null);
        header = new DLLNode(null, null, trailer);
        trailer.setPrev(header);
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return 0;
    }

    // add the item
    public void enqueue(Item item) {
        return;
    }

    // remove and return a random item
    public Item dequeue() {
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}