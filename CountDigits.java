import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int cnt = 0;

        do {
            num /= 10;
            ++cnt;

        } while ( num > 0 );

        System.out.println("number of digits: "+cnt);

    }
}
