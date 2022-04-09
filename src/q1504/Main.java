package q1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,E;
    static int[][] minDistance;
    static int[][] edgeArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = N = Integer.parseInt(st.nextToken());
        int e = E = Integer.parseInt(st.nextToken());

        edgeArray = new int[n+1][n+1];
        minDistance = new int[n+1][n+1];

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeArray[a][b] = c;
            edgeArray[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        gogo(v1);
        gogo(v2);

        boolean isResult1 = ((minDistance[1][v1] == 0 && v1 != 1) || minDistance[v1][v2]==0 || (minDistance[v2][N]==0 && v2 != n)) ? false: true;
        boolean isResult2 = (minDistance[1][v2] == 0 || minDistance[v1][v2]==0 || minDistance[v1][N]==0) ? false: true;


        if(!isResult1 && !isResult2) {
            System.out.println(-1); return;
        }

        int result1 = minDistance[1][v1] + minDistance[v1][v2] + minDistance[v2][n];
        int result2 = minDistance[1][v2] + minDistance[v1][v2] + minDistance[v1][n];

        if(!isResult2){
            System.out.println(result1);
            return;
        }
        if(!isResult1){
            System.out.println(result2);
            return;
        }

        System.out.println(Math.min(result1, result2));
    }

    private static void gogo(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        Node root = new Node(index, 0);
        pq.offer(root);

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.index]) continue;

            visited[node.index] = true;

            minDistance[node.index][index] = node.distance;
            minDistance[index][node.index] = node.distance;
//            System.out.println("["+index+"]["+node.index+"] = " + node.distance);

            for(int i=1; i<=N; i++){
                if(visited[i]) continue;
                if(edgeArray[node.index][i] == 0) continue;
                pq.offer(new Node(i, node.distance+edgeArray[node.index][i]));
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n){
            if(this.distance < n.distance) return -1;
            return 1;
        }
    }
}


