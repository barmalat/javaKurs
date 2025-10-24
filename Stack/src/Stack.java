public class Stack {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public void printAll() {
        System.out.println(head.getValue());
        Node temp = head;
        while (temp != null) {
            if (temp.getNext() != null) {
                System.out.println(temp.getNext().getValue());
            }
            temp = temp.getNext();
        }
    }

    public void pushLast(int newValue) {
        Node newLast = new Node(newValue, null);
        Node oldLast = head;
        while (oldLast.getNext() != null) {
            oldLast = oldLast.getNext();
        }
        oldLast.setNext(newLast);
    }

//    public void removeAll(int value) {
//        Node temp = head;
//        while (temp.getValue() == value) {
//            temp = temp.getNext();
//            head = temp;
//        }
//        while (!(temp == null) && !(temp.getNext() == null)) {
//            if (temp.getNext().getNext()==null){
//                temp.setNext(null);
//            }
//            while (temp.getNext().getValue() == value) {
//                temp.setNext(temp.getNext().getNext());
//            }
//            temp = temp.getNext();
//        }
//    }todo

    public void remove(int value) {
        Node temp = head;
        if (head == null) {
            return;
        }
        if (temp.getValue() == value) {
            head = temp.getNext();
            return;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                temp.setNext(temp.getNext().getNext());
                return;
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