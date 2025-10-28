public class Stack<T> {
    private Node<T> head;
    private int size;

    public Node<T> getHead() {
        return head;
    }

    public void printAll() {
        if (head==null){
            System.err.println("Stack jest pusty");
            return;
        }
        System.out.println(head.getValue());
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getNext() != null) {
                System.out.println(temp.getNext().getValue());
            }
            temp = temp.getNext();
        }
    }

    public void pushLast(T newValue) {
        Node<T> newLast = new Node<>(newValue, null);
        Node<T> oldLast = head;
        while (oldLast.getNext() != null) {
            oldLast = oldLast.getNext();
        }
        oldLast.setNext(newLast);
    }

    public void remove(T value) {
        Node<T> temp = head;
        if (head == null) {
            return;
        }
        if (temp.getValue().equals(value)) {
            head = temp.getNext();
            return;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getValue().equals(value)) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }

    public void removeAll(T value){
        Node<T> temp = head;
        if (head == null){
            return;
        }
        while (temp.getNext() != null){
            if (temp.getNext().getValue().equals(value)){
                temp.setNext(temp.getNext().getNext());
                continue;
            }
            temp = temp.getNext();
        }
        if (head.getValue().equals(value)){
            head = head.getNext();
        }
    }

    public void push(T newValue) {
        head = new Node<>(newValue, head);
    }

    public T pop() {
        T result = head.getValue();
        head = head.getNext();
        return result;
    }
}