public class CascadedIf {

    public static void main(String[] args) {
        double f, x = 0;
        if ( x < 0 ) {
            f = -1;
        }
        else if ( x == 0 ) {
            f = 0;

        }
        else {
            f = 2 * x;
        }

        System.out.println("x="+x+", f="+f);
    }
}
