public class DLLNode<Item> {
    private Item item;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(Item item,DLLNode prev,DLLNode next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

}
