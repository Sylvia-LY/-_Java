import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] data = {3, 2, 5, 7, 4, 9, 11, 34, 12, 28};
        int x = in.nextInt();
        int loc = -1;
        for ( int i = 0; i < data.length; i++ ) {
            if ( data[i] == x ) {
                loc = i;
                break;
            }
        }
        if ( loc >= 0 ) {
            System.out.println(x+"是第"+(loc+1)+"个");
        }
        else {
            System.out.println(x+"不在其中");

        }
    }
}
