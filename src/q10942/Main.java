package q10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        list = new int[n+1];
        memo = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            list[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            result[i] = isPal(a, b);
        }

        for(int i : result){
            System.out.println(i == -1 ? 0 : i);
        }
    }

    private static int isPal(int a, int b) {
        if(memo[a][b] != 0) return memo[a][b];
        if (a == b) return memo[a][b] = 1;
        if (b-a==1 && list[a] == list[b]) return memo[a][b] = 1;

        if(list[a] != list[b]) return memo[a][b] = -1;

        return memo[a][b] = isPal(a+1, b-1);
    }
}
