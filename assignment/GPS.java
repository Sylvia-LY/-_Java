import java.util.Scanner;

public class GPS {
    public static void main(String[] args) {
        // 初始化
        String lastValidGPRMC = "";
        final String tag = "$GPRMC";
        Scanner in = new Scanner(System.in);
        String currentLine = in.nextLine();

        while ( !currentLine.equals("END") ) {
            // 如果当前行：1以正确tag开头
            if ( currentLine.startsWith(tag) ) {
                // 2没有warning
                boolean isOK = false;
                // 找到第二个逗号的index
                int comma2 = currentLine.indexOf(',', currentLine.indexOf(',')+1);
                if ( comma2!=-1 ) {
                    if ( currentLine.charAt(comma2+1)=='A' ) {
                        isOK = true;
                    }
                }

                // 3checksum也没错 -> 那么就进行替换
                // 没用到65536嗯嗯，反正我也不知道为什么
                if ( isOK ) {
                    int end = currentLine.lastIndexOf('*');
                    int checksum = Integer.parseInt(currentLine.substring(end+1), 16);

                    // 将$和*之间所有的字符的ASCII进行逐个xor运算
                    int calculatedChecksum = currentLine.charAt(1);
                    for ( int i=2; i<end; i++ ) {
                        calculatedChecksum^=currentLine.charAt(i);
                    }

                    if ( calculatedChecksum == checksum ) {
                        lastValidGPRMC = currentLine;
                    }

                }
            }

            currentLine = in.nextLine();
        }

        // 对timestamp进行一个输出
        if ( !lastValidGPRMC.isEmpty() ) {
            int h = Integer.parseInt(lastValidGPRMC.substring(7, 9));
            int min = Integer.parseInt(lastValidGPRMC.substring(9, 11));
            int s = Integer.parseInt(lastValidGPRMC.substring(11, 13));

            // utc -> beijing
            h+=8;
            h%=24;
            System.out.printf("%02d:%02d:%02d", h, min, s);
        }
    }
}
