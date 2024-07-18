import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("original number: ");
        int num = in.nextInt();
        int reversed = 0;

        while ( num > 0 ) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        System.out.println(reversed);

    }
}
