package q2239;

import java.util.Scanner;

public class Main {
    static boolean[][] checkRow = new boolean[9][10];
    static boolean[][] checkCol = new boolean[9][10];
    static boolean[][][] checkBox = new boolean[3][3][10];
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];

        for(int i=0; i<9; i++){
            String str = sc.next();
            for(int j=0; j<9; j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        // 체크
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == 0) continue;
                int now = board[i][j];
                checkRow[i][now]= true;
                checkCol[j][now]= true;
                checkBox[i/3][j/3][now] = true;
            }
        }

        gogo(0, 0);
    }

    private static boolean gogo( int y, int x) {
        //최종 결과
        if(y == 9) {
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(board[i][j]);
                }
                if(i == 8) return true;
                System.out.println("");
            }
        }
        // 마지막 열 넘음
        if(x == 9){
            return gogo(y+1, 0);
        }

        int nowInt = board[y][x];

        // 현재 보드가 0이 아님
        if(nowInt != 0) return gogo(y,x+1);

        // 0이면 순회를 시작해봅시다
        for(int i=1; i<10; i++){
            // 넣을 수 없는 숫자들은 패스
            if(checkCol[x][i]) continue;
            if(checkRow[y][i]) continue;
            if(checkBox[y/3][x/3][i]) continue;

            // 넣을 수 있는 숫자면 체크하고 재귀호출
            checkCol[x][i] = true;
            checkRow[y][i] = true;
            checkBox[y/3][x/3][i] = true;
            board[y][x] = i;

            // 이숫자로 답찾으며 탐색중지
            if(gogo(y,x+1)) return true;

            // 답이 없으면 체크해제
            board[y][x] = nowInt;
            checkCol[x][i] = false;
            checkRow[y][i] = false;
            checkBox[y/3][x/3][i] = false;
        }
        // 답 못찾음
        return false;
    }
}
