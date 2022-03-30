package q2206;

import java.util.Scanner;

public class Main {
    static char[][] board;
    static boolean isBreak = false;
    static int[][][] memo;
    static int N,M;
    static int MAXRESULT =10000001;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = N = sc.nextInt();
        int m = M = sc.nextInt();
        board = new char[n][m];
        memo = new int[n][m][2];

        for(int i=0; i<n; i++){
            String row = sc.next();
            for(int j=0; j<m; j++){
                board[i][j] = row.charAt(j);
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }


        gogo(0,0,1);

        memo[n-1][m-1][0] = memo[n-1][m-1][0] == -1 ? MAXRESULT : memo[n-1][m-1][0];
        memo[n-1][m-1][1] = memo[n-1][m-1][1] == -1 ? MAXRESULT : memo[n-1][m-1][1];
        int result = Math.min(memo[n-1][m-1][0],memo[n-1][m-1][1]);
        System.out.println(result==MAXRESULT ? -1 : result);
    }

    private static void gogo(int y, int x, int count) {
        if(y == -1 || x == -1) return;
        if(y == N || x == M) return;

        // 이미 방문했는데 더 돌아왔다
        if(memo[y][x][isBreak ? 1 : 0] != -1  && memo[y][x][isBreak ? 1 : 0] < count) return;

        // 현재가 빈공간이면 최신화
        if(board[y][x] == '0'){
            memo[y][x][isBreak?1:0] = count;
        }

        // 벽
        if(board[y][x] == '1'){
            // 이미 깬적있음
            if(isBreak) return;

            // 깬적없음
            isBreak = true;
            memo[y][x][isBreak?1:0] = count;
            gogo(y+1,x,count+1);
            gogo(y-1,x,count+1);
            gogo(y,x+1,count+1);
            gogo(y,x-1,count+1);
            isBreak = false;
            return;
        }
        // 벽아님
        gogo(y+1,x,count+1);
        gogo(y-1,x,count+1);
        gogo(y,x+1,count+1);
        gogo(y,x-1,count+1);
    }
}
