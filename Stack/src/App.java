public class App {
    public static void main(String[] args) {
        Stack stack = new Stack();


        stack.push(2);
        stack.push(3);
        stack.push(8);
        System.out.println("Wartość na head: " + stack.getHead().getValue());

        stack.printAll();

        System.out.println();
        stack.remove(2);
        stack.printAll();
    }
}
