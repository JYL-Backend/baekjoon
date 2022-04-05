package q1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        StringBuilder sb = new StringBuilder();
        for( int i=0 ; i<n; i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n ; i++){
            if(pqMax.size() <= pqMin.size()){
                pqMax.offer(inputs[i]);
            }
            else {
                pqMin.offer(inputs[i]);
            }


            if(pqMin.isEmpty() || pqMax.peek() <= pqMin.peek()){
                sb.append(pqMax.peek()).append("\n");
                continue;
            }
            int a = pqMax.poll();
            int b = pqMin.poll();
            pqMax.offer(b);
            pqMin.offer(a);

            sb.append(pqMax.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
