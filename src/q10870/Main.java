package q10870;

import java.util.Scanner;

public class Main {
    static int memo[] = new int[21];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i< memo.length; i++){
            memo[i] = -1;
        }

        System.out.println(fib(n));

    }
    public static int fib(int n){
        if(n == 0 || n== 1) return n;
        return memo[n] = memo[n] != -1 ? memo[n] :  fib(n-1) + fib(n-2);
    }
}
