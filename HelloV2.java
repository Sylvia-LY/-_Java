import java.util.Scanner;

public class HelloV2 {
    public static void main(String[] args) {

        int foot;
        int inch;
        Scanner in = new Scanner(System.in);
        foot = in.nextInt();
        inch = in.nextInt();
        System.out.println((int)((foot+inch/12.0)*0.3048*100)+"cm");

        System.out.println(10/3);
        System.out.println(1.2-1.1);

    }
}
