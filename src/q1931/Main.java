package q1931;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = N = sc.nextInt();

        PriorityQueue<Conference> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            queue.offer(new Conference(s,e));
        }

        int lastEnd = -1;
        int count = 0;
        while(!queue.isEmpty()){
            Conference con = queue.poll();
            if(con.start < lastEnd) continue;

            count++;
            lastEnd = con.end;
        }

        System.out.println(count);
    }


    static class Conference implements Comparable<Conference>{
        int start;
        int end;
        public Conference(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Conference o){
            if(o.end < this.end){
                return 1;
            }
            if(o.end > this.end){
                return -1;
            }

            if(o.start < this.start){
                return 1;
            }
            return -1;
        }
    }
}

