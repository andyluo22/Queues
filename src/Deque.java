import java.util.Iterator;
import java.util.function.Consumer;

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
    - We probably want to use a Linked_List Implementation since we need to add at the front and back of the structure
    - Would be tricky if we used a resizing array since we can't add to the front of the array
    - We'd want to use a doubly linked list with sentinel nodes (Nodes that do not hold any data and is used to represent the start/end of a linked list)
    - For sentinel nodes, even for empty data structures, we still have two sentinel nodes
    - Drawback with sentinel nodes is that they can take up a lot of space

    Sources:
    GeeksforGeeks RemoveEndofNode Method
    Algorithms4th Edition Robert Sedgeweick
    Coding a Doubly Linked List in Java | w/Sentinel Nodes - Youtube, Tyler Programming
 */

public class Deque<Item> implements Iterable<Item> {
    //Instance Variables (make them private so client doesn't have idea on internal structure)
    private int size;
    private DLLNode header;
    private DLLNode trailer;

    // construct an empty deque
    public Deque() {
        trailer = new DLLNode(null, null, null);
        header = new DLLNode(null, null, trailer);
        trailer.setPrev(header);
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null argument");
        } else {
            addBetween(item, header, header.getNext());
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null argument");
        } else {
            addBetween(item, trailer.getPrev(), trailer);
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove the first element of an empty list");
        } else {
            return remove(header.getNext());
        }
    }

    //should've used double linked list but whatever because we need to traverse the whole array to look for the end;
    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove the last element of an empty list");
        } else {
            return remove(trailer.getPrev());
        }
    }

    private void addBetween(Item item, DLLNode predecessor, DLLNode successor) {
        DLLNode newNode = new DLLNode(item, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    private Item remove(DLLNode node) {
        DLLNode predecessor = node.getPrev();
        DLLNode successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;

        return (Item) node.getItem();
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    //must create the ListIterator class that implements Iterator for the method above
    private class ListIterator implements Iterator<Item> {
        private DLLNode current = header.getNext();

        @Override
        public boolean hasNext() {
            return current != trailer;
        }

        @Override
        public Item next() {
            try {
                Item item = (Item) current.getItem();
                current = current.getNext();
                return item;
            } catch(java.util.NoSuchElementException ne) {
                throw new java.util.NoSuchElementException("There are no more items to return");
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not a supported operation");
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            Iterator.super.forEachRemaining(action);
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Object> deque = new Deque<>();

        //Test removeFirst of 2 Items and addFirst of 2 Items
        System.out.println("Add two elements using addFirst : ");
        deque.addFirst("2");
        deque.addFirst("Andy");

        for (Object s : deque) {
            System.out.println(s);
        }

        deque.removeLast();

        for (Object s : deque) {
            System.out.println(s);
        }

        deque.removeLast();

        for (Object s : deque) {
            System.out.println(s);
        }

        deque.addFirst("loves");
        deque.addFirst("Andy");
        deque.addLast("crocodiles");

        for (Object s : deque) {
            System.out.println(s);
        }


        // System.out.println(deque.header.getNext().getItem()); // not using iterator

    }

}

