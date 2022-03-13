package q1197;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<Edge>[] edgeList = new List[v+1];
        for(int i=1; i<v+1; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i=0; i<e ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Edge edgeA = new Edge(a,b,c);
            Edge edgeB = new Edge(b,a,c);
            edgeList[a].add(edgeA);
            edgeList[b].add(edgeB);
        }
        for(Edge edge : edgeList[1]){
            pq.offer(edge);
        }
        boolean[] visited = new boolean[v+1];
        visited[1] = true;
        int visitCount = 1;
        int sum = 0;
        while(visitCount != v){
            Edge edge = pq.poll();
            if(visited[edge.v2]) continue;
            sum += edge.weight;
            visited[edge.v2] = true;
            visitCount++;
            for(Edge ee : edgeList[edge.v2]){
                pq.offer(ee);
            }
        }
        System.out.println(sum);
    }

    public static class Edge implements Comparable<Edge>{
        public Edge(int a, int b, int c){
            this.v1 = a;
            this.v2 = b;
            this.weight = c;
        }
        int v1;
        int v2;
        int weight;

        @Override
        public int compareTo(Edge e){
            return  this.weight - e.weight;
        }
    }
}

