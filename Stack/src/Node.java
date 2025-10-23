public class Node {
    private int value;
    private Node next;

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
