import java.util.Scanner;


// 这个办法实际上就像是sieve of Eratosthenes反着用
// 因为我们从最小质数2开始 - n/2，如果可以，则n/2/2。。/2，直到剩下的数%2!=0，这一步实际上就像sieve of Eratosthenes最开始排除了所有2的倍数
// 这之后开始检查3，以此类推。所以虽然没有保证i是素数，但因为我们从最小素数开始除法，最后剩下的数字要么是1，要么是素数
// ps.检查素数只用得着检查到sqrt，这个方法里我们也只检查到sqrt
public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("=");

        if ( n>1 ) {
            for ( int i=2; i<=Math.sqrt(n); i++ ) {
                while ( n%i==0 ) {
                    sb.append(i).append("x");
                    n/=i;
                }
            }

            if ( n>1 ) {
                sb.append(n);
            }
            else {
                sb.setLength(sb.length()-1);
            }
        }

        System.out.println(sb.toString());

    }
}


// 分解质因数（5分）
// 题目内容：
// 每个非素数（合数）都可以写成几个素数（也可称为质数）相乘的形式，这几个素数就都叫做这个合数的质因数。比如，6可以被分解为2x3，而24可以被分解为2x2x2x3。
// 现在，你的程序要读入一个[2,100000]范围内的整数，然后输出它的质因数分解式；当读到的就是素数时，输出它本身。
// 输入格式：一个整数，范围在[2,100000]内。
// 输出格式：形如：n=axbxcxd或n=n。所有的符号之间都没有空格，x是小写字母x。