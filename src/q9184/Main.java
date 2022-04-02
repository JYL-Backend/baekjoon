package q9184;

import java.util.Scanner;

public class Main {
    static int[][][] memo;
    public static void main(String[] args){
        memo = new int[21][21][21];
        for(int a=0; a<=20; a++){
            for(int b=0; b<=20; b++){
                for(int c=0; c<=20; c++){
                    memo[a][b][c] = -1;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            int a= sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            System.out.println("w("+a+", "+b+", "+c+") = " + w(a,b,c));
        }
    }
    static public int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        if(a>20 ||b>20 ||c>20){
            return w(20,20,20);
        }
        if(memo[a][b][c] != -1) return memo[a][b][c];
        if(a<b && b<c){
            return memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        return memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
