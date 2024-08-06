import java.util.ArrayList;

public abstract class Animal {
    private int lifespan;
    private int breedingAge;
    private int age;
    private boolean isAlive = true;

    public Animal(int lifespan, int breedingAge) {
        this.lifespan = lifespan;
        this.breedingAge = breedingAge;
    }

    protected int getAge() {
        return age;
    }

    protected double getAgePercentage() {
        return (double)age/lifespan;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean canBreed() {
        return age>breedingAge;
    }

    protected void addAge(int years) {
        lifespan+=years;
    }

    public void grow() {
        age++;
        if ( age>lifespan ) {
            die();
        }
    }

    private void die() {
        isAlive = false;
    }

    public Location move(Location[] freeAdj) {
        Location ret = null;
        if ( freeAdj.length>0 && Math.random()<0.02 ) {
            // 生成一个介于0和length-1之间的随机整数
            // 也就是说，随机的空闲邻居位
            ret = freeAdj[(int)(Math.random()*freeAdj.length)];
        }
        return ret;
    }

    public abstract Animal breed();

    public Animal hunt(ArrayList<Animal> neighbour) {
        return null;
    }


    @Override
    public String toString() {
        return age+":"+(isAlive?"alive": "dead");
    }
}
