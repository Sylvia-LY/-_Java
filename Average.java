import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        double cnt = 0;
        int num = in.nextInt();

        while ( num > -1 ) {
            cnt++;
            sum += num;
            num = in.nextInt();
        }

        if ( cnt > 0 ) {
            System.out.println("Average="+sum/cnt);
        }
    }

}
