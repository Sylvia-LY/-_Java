public class Display {
    private int value = 0;
    private int upperLimit = 0;

    public Display(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void increase() {
        value++;
        if ( value==upperLimit ) {
            value=0;
        }
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {

    }
}
