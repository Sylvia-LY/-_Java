import java.util.Scanner;

public class GcdEuclidean {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        String ret = a+"和"+b;

        while ( b > 0 ) {
            int r = a%b;
            a = b;
            b = r;

        }
        System.out.println(ret+"的最大公约数是"+a);
    }
}
