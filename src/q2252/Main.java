package q2252;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Node[] nodeList = new Node[n+1];
        for(int i=1; i<=n; i++){
            nodeList[i]= new Node(i);
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodeList[b].indegree++;
            nodeList[a].outList.add(nodeList[b]);
        }

        Queue<Node> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            Node node = nodeList[i];
            if(node.indegree == 0) queue.offer(node);
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.index);
            for(Node other : node.outList){
                if(--other.indegree == 0){
                    queue.offer(other);
                }
            }
            if(!queue.isEmpty()){
                System.out.print(" ");
            }
        }
    }

    static class Node {
        public int index;
        public int indegree;
        public List<Node> outList;

        public Node(int index){
            this.index = index;
            this.indegree = 0;
            outList = new LinkedList<>();
        }
    }
}
