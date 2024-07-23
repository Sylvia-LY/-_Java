import java.util.Arrays;
import java.util.Random;

// 这个井字棋游戏存在的问题：
// 一初始化出来 没有下棋的先后 可能x o都赢了。。
// 且现有的逻辑flow判断不了平局
public class TicTacToe {
    public static void main(String[] args) {
        final int SIZE = 3;
        Boolean[][] board = new Boolean[SIZE][SIZE];

        // 初始化
        initializeBoard(board);
        printBoard(board);

        // true代表先手x
        int num0fX = 0;
        // false代表o
        int num0fO = 0;
        // result - 有人获胜
        boolean gotResult = false;

        // 检查行
        for ( int i=0; i<SIZE; i++ ) {
            for ( int j=0; j<SIZE; j++ ) {
                if ( board[i][j] ) {
                    num0fX++;
                }
                else {
                    num0fO++;
                }
            }
            if ( num0fX==SIZE || num0fO==SIZE ) {
                gotResult = true;
                break;
            }
            else {
                num0fX = 0;
                num0fO = 0;
            }
        }

        // 检查列
        if ( !gotResult ) {
            for ( int j=0; j<SIZE; j++ ) {
                for ( int i=0; i<SIZE; i++ ) {
                    if ( board[i][j] ) {
                        num0fX++;
                    }
                    else {
                        num0fO++;
                    }
                }
                if ( num0fX==SIZE || num0fO==SIZE ) {
                    gotResult = true;
                    break;
                }
                else {
                    num0fX = 0;
                    num0fO = 0;
                }
            }
        }

        // 检查对角线
        if ( !gotResult ) {
            for ( int k=0; k<SIZE; k++ ) {
                if ( board[k][k] ) {
                    num0fX++;
                }
                else {
                    num0fO++;
                }
            }
            if ( num0fX==SIZE || num0fO==SIZE ) {
                gotResult = true;
            }
            else {
                num0fX = 0;
                num0fO = 0;
            }
        }

        if ( !gotResult ) {
            for ( int k=0; k<SIZE; k++ ) {
                if ( board[k][SIZE-k-1] ) {
                    num0fX++;
                }
                else {
                    num0fO++;
                }
            }
            if ( num0fX==SIZE || num0fO==SIZE ) {
                gotResult = true;
            }
            else {
                num0fX = 0;
                num0fO = 0;
            }
        }


        // 输出游戏结果
        if ( gotResult ) {
            if ( num0fX == SIZE ) {
                System.out.println("player x wins");
            }
            else {
                System.out.println("player o wins");
            }

        }
        else {
            System.out.println("no winner");
        }

    }

    // 初始化矩阵，如果size是奇数，则先手的x比o大一
    private static void initializeBoard(Boolean[][] b) {
        for ( Boolean[] row: b ) {
            Arrays.fill(row, false);
        }
        Random rand = new Random();
        int num0fX = 0;
        while ( num0fX < (b.length*b.length+1)/2 ) {
            int i = rand.nextInt(b.length);
            int j = rand.nextInt(b.length);
            if ( !b[i][j] ) {
                b[i][j] = true;
                num0fX++;
            }
        }
    }


    private static void printBoard(Boolean[][] b) {
        for ( Boolean[] row: b ) {
            for ( Boolean e: row ) {
                System.out.print(e ? "x ": "o ");
            }
            System.out.println();
        }
    }
}
