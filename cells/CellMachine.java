import javax.swing.*;

// 入口
public class CellMachine {
    public static void main(String[] args) {
        // 准备数据 初始化field网格 放入cells
        Field field = new Field(30, 30);
        for ( int row=0; row<field.getHeight(); row++ ) {
            for ( int col=0; col< field.getWidth(); col++ ) {
                field.place(row, col, new Cell());
            }
        }
        // 让其中1/5的细胞活过来
        for ( int row=0; row<field.getHeight(); row++ ) {
            for ( int col=0; col< field.getWidth(); col++ ) {
                Cell cell = field.get(row, col);
                // random返回0 - 1之间的一个随机数
                if ( Math.random()<0.2 ) {
                    cell.reborn();
                }
            }
        }


        View view = new View(field);
        // 一个图形窗口
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("cell machine");
        frame.add(view);
        // 根据frame内所有组件的getPreferredSize来调整自身的大小
        frame.pack();
        frame.setVisible(true);



        for ( int i=0; i<500; i++ ) {
            for ( int row=0; row<field.getHeight(); row++ ) {
                for ( int col=0; col<field.getWidth(); col++ ) {
                    Cell cell = field.get(row, col);
                    Cell[] neighbours = field.getAllNeighbours(row, col);
                    int aliveCount = 0;
                    for ( Cell neighbour: neighbours ) {
                        if ( neighbour.isAlive() ) {
                            aliveCount++;
                        }
                    }

                    System.out.print("["+row+"]["+col+"]");
                    System.out.print(cell.isAlive()?"alive": "dead");
                    System.out.print(":"+aliveCount+"-->");
                    if ( cell.isAlive() ) {
                        if ( aliveCount<2||aliveCount>3 ) {
                            cell.die();
                            System.out.print("die");
                        }
                    }
                    else if ( aliveCount==3 ) {
                        cell.reborn();
                        System.out.print("reborn");
                    }
                    System.out.println();

                }
            }
            System.out.println("UPDATE");
            // 在前面做了一轮二重循环 把整个field都扫描了一遍
            // 每一个cell都决定了她要死要活 更新好了
            frame.repaint();
            try {
                Thread.sleep(200);
            }
            catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

    }
}
