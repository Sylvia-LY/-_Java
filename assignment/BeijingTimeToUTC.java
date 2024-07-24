import java.util.Scanner;

public class BeijingTimeToUTC {
    public static void main(String[] args) {
        // 初始化
        Scanner in = new Scanner(System.in);
        int UTC = 0;
        int BJT = in.nextInt();

        // 检查输入合法性
        if ( BJT>=0 && BJT<=2359) {

            // 有效范围不能简单地是0 - 2359，这包括了输入的个位和十位（minutes分）大于59的情况。。。
            // 这一步normalize the time，把overflow的分加进小时
            int hours = BJT/100;
            int minutes = BJT%100;

            if ( minutes>=60 ) {
                hours++;
                minutes %= 60;
            }
            // 如果小时溢出 把她转换回24小时制
            hours %= 24;

            // 终于可以计算UTC
            if ( hours < 8 ) {
                hours = 24 + hours - 8;

            }
            else {
                hours = hours - 8;
            }
            UTC = hours*100+minutes;
        }

        // 输出
        System.out.println(UTC);
    }
}

// 时间换算（5分）
// 题目内容：
// UTC是世界协调时，BJT是北京时间，UTC时间相当于BJT减去8。现在，你的程序要读入一个整数，表示BJT的时和分。整数的个位和十位表示分，百位和千位表示小时。
// 如果小时小于10，则没有千位部分；如果小时是0，则没有百位部分；如果分小于10分，需要保留十位上的0。
// 如1124表示11点24分，而905表示9点5分，36表示0点36分，7表示0点7分。
// 有效的输入范围是0到2359，即你的程序不可能从测试服务器读到0到2359以外的输入数据。
// 你的程序要输出这个时间对应的UTC时间，输出的格式和输入的相同，即输出一个整数，表示UTC的时和分。
// 整数的个位和十位表示分，百位和千位表示小时。如果小时小于10，则没有千位部分；如果小时是0，则没有百位部分；如果分小于10分，需要保留十位上的0。
// 提醒：要小心跨日的换算。
