import java.awt.*;
import java.util.ArrayList;

public class Fox extends Animal implements Cell {

    public Fox() {
        super(20, 4);
    }

    @Override
    public Animal breed() {
        Animal ret = null;
        if ( canBreed() && Math.random()<0.05 ) {
            ret = new Fox();
        }
        return ret;
    }

    // 在指定位置上绘制狐狸，根据年龄调整透明度
    @Override
    public void draw(Graphics g, int x, int y, int size) {
        // params：红，绿，蓝，透明度
        int a = (int)((1-getAgePercentage())*255);
        g.setColor(new Color(0, 0, 0, a));
        g.fillRect(x, y, size, size);
    }

    @Override
    public Animal hunt(ArrayList<Animal> neighbour) {
        Animal ret = null;
        if ( Math.random()<0.2 ) {
            ret = neighbour.get((int)(Math.random()*neighbour.size()));
            addAge(2);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Fox: "+super.toString();
    }
}
