public class Sum {
    private static void sum(int a, int b) {
        int sum = 0;
        for ( int i = a; i <= b; i++ ) {
            sum += i;
        }
        System.out.println(a+"到"+b+"的和是"+sum);
    }

    public static void main(String[] args) {
        sum(1, 10);
        sum(20, 30);
        sum(35, 45);

    }
}
