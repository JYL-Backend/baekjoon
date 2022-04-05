package q2629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static boolean[][] memo;
    static boolean[][] visited;
    static int[] chuArr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int chuCount = sc.nextInt();
        chuArr = new int[chuCount];

        for(int i=0; i<chuCount; i++){
            chuArr[i] = sc.nextInt();
        }

        int marbleCount = sc.nextInt();
        int[] marbleArr = new int[marbleCount];

        for(int i=0; i<marbleCount; i++){
            marbleArr[i] = sc.nextInt();
        }

         memo = new boolean[chuCount][15001];
         visited = new boolean[chuCount][15001];

        String[] resultArr = new String[marbleCount];
        for(int i=0; i<marbleCount ; i++){
            int marble = marbleArr[i];
            resultArr[i] = gogo(0,marble) ? "Y" : "N";
        }
        System.out.println(String.join(" ",resultArr));
    }

    private static boolean gogo(int index, int weight) {
        if(weight == 0) return true;
        if(weight < 0) weight = Math.abs(weight);
        if(index == chuArr.length) return false;
        if (weight > 15000) return false;
        if(visited[index][weight]) return memo[index][weight];

        visited[index][weight] = true;

        return memo[index][ weight] = gogo(index+1,weight+chuArr[index])
                | gogo(index+1,weight-chuArr[index])
                | gogo(index+1,weight);
    }
}
