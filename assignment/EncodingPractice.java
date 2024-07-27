import java.util.Scanner;

public class EncodingPractice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int result = 0;
        int position = 1;
        int powerOfTwo = 1;

        // 输入合法性
        if ( n>=0 ) {
            while ( n>0 ) {
                int digit = n%10;
                if ( digit%2 == position%2 ) {
                    result += powerOfTwo;
                }
                n/=10;
                // 为二进制更新二的下一次幂
                powerOfTwo*=2;
                position++;
            }
        }
        System.out.println(result);
    }
}


// 数字特征值（5分）
// 题目内容：
// 对数字求特征值是常用的编码算法，奇偶特征是一种简单的特征值。对于一个整数，从个位开始对每一位数字编号，个位是1号，十位是2号，以此类推。
// 这个整数在第n位上的数字记作x，如果x和n的奇偶性相同，则记下一个1，否则记下一个0。
// 按照整数的顺序把对应位的表示奇偶性的0和1都记录下来，就形成了一个二进制数字。比如，对于342315，这个二进制数字就是001101。
// 按照二进制位值将1的位的位值加起来就得到了结果13。
// 你的程序要读入一个非负整数，整数的范围是[0,100000]，然后按照上述算法计算出表示奇偶性的那个二进制数字，输出它对应的十进制值。
// 提示：将整数从右向左分解，数位每次加1，而二进制值每次乘2。