package q1937;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] board;
    static int[][] memo;
    static int max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
         board = new int[N][N];
         memo = new int[N][N];

         for(int i=0; i<N; i++){
             for(int j=0; j<N; j++){
                 board[i][j] = sc.nextInt();
             }
         }


         int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result = Math.max(result,visit(i,j));
            }
        }

        System.out.println(result);
    }

    private static int visit(int y, int x) {
        if(memo[y][x] != 0) return memo[y][x];

        int result = 0;
        if(x-1>=0 && board[y][x-1]> board[y][x]){
            result = Math.max(result,visit(y,x-1));
        }
        if(x+1<N && board[y][x+1]> board[y][x]) {
            result = Math.max(result,visit(y,x+1));
        }
        if(y-1>=0 && board[y-1][x]> board[y][x]) {
            result = Math.max(result,visit(y-1,x));
        }
        if(y+1<N && board[y+1][x]> board[y][x]) {
            result = Math.max(result,visit(y+1,x));
        }
        return memo[y][x] = result+1;
    }
}
