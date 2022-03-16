package q1766;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node[] nodeList = new Node[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            nodeList[i] = new Node(i);
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodeList[a].nextList.add(nodeList[b]);
            nodeList[b].indegree++;
        }

        for(int i=1; i<=n; i++){
            if(nodeList[i].indegree == 0){
                pq.offer(nodeList[i]);
            }
        }

        StringJoiner joiner = new StringJoiner(" ");
        while(!pq.isEmpty()){
            Node node = pq.poll();
            joiner.add(String.valueOf(node.num));
            visited[node.num] = true;
            for(Node next : node.nextList){
                if(--next.indegree == 0){
                    pq.offer(next);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            joiner.add(String.valueOf(i));
        }
        System.out.print(joiner.toString());
    }

    static class Node implements Comparable<Node>{
        int num;
        int indegree = 0;
        ArrayList<Node> nextList;

        public Node(int n){
            this.num = n;
            this.nextList = new ArrayList<>();
        }

        @Override
        public int compareTo(Node o){
            if(this.indegree < o.indegree){
                return 0;
            }
            if(this.indegree > o.indegree){
                return 1;
            }
            if(this.num < o.num){
                return 0;
            }
            if(this.num > o.num){
                return 1;
            }
            return 0;
        }
    }
}
