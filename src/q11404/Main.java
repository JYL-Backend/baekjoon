package q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int INF = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int distance[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                distance[i][j] = i==j ? 0 :  INF;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = distance[a][b] > c ?  c : distance[a][b];
        }

        for(int b=1; b<=n; b++){
            for(int a=1; a<=n; a++){
                for(int c=1; c<=n; c++){
                    if(distance[a][b] + distance[b][c] < distance[a][c]){
                        distance[a][c] = distance[a][b] + distance[b][c];
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            List<String> row = new ArrayList<>();
            for(int j=1; j<=n; j++){
                row.add(distance[i][j] == INF ? "0" : String.valueOf(distance[i][j]));
            }
            System.out.println(String.join(" ",row));
        }

    }
}
