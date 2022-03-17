package q14939;

import java.util.Scanner;

public class Main {
    static int min = 101;
    static String[] board = new String[10];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<10; i++){
            board[i] = sc.next();
        }

        gogo(0,0,0);
        System.out.println(min == 101 ? -1 : min);
    }

    private static void gogo(int y, int x, int count) {
        if(x == 10){
            if(y!=0){
                if(board[y-1].charAt(9) == 'O') return;
            }
            gogo(y+1, 0, count);
            return;
        }
        if(y == 10) {
            for(int i=0; i<10; i++){
                if(board[9].charAt(i) == 'O') return;
            }
            min = min < count ? min : count;
            return;
        }
        if(min < count) return;

        if(x != 0 && y != 0){
            if(board[y-1].charAt(x-1) == 'O') return;
        }
        gogo(y, x+1, count);
        pushButton(y,x);
        gogo(y, x+1, count+1);
        pushButton(y,x);
    }

    private static void pushButton(int y, int x) {
        switchJ(y,x);
        switchJ(y+1,x);
        switchJ(y-1,x);
        switchJ(y,x+1);
        switchJ(y,x-1);
    }

    private static void switchJ(int y,int x){
        if(x == -1 || x==10) return;
        if(y == -1 || y==10) return;
        char[] chars = board[y].toCharArray();
        chars[x] = chars[x] == 'O' ? '#' : 'O';
        board[y] = String.valueOf(chars);
    }
}
