package q11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long INF = Long.MAX_VALUE;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodeList=  new Node[n+1];
        for(int i=1; i<=n; i++){
            nodeList[i] = new Node(i,INF);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            nodeList[a].edges.add(new Edge(b,c));
        }

        nodeList[1].distance = 0;

        for(int i=0; i<n; i++){
            for(int j=1; j<=n; j++){
                Node node = nodeList[j];
                if(node.distance == INF) continue;
                for(Edge edge : node.edges){
                    Node nextNode=  nodeList[edge.index];
                    nextNode.distance = nextNode.distance < node.distance + edge.distance
                            ? nextNode.distance
                            : node.distance + edge.distance;
                }
            }
        }
        long sum = 0;
        long sum2 = 0;

        for(int i=2; i<=n; i++) {
            Node node = nodeList[i];
            sum += node.distance;
        }
        for(int j=1; j<=n; j++){
            Node node = nodeList[j];
            if(node.distance == INF) continue;
            for(Edge edge : node.edges){
                Node nextNode=  nodeList[edge.index];
                nextNode.distance = nextNode.distance < node.distance + edge.distance
                        ? nextNode.distance
                        : node.distance + edge.distance;
            }
        }
        for(int i=2; i<=n; i++) {
            Node node = nodeList[i];
            sum2 += node.distance;
        }

        if(sum != sum2){
            System.out.println(-1);
            return;
        }

        for(int i=2; i<=n; i++){
            Node node = nodeList[i];
            System.out.println(node.distance == INF ? -1 : node.distance);
        }
    }
    static class Node{
        int index;
        long distance;
        ArrayList<Edge> edges;

        public Node(int i, long d){
            index= i;
            distance = d;
            edges = new ArrayList<>();
        }
    }
    static class Edge{
        int index;
        int distance;
        public Edge(int i, int d){
            this.index = i;
            this.distance = d;
        }
    }
}
