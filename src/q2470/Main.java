package q2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] list = new int[n];

        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int[] result = new int[]{0,0,2000000001};

        int l=0;
        int r=n-1;

        while(l!=r){
            int sum = list[r] + list[l];
            if(Math.abs(list[r] + list[l]) < result[2]){
                result[0] = list[l];
                result[1] = list[r];
                result[2] =Math.abs(list[r] + list[l]);
            }
            if(sum>0){
                r--;
                continue;
            }
            l++;
        }

        System.out.print(result[0] + " " + result[1]);
    }
}
