package q17298;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Node> stack = new Stack<>();

        stack.push(new Node(0,arr[0]));

        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && stack.peek().n < arr[i]){
                Node node = stack.pop();
                result[node.index] = arr[i];
            }
            stack.push(new Node(i, arr[i]));
        }

        while(!stack.isEmpty()){
            Node node = stack.pop();
            result[node.index] = -1;
        }

        ArrayList<String> strList = new ArrayList<>();
        for(int i=0; i<n; i++){
            strList.add(String.valueOf(result[i]));
        }
        System.out.println(String.join(" ", strList));
    }

    static public class Node{
        public int index;
        public int n;
        public Node(int i, int n){
            this.index = i;
            this.n = n;
        }
    }
}
