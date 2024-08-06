import javax.swing.*;
import java.util.ArrayList;

public class FoxAndRabbit {

    private Field field;
    private View view;

    public FoxAndRabbit(int size) {
        field = new Field(size, size);
        for ( int row=0; row<field.getHeight(); row++ ) {
            for ( int col=0; col<field.getWidth(); col++ ) {
                double p = Math.random();
                if ( p<0.05 ) {
                    field.place(row, col, new Fox());
                }
                else if ( p<0.15 ) {
                    field.place(row, col, new Rabbit());
                }
            }
        }
        view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("fox and rabbit");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
    }

    public void step() {
        for ( int row=0; row<field.getHeight(); row++ ) {
            for ( int col=0; col<field.getWidth(); col++ ) {
                Cell cell = field.get(row, col);
                if ( cell!=null ) {
                    Animal animal = (Animal)cell;
                    animal.grow();
                    if ( animal.isAlive() ) {
                        // move
                        Location loc = animal.move(field.getFreeNeighbours(row, col));
                        if ( loc!=null ) {
                            field.move(row, col, loc);
                        }

                        // hunt
                        if ( animal instanceof Fox ) {
                            Cell[] allNeighbours = field.getAllNeighbours(row, col);
                            ArrayList<Animal> rabbits = new ArrayList<>();
                            for ( Cell neighbour: allNeighbours ) {
                                if ( neighbour instanceof Rabbit ) {
                                    rabbits.add((Rabbit)neighbour);
                                }
                            }
                            if ( !rabbits.isEmpty() ) {
                                Animal prey = animal.hunt(rabbits);
                                if ( prey!=null ) {
                                    field.remove((Cell)prey);
                                }
                            }
                        }

                        // bread
                        Animal baby = animal.breed();
                        if ( baby!=null ) {
                            field.placeToRandomAdj(row, col, (Cell)baby);
                        }
                    }
                    else {
                        field.remove(row, col);
                    }
                }
            }
        }

    }

    public void start(int steps) {
        for ( int i=0; i<steps; i++ ) {
            step();
            view.repaint();
            try {
                Thread.sleep(200);
            }
            catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(40);
        fnr.start(200);
    }
}
