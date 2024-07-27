import java.util.Scanner;

public class IntegerToPinyin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String result = "";
        String prefix = "";

        if ( n<0 ) {
            prefix += "fu ";
            n = Math.abs(n);
        }

        do {
            int digit = n%10;
            n/=10;

            switch ( digit ) {
                case 0:
                    result = "ling "+result;
                    break;
                case 1:
                    result = "yi "+result;
                    break;
                case 2:
                    result = "er "+result;
                    break;
                case 3:
                    result = "san "+result;
                    break;
                case 4:
                    result = "si "+result;
                    break;
                case 5:
                    result = "wu "+result;
                    break;
                case 6:
                    result = "liu "+result;
                    break;
                case 7:
                    result = "qi "+result;
                    break;
                case 8:
                    result = "ba "+result;
                    break;
                case 9:
                    result = "jiu "+result;
                    break;
            }

        }
        while ( n>0 );

        System.out.println(prefix+result.trim());
    }
}


// 念整数（5分）
// 题目内容：
// 你的程序要读入一个整数，范围是[-100000,100000]。然后，用汉语拼音将这个整数的每一位输出出来。
// 如输入1234，则输出：yi er san si
// 注意，每个字的拼音之间有一个空格，但是最后的字后面没有空格。
// 当遇到负数时，在输出的开头加上“fu”，如-2341输出为：fu er san si yi