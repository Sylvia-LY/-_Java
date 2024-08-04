import java.util.ArrayList;

// 维持好cell的二维数组
// 任务：放入cell，返回某位置的cell或cell的邻居们，清空
public class Field {

    // 列
    private int width;
    // 行
    private int height;
    private Cell[][] field;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Cell[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void place(int row, int col, Cell cell) {
        field[row][col] = cell;
    }

    public Cell get(int row, int col) {
        return field[row][col];
    }

    public Cell[] getAllNeighbours(int myRow, int myCol) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        // i、j是行列偏移量offset
        for ( int i=-1; i<2; i++ ) {
            for ( int j=-1; j<2; j++ ) {
                // 构成所有邻居的行列号
                int row = myRow+i;
                int col = myCol+j;
                // 检查邻居是否在边界内 且不是自己
                if ( row>-1 && row<height && col>-1 && col<width
                        && !(row==myRow && col==myCol) ) {
                    neighbours.add(field[row][col]);
                }
            }
        }
        return neighbours.toArray(new Cell[neighbours.size()]);

    }

    public void clear() {
        for ( int i=0; i<height; i++ ) {
            for ( int j=0; j<width; j++ ) {
                field[i][j] = null;
            }
        }
    }
}
