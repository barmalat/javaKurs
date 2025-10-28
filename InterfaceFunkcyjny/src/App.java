public class App {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("Nie można dzielić przez 0!");
            }
            return a / b;
        };
        calculate(6,0,divide);
    }

    public static void calculate(int a, int b, MathOperation operation){
        System.out.println("Wynik działania: ");
        System.out.println(operation.operate(a, b));
    }
}
