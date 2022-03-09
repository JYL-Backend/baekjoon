package q2447;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        printStars(board,0,0,n-1, n-1);

        for(int i=0; i< n; i++){
                System.out.println(board[i]);
        }
    }

    static public void printStars(char[][] board,int startX, int startY,int endX, int endY){
        // 최소 영역일 때 색칠
        if(endX - startX == 2){
            printSmallStars(board,startX, startY, endX, endY);
            return;
        }

        int gap = (endX - startX + 1)/3;
        int gap2 = gap*2;

        // 9등분 나누자
        printStars(board, startX,startY, startX + gap-1, startY + gap-1);
        printStars(board, startX+gap,startY, startX+gap2-1, startY+gap-1);
        printStars(board, startX+gap2,startY, endX, startY+gap-1);

        printStars(board,startX, startY+gap, startX+gap-1, startY+gap2-1);
        printSpace(board,startX+gap, startY+gap, startX+gap2-1, startY+gap2-1);
        printStars(board,startX+gap2, startY+gap, endX, startY+gap2-1);

        printStars(board, startX, startY+gap2, startX+gap-1, endY);
        printStars(board, startX+gap, startY+gap2, startX+gap2-1, endY);
        printStars(board, startX+gap2, startY+gap2, endX, endY);
    }

    // 최소영역 색칠
    private static void printSmallStars(char[][] board,int startX, int startY,int endX, int endY){
        for(int i=startY; i<= endY; i++){
            for(int j=startX; j<=endX; j++){
                if(i == startY +1 && j== startX+1) {
                    board[i][j] = ' ';
                    continue;
                }
                board[i][j] = '*';
            }
        }
    }

    // 빈칸 색칙
    private static void printSpace(char[][] board,int startX, int startY,int endX, int endY){
        for(int i=startY; i<=endY; i++){
            for(int j=startX; j<=endX; j++){
                board[i][j] = ' ';
            }
        }
    }
}
