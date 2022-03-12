package q1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = x < w-x ? x : w-x;
        min = min < y ? min : y;
        min = min < h-y ? min : h-y;
        System.out.println(min);
    }
}
