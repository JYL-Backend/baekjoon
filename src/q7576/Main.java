package q7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        board = new int[n][m];
        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> queue2 = new LinkedList<>();

        int zeroCount = m*n;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    queue.offer(new Pos(i,j));
                    board[i][j] = 0;
                }
                if(board[i][j] == -1) zeroCount--;
            }
        }

        int day = -1;

        while(true){
            if(zeroCount == 0){
                System.out.println(day);
                return;
            }
            if(queue.isEmpty()){
                System.out.println(-1);
                return;
            }
            day++;
            while(!queue.isEmpty()){
                Pos pos = queue.poll();
                if(board[pos.y][pos.x] == -1 || board[pos.y][pos.x] == 1 ) continue;

                zeroCount--;
                board[pos.y][pos.x] = 1;
                if(pos.x-1 >= 0) queue2.offer(new Pos(pos.y,pos.x-1));
                if(pos.x+1 < m) queue2.offer(new Pos(pos.y,pos.x+1));
                if(pos.y-1 >= 0) queue2.offer(new Pos(pos.y-1,pos.x));
                if(pos.y+1 < n) queue2.offer(new Pos(pos.y+1,pos.x));
            }
            if(zeroCount == 0){
                System.out.println(day);
                return;
            }
            if(queue2.isEmpty()){
                System.out.println(-1);
                return;
            }
            day++;
            while(!queue2.isEmpty()){
                Pos pos = queue2.poll();
                if(board[pos.y][pos.x] == -1 || board[pos.y][pos.x] == 1 ) continue;

                zeroCount--;
                board[pos.y][pos.x] = 1;
                if(pos.x-1 >= 0) queue.offer(new Pos(pos.y,pos.x-1));
                if(pos.x+1 < m) queue.offer(new Pos(pos.y,pos.x+1));
                if(pos.y-1 >= 0) queue.offer(new Pos(pos.y-1,pos.x));
                if(pos.y+1 < n) queue.offer(new Pos(pos.y+1,pos.x));
            }
        }
    }

    static class Pos {
        public int x;
        public int y;
        public Pos(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}
