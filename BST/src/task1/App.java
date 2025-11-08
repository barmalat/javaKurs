package task1;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        System.out.println(tree.contains(5));

        tree.inOrder();
    }
}