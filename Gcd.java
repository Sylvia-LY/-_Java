import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 枚举的方案
        int a = in.nextInt();
        int b = in.nextInt();
        int gcd = 1;

        for ( int i = 2; i<=a && i<=b; i++ ) {
            if ( a % i == 0 && b % i == 0 ) {
                gcd = i;
            }
        }
        System.out.println(a+"和"+b+"的最大公约数是"+gcd);
    }
}
