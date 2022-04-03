package q2156;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] board;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = N = sc.nextInt();
        dp = new int[n][2];
        board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextInt();
        }
        gogo(0,0);

        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }

    private static int gogo(int n, int count) {
        if(count == 2) return 0;
        if(n >= N) return 0;
        if(dp[n][count] != 0) return dp[n][count];

        dp[n][count] = Math.max(board[n]+gogo(n+1,count+1), gogo(n+1,0));

        System.out.println("dp["+n+"]["+count+"] = " + dp[n][count]);
        return dp[n][count];
    }
}
