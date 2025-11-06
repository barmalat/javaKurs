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

    public boolean contain(int value) {
        if (root == null) {
            return false;
        } else return containRec(root, value);
    }

    public boolean containRec(Node node, int value) {
        if (value == node.getValue()) {
            return true;
        } else if ((value > node.getValue() && node.getRight() == null) || value < node.getValue() && node.getLeft() == null) {
            return false;
        } else if (value > node.getValue()) {
            return containRec(node.getRight(), value);
        } else return containRec(node.getLeft(), value);
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("Drzewo jest puste!");
        } else {
            inOrderRec(root);
        }
    }

    public void inOrderRec(Node node) {
        if (node.getLeft() != null) {
            inOrderRec(node.getLeft());
        }
        System.out.println(node.getValue());
        if (node.getRight() != null) {
            inOrderRec(node.getRight());
        }
    }
}