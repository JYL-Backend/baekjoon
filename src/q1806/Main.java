package q1806;

import java.util.Scanner;

public class Main {
    static int[] board;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int s= sc.nextInt();

        min = n;
        board = new int[n];

        long sum = 0;
        for(int i=0; i<n; i++){
            board[i] = sc.nextInt();
            sum += board[i];
        }
        // 합 만들기 불가
        if(sum < s) {
            System.out.print(0);
            return;
        }

        int l = 0;
        int r = 0;

        getResult(l,r,board[0],1, s);
        System.out.println( min);
    }

    private static void getResult(int l, int r, int sum,int count, int s) {
        // 목표값 이상일 때
        if(s <= sum){
            min = count < min ? count : min;
            // 1개라면 최고결과니 리턴
            if(count == 1) {
                return;
            }
            // 2개 이상이면 줄여나가자
            getResult(l+1,r,sum-board[l], count-1, s);
        }
        // 목표값 미만일 때
        // r이 마지막이면 불가능이므로 제일 큰 값 리턴
        if(r == board.length-1){
            return;
        }
        // 오른쪽으로 확장하자
        getResult(l,r+1,sum+board[r+1], count+1, s);
    }
}
