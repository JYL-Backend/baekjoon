package q2579;

import java.util.Scanner;

public class Main {
    static int[] board;
    static int N;
    static int dp[][];
    static int FAULT = -10000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = N = sc.nextInt();
        dp = new int[n][2];
        board = new int[n];
        for(int i=0; i<n; i++){
            board[i] = sc.nextInt();
        }

        System.out.println(Math.max(gogo(0,0),gogo(1,0)));
    }

    private static int gogo(int n, int count) {
        if(count == 2) return FAULT;
        if(n >= N) return FAULT;

        if(n == N-1) return board[n];

        if(dp[n][count] != 0) return dp[n][count];

        return dp[n][count] = Math.max(board[n]+gogo(n+1, count+1),board[n]+gogo(n+2, 0));
    }
}
