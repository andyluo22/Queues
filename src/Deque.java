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

    Sources:
    GeeksforGeeks RemoveEndofNode Method
    Algorithms4th Edition Robert Sedgeweick
 */

public class Deque<Item> implements Iterable<Item> {
    //Instance Variables (make them private so client doesn't have idea on internal structure)
    private Node first;
    private Node last; // keep track of both first and last nodes
    private int N;  // keeps track of the number of items since lists don't have a length method like arrays

    private class Node { //Nested class to define nodes
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.N = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // add the item to the back
    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        try {
            Item item = first.item;
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            N--;
            return item;
        } catch (NullPointerException ne) {
            System.out.println("Cannot remove an empty list");
            return null;
        }

    }

    //should've used double linked list but whatever because we need to traverse the whole array to look for the end;
    // remove and return the item from the back
    public Item removeLast() {
        try {
            if (first.item == null) {
                return null;
            } else if (first.next.item == null) {
                Item item = first.item;
                first = first.next;
                if (isEmpty()) {
                    last = first;
                }
                N--;
                return item;
            }
            else {
                Item lastItemToReturn = null;
                for(Node x = first; x.item != null; x = first.next) {
                    if(x.next.item == null) {

                    }
                }
                last.next = null;

                return lastItemToReturn;
            }
        } catch (NullPointerException ne) {
            System.out.println("Cannot remove an empty list");
            return null;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    //must create the ListIterator class that implements Iterator for the method above
    private class ListIterator implements Iterator<Item> {
        private Deque<Item>.Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
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
        deque.addFirst("String");
        deque.addFirst(2);

        for (Object element : deque) {
            System.out.println(element);
        }
        System.out.println("Size:" + deque.size());

        System.out.println("Remove two elements using removeFirst: ");
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();

        for (Object element : deque) {
            System.out.println(element);
        }
        System.out.println("Size:" + deque.size());


        //Test removeLast
        System.out.println("Add two elements using addLast");
        deque = new Deque<>();
        deque.addLast(3);
        deque.addLast("Andy");

        for (Object element : deque) {
            System.out.println(element);
        }
        System.out.println("Size:" + deque.size());


        System.out.println("Remove two elements using removeLast");
        deque.removeLast();
        deque.removeLast();


        System.out.println("Add first and addLast");
        deque.addFirst(3);
        deque.addLast(4);

        for (Object element : deque) {
            System.out.println(element);
        }
        System.out.println("Size:" + deque.size());


    }

}

