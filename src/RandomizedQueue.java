import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

// iterating over a collection will not modify the collection. The Iterator class does have a remove() method,
// which is the only safe way of removing an element from a collection during iteration. But simply calling hasNext()
// and next() will not modify the collection.
//Keep in mind that if you modify the object returned by next(), those changes will be present in your collection.
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
        if (size > 0) {
            Item[] shuffleArr = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                shuffleArr[0] = a[0];
            }
            StdRandom.shuffle(shuffleArr);
            Item item = shuffleArr[0];

            for (int i = 1; i < size; i++) {
                a[i - 1] = shuffleArr[i];
            }
            size--;
            return item;
        } else return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size > 0) {
            Item[] shuffleArr = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                shuffleArr[0] = a[0];
            }
            StdRandom.shuffle(shuffleArr);
            Item item = shuffleArr[0];

            return item;
        } else return null;
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
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int queueSize = a.length;
        int count = size;
        private Item[] array = Arrays.copyOf(a, a.length);

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            if (count == size) {
                StdRandom.shuffle(array);
            }
            count--;
            return array[count];
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue queue = new RandomizedQueue();
        System.out.println(queue.size);
        queue.enqueue("Andy");
        System.out.println(queue.size);
        System.out.println(queue.sample());
        queue.dequeue();
        System.out.println(queue.size);
        queue.dequeue();
        System.out.println(queue.size);

    }

}