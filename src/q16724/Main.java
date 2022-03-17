package q16724;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static String[] board;
    static int[][] teamIdBoard;
    static boolean[][] visited;
    static int teamId = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        board = new String[n];
        teamIdBoard = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = sc.next();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int teamId = getTeamId(i, j );
                map.put(teamId, true);
            }
        }
        System.out.println(map.keySet().size());
    }

    private static int getTeamId(int y, int x) {
        // 이미 방문한 곳
        if(visited[y][x]){
            // 아직 팀아이디가 부여되지 않음 -> 새로운 사이클
            if(teamIdBoard[y][x] == 0){
                teamId++;
                teamIdBoard[y][x] =teamId;
                return teamId;
            }
            // 팀아이디가 부여됨 -> 다른 사이클 발견
            return teamIdBoard[y][x];
        }

        // 첫방문
        char nowChar = board[y].charAt(x);
        int nextY = y;
        int nextX = x;

        if(nowChar == 'D') nextY++;
        else if(nowChar == 'U') nextY--;
        else if(nowChar == 'L') nextX--;
        else nextX++;

        visited[y][x] = true;
        return teamIdBoard[y][x] = getTeamId(nextY, nextX);
    }
}
