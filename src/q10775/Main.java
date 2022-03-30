package q10775;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        int[] list = new int[p];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<p; i++) {
            int now = sc.nextInt();
            list[i] = now;
        }

        for(int i=0 ;i<p; i++){
            System.out.println(i+"번째["+list[i]+"] 시작...");
            if(docking(list[i], map) == -1){
                System.out.print(i);
                break;
            }
        }
    }

    // 도킹하고 다음 도킹 번호를 리턴
    private static int docking(int n, HashMap<Integer, Integer> map) {
        // 빈공간없으면 false..
        if(n == 0) return -1;

        // 빈공간 찾으면 도킹!
        if(!map.containsKey(n)){
            System.out.println("완료.. " + n);
            int nextN = map.containsKey(n-1) ? map.get(n-1) : n-1;
            map.put(n, nextN);
            return nextN;
        }

        System.out.println("이미 도킹했네.. " +map.get(n) + " 게이트에 도킹시도..");
        //이미 차지한 공간이면 다음 도킹번호 최신화 후 리턴
        int newN = docking(map.get(n), map);
        map.put(n,newN);
        return newN;
    }
}
