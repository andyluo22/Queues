import java.util.Iterator;

//Probably want to use resizing array and then just select a random number uniformly and access that position/index in the array
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private int size;
    private Item[] a;


    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[INIT_CAPACITY];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {

        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= size;

        // textbook implementation
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = a[i];
        }
        a = copy;

        // alternative implementation
        // a = java.util.Arrays.copyOf(a, capacity);
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return RandomizedQueueIterator;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}