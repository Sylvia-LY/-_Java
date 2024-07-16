import java.util.Scanner;

public class Ticket {
    public static void main(String[] args) {
        // initialization
        Scanner in = new Scanner(System.in);
        int balance = 0;

        while (true) {
            // prompt user to enter amount paid
            System.out.println("insert coins please: ");
            int amount = in.nextInt();
            balance += amount;

            if (balance >= 10) {
                // print the ticket itself
                System.out.println("****************");
                System.out.println("*Java城际铁路专线 *");
                System.out.println("*  无指定座位票   *");
                System.out.println("*  票价：10元    *");
                System.out.println("****************");

                // calculate and print the change
                System.out.println("here's your change: ￥" + (balance - 10));
                balance = 0;

            }

        }
    }
}
