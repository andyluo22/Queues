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

    Amortized Analysis
    - Average running time per operation over a worst-case sequence of operations

    Java Generics:
    - Avoid casting in client
    - Discover type mismatch errors at compile-time instead of run-time
    - Type:  Declare Item "name" = new Item
    - Item can take the form of data structures such as Item[] array = (Item[]) new Object[size]
    - Is not cast normally like Item[] array = new Item [].  Follow the line above to know how to cast
    Generic Data Types:  Autoboxing
    - Wrapper type:  Each primitive type has a wrapper object type (Ex. Integer is the wrapper for int)
    - Autoboxing: automatically casts between a primitive type and its wrapper

    Iteration:
    - Design Challenge:  We can use iteration over the stack of generic items without revealing the internal representation (data structure) of the stack
    - Solution: Make the stack implement the java.lang.Iterable interface
    Iterators:
    - Iterable interface has a method that returns an Iterator object which is why in the Deque code, when we implement the interace Iterable<Item> we have to also return the iterator object
    - An Iterator object has methods hasNext() and next()
    - The reason we make Iterable data structures is that client code can be elegant (for each statement can be used instead of using hasNext() and creating iterator)

    Summary:  Client code can use generic stack for any type of data
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

