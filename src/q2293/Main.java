package q2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] tokens;
    static int[][] memo;
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = N = Integer.parseInt(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        tokens = new int[n];
        memo = new int[n][k+1];
        visited = new boolean[n][k+1];

        for(int i=0; i<n; i++){
            tokens[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(gogo(0,k));
    }

    private static int gogo(int index, int k) {
        if(k < 0) return 0;
        if(k == 0) return 1;
        if(index == N) return 0;
        if(visited[index][k]) return memo[index][k];

        visited[index][k] = true;

        return memo[index][k] =
                gogo(index, k-tokens[index])
                + gogo(index+1, k);
    }

}
