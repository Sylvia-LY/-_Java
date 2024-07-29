import java.util.Scanner;

public class PerfectNumber {

    private static boolean isPerfectNumber(int n) {
        int sum = 0;
        // 因为不包括itself，其她因子必小于等于她的1/2
        for ( int i=1; i<=n/2; i++ ) {
            if ( n%i==0 ) {
                sum+=i;
            }
        }
        return sum==n;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String result = "";

        if ( n>0 && m>n ) {
            for ( int i=n; i<=m; i++ ) {
                if ( isPerfectNumber(i) ) {
                    result+=i+" ";
                }
            }
        }

        if ( result.isEmpty() ) {
            System.out.println();
        }
        else {
            result = result.trim();
            System.out.println(result);
        }

    }
}


// 完数（5分）
// 题目内容：
// 一个正整数的因子是所有可以整除它的正整数。而一个数如果恰好等于除它本身外的因子之和，这个数就称为完数。例如6=1＋2＋3（6的因子是1,2,3）。
// 现在，你要写一个程序，读入两个正整数n和m（1<=n<m<1000），输出[n,m]范围内所有的完数。
// 提示：可以写一个函数来判断某个数是否是完数。
// 输入格式：两个正整数，以空格分隔。
// 输出格式：其间所有的完数，以空格分隔，最后一个数字后面没有空格。如果没有，则输出一个空行。
