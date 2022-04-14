package q1644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<=1 ) {
            System.out.println(0);
            return;
        }

        boolean[] board = new boolean[n+1];
        ArrayList<Integer> primeList = new ArrayList<>();

        for(int i=2; i<=n; i++){
            if(board[i]) continue;
            for(int j=i*2; j<=n; j+=i){
                board[j] = true;
            }
        }

        for(int i=2; i<=n; i++){
            if(board[i]) continue;
            primeList.add(i);
        }

        int size = primeList.size();
        int sum = primeList.get(0);
        int l=0;
        int r=0;
        int count = 0;


        while(true){
            if(r == size) {
                break;
            }

            if(sum == n){
                count++;
            }

            if (r == l || sum <= n) {
                r++;
                sum += r == size ? 0 : primeList.get(r);
                continue;
            }

            sum -= primeList.get(l);
            l++;
        }
        System.out.println(count);

    }
}
