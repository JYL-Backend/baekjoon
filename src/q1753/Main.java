package q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        Node[] nodeList = new Node[v+1];
        int[] distances = new int[v+1];

        for(int i=1; i<=v; i++){
            nodeList[i] = new Node(i);
            distances[i] = -1;
        }
        distances[k] = 0;

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodeList[a].addEdge(new Edge(nodeList[b],w));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(Edge edge : nodeList[k].edgeList){
            pq.offer(edge);
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int nextIndex = edge.nextNode.index;
            if(distances[nextIndex] != -1) continue;
            distances[nextIndex] = edge.weight;

            for(Edge nextEdge : nodeList[nextIndex].edgeList){
                if(distances[nextEdge.nextNode.index] != -1) continue;
                pq.offer(new Edge(nextEdge.nextNode, nextEdge.weight + edge.weight));
            }
        }

        String[] result = new String[v];
        for(int i=1 ;i<=v; i++){
            int distance = distances[i];
            result[i-1] = distance == -1 ? "INF" : String.valueOf(distance);
        }
        System.out.println(String.join("\n",result));
    }
    public static class Node {
        public int index;
        public List<Edge> edgeList;

        public Node(int index){
            this.index = index;
            edgeList = new ArrayList<>();
        }
        public void addEdge(Edge e){
            edgeList.add(e);
        }
    }

    public static class Edge implements Comparable<Edge>{
        public Node nextNode;
        public int weight;

        public Edge(Node nextNode, int weight){
            this.nextNode = nextNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            if(this.weight < e.weight){
                return -1;
            }
            return 1;
        }
    }
}
