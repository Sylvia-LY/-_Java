import java.awt.*;

public class Rabbit extends Animal implements Cell {

    public Rabbit() {
        super(10, 2);
    }

    @Override
    public Animal breed() {
        Animal ret = null;
        if ( canBreed() && Math.random()<0.12 ) {
            ret = new Rabbit();
        }
        return ret;
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        int a = (int)((1-getAgePercentage())*255);
        g.setColor(new Color(255, 0, 0, a));
        g.fillRect(x, y, size, size);

    }

    @Override
    public String toString() {
        return "Rabbit: "+super.toString();
    }
}
