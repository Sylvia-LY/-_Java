import java.util.Scanner;

public class VoteCounting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[10];
        int n = in.nextInt();

        while ( n > -1 ) {
            if ( n >= 0 && n <= 9 ) {
                numbers[n]++;
            }

            n = in.nextInt();
        }

        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.println(i+":"+numbers[i]);

        }
    }
}
