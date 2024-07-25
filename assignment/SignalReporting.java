import java.util.Scanner;

public class SignalReporting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if ( n<11 || n>59 || n%10 == 0 ) {
            System.out.println("invalid input");
        }
        else {
            int readability = n / 10;
            int strength = n % 10;

            String result1 = switch ( strength ) {
                case 1 -> "Faint signals, barely perceptible";
                case 2 -> "Very weak signals";
                case 3 -> "Weak signals";
                case 4 -> "Fair signals";
                case 5 -> "Fairly good signals";
                case 6 -> "Good signals";
                case 7 -> "Moderately strong signals";
                case 8 -> "Strong signals";
                case 9 -> "Extremely strong signals";
                default -> "";
            };

            String result2 = switch ( readability ) {
                case 1 -> "Unreadable";
                case 2 -> "Barely readable, occasional words distinguishable";
                case 3 -> "Readable with considerable difficulty";
                case 4 -> "Readable with practically no difficulty";
                case 5 -> "Perfectly readable";
                default -> "";
            };

            System.out.println(result1 + ", " + result2.toLowerCase() + ".");
        }
    }
}


// 信号报告（5分）