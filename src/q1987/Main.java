package q1987;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static String[] board;
    public static HashMap<Character, Boolean> map = new HashMap<>();
    public static int r;
    public static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new String[r];
        for(int i =0; i<r; i++){
            board[i] = sc.next();
        }

        int result = getResult(0,0);
        System.out.println(result);
    }

    private static int getResult(int y, int x) {
        if(y < 0 || r <= y) return 0;
        if(x < 0 || c <= x) return 0;
        char nowChar = board[y].charAt(x);
        if(map.containsKey(nowChar)) return 0;

        map.put(nowChar,true);
        int ret = Math.max(getResult(y-1,x), getResult(y+1,x));
        ret = Math.max(ret, getResult(y,x+1));
        ret = Math.max(ret, getResult(y,x-1));

        map.remove(nowChar);
        return ret + 1;
    }
}
