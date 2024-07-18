import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long result = 1;

        if ( num >= 0 ) {
            for (int i = 1; i <= num; i++) {
                result *= i;

            }
            System.out.println("factorial of "+num+" = "+result);
        }

    }
}
