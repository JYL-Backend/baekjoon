package q10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fac(n));
    }
    static public int fac(int n){
        if(n == 1 || n == 0) return 1;
        return n * fac(n-1);
    }
}
