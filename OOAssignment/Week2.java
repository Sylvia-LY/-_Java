import java.util.Scanner;

// 尝试了5.3 封装这一节课里的实现方式。。不过没有完整代码对比不了耶
public class Week2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();

    }
}

class Display {
    private int value;
    private int upperLimit;

    public Display(int value, int upperLimit) {
        this.value = value;
        this.upperLimit = upperLimit;
    }

    public int getValue() {
        return value;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increase() {
        value++;
    }
}


class Clock {
    private Display hour;
    private Display minute;
    private Display second;

    public Clock(int h, int min, int s) {
        int newS = s%60;
        int carryMin = s/60;

        int newMin = (min+carryMin)%60;
        int carryH = (min+carryMin)/60;

        int newH = (h+carryH)%24;

        hour = new Display(newH, 24);
        minute = new Display(newMin, 60);
        second = new Display(newS, 60);
    }

    public void tick() {
        second.increase();
        if ( second.getValue() == second.getUpperLimit() ) {
            second.setValue(0);
            minute.increase();
            if ( minute.getValue() == minute.getUpperLimit() ) {
                minute.setValue(0);
                hour.increase();
                if ( hour.getValue() == hour.getUpperLimit() ) {
                    hour.setValue(0);
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour.getValue(), minute.getValue(), second.getValue());
    }
}