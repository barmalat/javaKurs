public class App {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(7);
        stack.push(13);

        stack.printAll();

        System.out.println(stack.pop());

        stack.printAll();
    }
}
