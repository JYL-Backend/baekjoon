package q1003;

import java.util.Scanner;

public class Main {
    static Result[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] inputs = new int[t];
        dp = new Result[41];
        for(int i=0; i<t; i++){
            inputs[i] = sc.nextInt();
        }
        for(int i=0; i<t; i++){
            Result result = gogo(inputs[i]);
            System.out.println(result.count0 + " " + result.count1);
        }
    }

    private static Result gogo(int n) {
        if(n == 0){
            Result r = new Result(1, 0);
            return r;
        }
        if(n == 1){
            Result r = new Result(0, 1);
            return r;
        }
        if(n < 0){
            return new Result(0,0);
        }
        if(dp[n] != null) return dp[n];
        return dp[n] = gogo(n-1).plus(gogo(n-2));
    }

    static class Result {
        public int count0;
        public int count1;

        public Result(int a, int b){
            count0 = a;
            count1 = b;
        }

        public Result plus(Result r){
            return new Result(this.count0+r.count0, this.count1+r.count1);
        }
    }
}
