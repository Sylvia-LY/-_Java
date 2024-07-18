import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 范围：100以内的一个正整数
        // random是[0,1) -> *100变成[0,100) -> +1变成[1,100]

        int target = 1 + (int)(Math.random()*100);
        int guess;
        int cnt = 0;

        do {
            System.out.println("take a guess: ");
            guess = in.nextInt();
            cnt++;

            if ( guess < target ) {
                System.out.println("your guess is less than the target number");
            }
            else if ( guess > target ) {
                System.out.println("your guess is greater than the target number");

            }

        } while ( guess != target );

        System.out.println("congratulations, you won!");
        System.out.println("you guessed the number in "+cnt+" attempts");

    }
}
