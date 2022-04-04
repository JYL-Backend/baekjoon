package q5430;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        String ps[] = new String[t];
        int ns[] = new int[t];
        String intArrs[] = new String[t];
        for(int i=0; i<t; i++){
            ps[i] = sc.next();
            ns[i] = sc.nextInt();
            intArrs[i] = sc.next();
        }
        for(int i=0; i<t ; i++){
            boolean isFront = true;
            Deque<Integer> deque = new LinkedList<>();

            String p = ps[i];
            int n =  ns[i];
            String intArr = intArrs[i];

            intArr = intArr.substring(1, intArr.length()-1);
            String[] split = intArr.split(",");

            for(int j=0; j<n; j++){
                deque.addLast(Integer.parseInt(split[j]));
            }

            boolean isError = false;
            for(int z=0; z<p.length(); z++){
                char c = p.charAt(z);
                if(c=='R') {
                    isFront = !isFront;
                    continue;
                }
                if(deque.isEmpty()) {
                    System.out.println("error");
                    isError = true;
                    break;
                }

                if(isFront){
                    deque.removeFirst();
                    continue;
                }
                deque.removeLast();
            }

            if(isError) continue;

            ArrayList<String> strList = new ArrayList<>();
            if(isFront){
                while(!deque.isEmpty()){
                    strList.add(deque.pollFirst().toString());
                }
            }
            else {
                while(!deque.isEmpty()){
                    strList.add(deque.pollLast().toString());
                }
            }
            System.out.println("["+String.join(",", strList) + "]");

        }
    }
}
