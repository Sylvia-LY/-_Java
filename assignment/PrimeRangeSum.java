import java.util.Scanner;


// 虽然用sieve of Eratosthenes高效得多。。。但是暂时不想继续改了
public class PrimeRangeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;

        if ( n<=0 || m<=0 || n>m ) {
            System.out.println("invalid input");
        }
        else {
            MAIN_LOOP:
            for ( int i=n; i<=m; i++ ) {
                if ( i<=1 ) {
                    continue MAIN_LOOP;
                }
                else if ( i==2 ) {
                    sum+=i;
                }
                else if ( i%2==0 ) {
                    continue MAIN_LOOP;
                }
                else {
                    for ( int j=3; j<=Math.sqrt(i); j+=2 ) {
                        if ( i%j==0 ) {
                            continue MAIN_LOOP;
                        }
                    }
                    sum+=i;
                }
            }

        }

        System.out.println(sum);
    }
}


// 素数和（5分）
// 题目内容：
// 我们认为2是第一个素数，3是第二个素数，5是第三个素数，依次类推。
// 现在，给定两个整数n和m，0<n<=m<=200，你的程序要计算第n个素数到第m个素数之间所有的素数的和，包括第n个素数和第m个素数。
// 注意，是第n个素数到第m个素数之间的所有的素数，并不是n和m之间的所有的素数。
// 输入格式：两个整数，第一个表示n，第二个表示m。
// 输出格式：一个整数，表示第n个素数到第m个素数之间所有的素数的和，包括第n个素数和第m个素数。