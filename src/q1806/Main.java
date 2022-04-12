package q1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] list = new int[n];

        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int l=0,r=0;
        int sum = list[0];
        int result = INF;
        while(l!=n && r!=n){
            if(l==r){
                if(list[l] >= s){
                    System.out.println(1);
                    return;
                }
                if(r == n-1)break;
                sum += r+1 == n ? 0 : list[r+1];
                r++; continue;
            }

            if(sum >= s){
                result = result < r-l+1 ? result : r-l+1;
                sum -= list[l];
                l++;
                continue;
            }
            if(r!= n-1){
                r++;
                sum += r == n ? 0 : list[r];
                continue;
            }
            sum -= list[l];
            l++;
        }
        System.out.println(result == INF ? 0 : result);
    }
}
