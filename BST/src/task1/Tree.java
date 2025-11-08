package task1;

public class Tree {
    private Node root;

    public void insert(int newValue) {
        root = insertRec(root, newValue);
    }

    public Node insertRec(Node node, int newValue) {
        if (node == null) {
            return new Node(newValue);
        }
        if (newValue < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), newValue));
        }
        if (newValue > node.getValue()) {
            node.setRight(insertRec(node.getRight(), newValue));
        }
        return node;
    }

    public void insertIterative(int newValue) {
        Node newNode = new Node(newValue);
        if (root == null) {
            root = newNode;
            return;
        }
        Node parent = root;
        Node temp = root;
        while (temp != null) {
            parent = temp;
            if (newValue > temp.getValue()) {
                temp = temp.getRight();
            } else {
                temp = temp.getLeft();
            }
        }
        if (newValue > parent.getValue()) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }
    }

    public boolean contains(int value) {
        return containsRec(root, value);
    }

    public boolean containsRec(Node node, int value) {
        if (node == null) return false;
        if (value == node.getValue()) return true;
        return value > node.getValue() ? containsRec(node.getRight(), value) : containsRec(node.getLeft(), value);
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("Drzewo jest puste!");
        } else {
            inOrderRec(root);
        }
    }

    public void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inOrderRec(node.getRight());
        }
    }
}