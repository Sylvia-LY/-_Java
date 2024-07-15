import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner in = new Scanner(System.in);
//        System.out.println("echo: " + in.nextLine());

        final int amount = 100;
        int price = in.nextInt();
        System.out.println(amount+"-"+price+"="+(amount-price));

    }
}
