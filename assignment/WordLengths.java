import java.util.Scanner;

public class WordLengths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        String output = "";

        sentence = sentence.trim();
        if ( sentence.endsWith(".") ) {
            sentence = sentence.substring(0, sentence.length()-1);
        }

        // \s正则空白字符匹配符，\\是Java转义，+是一个或更多
        String[] words = sentence.split("\\s+");
        for ( String word: words ) {
            output+=word.length()+" ";
        }
        output = output.trim();

        System.out.println(output);


    }
}


// 单词长度（5分）
// 题目内容：
// 你的程序要读入一行文本，其中以空格分隔为若干个单词，以‘.’结束。你要输出这行文本中每个单词的长度。
// 这里的单词与语言无关，可以包括各种符号，比如“it's”算一个单词，长度为4。注意，行中可能出现连续的空格。
// 输入格式：输入在一行中给出一行文本，以‘.’结束，结尾的句号不能计算在最后一个单词的长度内。
// 输出格式：在一行中输出这行文本对应的单词的长度，每个长度之间以空格隔开，行末没有最后的空格。