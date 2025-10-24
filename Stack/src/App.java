public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<Point> stack3 = new Stack<>();

        stack.push(2);
        stack.push(3);
        stack.push(8);
        System.out.println("Wartość na head: " + stack.getHead().getValue());

        stack.printAll();

        System.out.println();
        stack.remove(2);
        stack.printAll();

        stack2.push("A");
        stack2.push("B");
        stack2.push("C");
        stack2.push("D");
        stack2.printAll();

        stack3.push(new Point(2,8));
        stack3.push(new Point(0,2));
        stack3.push(new Point(1,5));
        stack3.printAll();
    }
}