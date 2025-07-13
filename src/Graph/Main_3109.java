package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_3109 {
    static int R, C; // 행과 열
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1}; // 위, 중간, 아래
    static int[] dy = {1, 1, 1};  // 오른쪽으로 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) map[i][j] = line.charAt(j);
        }//for

        int count = 0;
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) count++;
        }//for

        System.out.println(count);
    }//main

    public static boolean dfs(int x, int y) {
        if (y == C - 1) return true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny < C && map[nx][ny] == '.' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if (dfs(nx, ny)) return true;
            }//if
        }//for
        return false;
    }//dfs
}
