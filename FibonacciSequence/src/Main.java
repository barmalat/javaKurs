public class Main {
    public static void main(String[] args) {
        System.out.println("30: " + nTermOfTheFibonacciSequence(30));
    }

    public static long nTermOfTheFibonacciSequence(int n) {
        if (n==40){
            return 102334155;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return nTermOfTheFibonacciSequence(n - 1) + nTermOfTheFibonacciSequence(n - 2);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("5: " + nTermOfTheFibonacciSequence(BigInteger.valueOf(1)));
//    }
//
//    public static BigInteger nTermOfTheFibonacciSequence(BigInteger n) {
//        if (n.equals(1)) {
//            return BigInteger.valueOf(1);
//        }
//        if (n.equals(0)) {
//            return BigInteger.valueOf(0);
//        }
//        return nTermOfTheFibonacciSequence(n.subtract(BigInteger.valueOf(1))).add(nTermOfTheFibonacciSequence(n.subtract(BigInteger.valueOf(2))));
//    }
//}