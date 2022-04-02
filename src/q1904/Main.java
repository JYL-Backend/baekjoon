package q1904;

import java.util.Scanner;

public class Main {
    static int dp[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        for(int i=0; i<=n;i++){
            dp[i] = -1;
        }

        System.out.println(gogo(n));
    }

    private static int gogo(int n) {
        if(n == 0) return 1;
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (gogo(n-1)+gogo(n-2))%15746;
    }
}
