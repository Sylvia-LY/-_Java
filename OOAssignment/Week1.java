import java.util.Scanner;

public class Week1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

class Fraction {
    private int a;
    private int b;

    public Fraction(int a, int b) {
        this.a = a;
        this.b = b;
        // 创建的时候就化简，保证分数总是最简形式
        simplify();
    }

    public double toDouble() {
        return (double)a/b;
    }

    public Fraction plus(Fraction r) {
        return new Fraction(this.a*r.b+r.a*this.b, this.b*r.b);
    }

    public Fraction multiply(Fraction r) {
        return new Fraction(this.a*r.a, this.b*r.b);
    }

    public void print() {
        if ( a == b ) {
            System.out.println(1);
        }
        else if ( b == 1 ) {
            System.out.println(a);
        }
        else {
            System.out.println(a+"/"+b);
        }
    }

    private int gcd(int x, int y) {
        while ( y!=0 ) {
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }

    // 暂时没考虑符号问题喔。。不管了
    private void simplify() {
        int gcd = gcd(a, b);
        a/=gcd;
        b/=gcd;
    }
}