package q11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = N = sc.nextInt();
        Integer[] list = new Integer[n];
        for(int i=0; i<n; i++){
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        int sum = 0;
        int lastW = 0;
        for(int w : list){
            lastW = w+lastW;
            sum+=lastW;

        }

        System.out.println(sum);
    }
}
