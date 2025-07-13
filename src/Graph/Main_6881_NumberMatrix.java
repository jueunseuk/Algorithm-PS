package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6881_NumberMatrix {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    if (bfs(a, b, c)) {
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }

        System.out.println("-1 -1 -1");
    }

    static boolean bfs(int a, int b, int c) {
        visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            if (matrix[0][y] == a || matrix[0][y] == b || matrix[0][y] == c) {
                visited[0][y] = true;
                q.offer(new int[]{0, y});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == M - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                
                if (!visited[nx][ny]) {
                    int val = matrix[nx][ny];
                    
                    if (val == a || val == b || val == c) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }
}
