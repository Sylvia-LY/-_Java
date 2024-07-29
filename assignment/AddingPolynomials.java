import java.util.Scanner;

public class AddingPolynomials {
    public static void main(String[] args) {
        int[] polynomial1 = new int[101];
        int[] polynomial2 = new int[101];
        int[] result = new int[101];
        Scanner in = new Scanner(System.in);
        readPolynomial(in, polynomial1);
        readPolynomial(in, polynomial2);


        for ( int i=0; i<=100; i++ ) {
            result[i] = polynomial1[i] + polynomial2[i];
        }

        String output = "";
        for ( int i=100; i>=0; i-- ) {
            int coefficient = result[i];

            // skip系数为0的项
            if ( coefficient==0 ) {
                continue;
            }

            // 负系数有符号，正的手动添加
            if ( coefficient>0 && !output.isEmpty() ) {
                output+="+";
            }

            // 0次幂=1，直接接上系数
            if ( i==0 ) {
                output+=coefficient;
            }
            // 并特殊处理1次幂
            else if ( i==1 ) {
                if ( coefficient==1 ) { output+="x"; }
                else if ( coefficient==-1 ) { output+="-x"; }
                else { output+=coefficient+"x"; }
            }
            // 普通
            else {
                if ( coefficient==1 ) { output+="x"+i; }
                else if ( coefficient==-1 ) { output+="-x"+i; }
                else { output+=coefficient+"x"+i; }
            }

        }

        if ( output.isEmpty() ) {
            output = "0";
        }

        System.out.println(output);
    }

    private static void readPolynomial(Scanner in, int[] p) {
        int exponent = 0;
        int coefficient = 0;
        do {
            exponent = in.nextInt();
            coefficient = in.nextInt();
            p[exponent] += coefficient;
        }
        while ( exponent!=0 );
    }
}


// 多项式加法（5分）
// 题目内容：
// 一个多项式可以表达为x的各次幂与系数乘积的和，比如：2x6+3x5+12x3+6x+20
// 现在，你的程序要读入两个多项式，然后输出这两个多项式的和，也就是把对应的幂上的系数相加然后输出。
// 程序要处理的幂最大为100。
// 输入格式：
// 总共要输入两个多项式，每个多项式的输入格式如下：
// 每行输入两个数字，第一个表示幂次，第二个表示该幂次的系数，所有的系数都是整数。第一行一定是最高幂，最后一行一定是0次幂。
// 注意第一行和最后一行之间不一定按照幂次降低顺序排列；如果某个幂次的系数为0，就不出现在输入数据中了；0次幂的系数为0时还是会出现在输入数据中。
// 输出格式：
// 从最高幂开始依次降到0幂，如：2x6+3x5+12x3-6x+20
// 注意其中的x是小写字母x，而且所有的符号之间都没有空格，如果某个幂的系数为0则不需要有那项。