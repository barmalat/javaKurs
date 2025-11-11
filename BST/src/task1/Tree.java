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
        return value > node.getValue() ?
                containsRec(node.getRight(), value) :
                containsRec(node.getLeft(), value);
    }

    public boolean containsIterative(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.getValue() == value) return true;
            if (value > temp.getValue()) {
                temp = temp.getRight();
            } else temp = temp.getLeft();
        }
        return false;
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

    public void delete(int value) {
        deleteRec(root, value);
    }

    public Node deleteRec(Node node, int value) {
        if (node == null) return null;
        if (value < node.getValue()) node.setLeft(deleteRec(node.getLeft(), value));
        else if (value > node.getValue()) node.setRight(deleteRec(node.getRight(), value));
        else {
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();
            node.setValue(minValue(node.getRight()));
            node.setRight(deleteRec(node.getRight(), node.getValue()));
        }
        return node;
    }

    public int minValue(Node node) {
        int min = node.getValue();
        while (node.getLeft() != null) {
            min = node.getLeft().getValue();
            node = node.getLeft();
        }
        return min;
    }
}