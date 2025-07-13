package Graph;
import java.io.*;
import java.util.*;

public class Main_1245_산봉우리 {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static boolean isPeak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    isPeak = true;  
                    int height = matrix[i][j];

                    dfs(i, j, height);

                    if (isPeak) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
    
    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (matrix[nx][ny] > height) {
                isPeak = false;
            }

            if (!visited[nx][ny] && matrix[nx][ny] == height) {
                dfs(nx, ny, height);
            }
        }
    }
}
