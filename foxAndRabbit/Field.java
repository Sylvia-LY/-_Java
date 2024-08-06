import java.util.ArrayList;

public class Field {
    private int width;
    private int height;
    private Cell[][] field;
    private static final Location[] adj = {
        new Location(-1, -1), new Location(-1, 0), new Location(-1, 1),
        new Location(0, -1), new Location(0, 0), new Location(0, 1),
        new Location(1, -1), new Location(1, 0), new Location(1, 1),
    };

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
        for ( int i=-1; i<2; i++ ) {
            for ( int j=-1; j<2; j++ ) {
                int row = myRow+i;
                int col = myCol+j;
                if ( row>-1 && col>-1 && row<height && col<width
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
                field[i][j]=null;
            }
        }
    }

    public Location[] getFreeNeighbours(int myRow, int myCol) {
        ArrayList<Location> freeNeighbours = new ArrayList<>();
        for ( Location loc: adj ) {
            int row = myRow + loc.getRow();
            int col = myCol + loc.getCol();
            if ( row>-1 && col>-1 && row<height && col<width
                    && field[row][col]==null ) {
                freeNeighbours.add(new Location(row, col));
            }
        }
        return freeNeighbours.toArray(new Location[freeNeighbours.size()]);
    }


    public void move(int row, int col, Location loc) {
        field[loc.getRow()][loc.getCol()] = field[row][col];
        remove(row, col);
    }

    public void remove(int row, int col) {
        field[row][col] = null;
    }

    public void remove(Cell prey) {
        for ( int row=0; row<height; row++ ) {
            for ( int col=0; col<width; col++ ) {
                if ( prey==field[row][col] ) {
                    field[row][col]=null;
                    break;
                }
            }
        }
    }

    public void placeToRandomAdj(int row, int col, Cell cell) {
        Location[] freeAdj = getFreeNeighbours(row, col);
        if ( freeAdj.length>0 ) {
            int index = (int)(Math.random()* freeAdj.length);
            field[freeAdj[index].getRow()][freeAdj[index].getCol()] = cell;
        }
    }

}