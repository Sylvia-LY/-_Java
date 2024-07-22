import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {
        // 存在安全隐患 - 数组下标越界
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int cnt = 0;
        int number = in.nextInt();
        int[] numbers = new int[100];

        while ( number >= 0 ) {
            numbers[cnt] = number;
            cnt++;
            sum += number;
            number = in.nextInt();
        }

        if ( cnt > 0 ) {
            double average = sum/cnt;
            System.out.println("Average="+average);
            for (int n: numbers) {
                if ( n > average ) {
                    System.out.println(n);
                }

            }
        }

    }
}
