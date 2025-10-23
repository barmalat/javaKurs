public class Stack {
    private Node head;
    private int size;

    public void printAll() {
        System.out.println(head.getValue());
        Node temp = head;
        while (!(temp == null)) {
            if (!(temp.getNext() == null)) {
                System.out.println(temp.getNext().getValue());
            }
            temp = temp.getNext();
        }
    }

    public void push(int newValue) {
        head = new Node(newValue, head);
    }

    public int pop() {
        int result = head.getValue();
        head = head.getNext();
        return result;
    }
}