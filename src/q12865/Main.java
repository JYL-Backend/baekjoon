package q12865;

import java.util.Scanner;

public class Main {
    static int N,K;
    static int[] v,w;
    static int memo[][];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        v = new int[N];
        w = new int[N];
        memo = new int[N][K+1];

        for(int i=0; i<N; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }


        System.out.println(gogo(0,K));
    }

    private static int gogo(int n, int k) {
        if(n == N) return 0;

        if(memo[n][k] != 0) return memo[n][k];

        if(w[n] > k){
            return memo[n][k] = gogo(n+1,k);
        }

        return memo[n][k] = Math.max(v[n] + gogo(n+1,k-w[n]),gogo(n+1,k));
    }
}
