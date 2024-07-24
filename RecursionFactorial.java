public class RecursionFactorial {
    public static void main(String[] args) {
        int k = factorial(3);
        System.out.println(k);

    }

    private static int factorial(int n) {
        if ( n==1 ) {
            return n;
        }
        return n * factorial(n-1);
    }
}
