package q1541;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        String[] splits = input.split("-");

        int sum = getInteger(splits[0]);
        for(int i = 1; i<splits.length; i++){
            sum -= getInteger(splits[i]);
        }

        System.out.println(sum);
    }

    static public int getInteger(String str){
        String[] split = str.split("[+]");
        int result = 0;
        for(String sp : split){
            result+=Integer.parseInt(sp);
        }
        return result;
    }
}
