import javax.swing.*;
import java.awt.*;

// JPanel - Java图形库中用来表达一块画面
public class View extends JPanel {
    private static final long serialVersionUID = -5258995676212660595L;
    private static final int GRID_SIZE = 16;
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for ( int row=0; row<field.getHeight(); row++ ) {
            for ( int col=0; col<field.getWidth(); col++ ) {
                Cell cell = field.get(row, col);
                if ( cell!=null ) {
                    cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
                }
            }
        }
    }

    // 覆盖这个是告诉ui布局管理器view窗口的理想大小，+1确保边界线完整地显示
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(field.getWidth()*GRID_SIZE+1,
                field.getHeight()*GRID_SIZE+1);
    }
}
