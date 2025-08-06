package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25919_LostEdge {
    static int row, col, lev, exp, K;
    static int[][] matrix;
    static int[][] visit;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        lev = Integer.parseInt(st.nextToken());
        exp = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        visit  = new int[row][col];

        int sx = 0, sy = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == -3) {
                    sx = i; sy = j;
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == -1) {
                    matrix[i][j] = -100;
                } else if (matrix[i][j] == -2) {
                    matrix[i][j] = 1_000_000;
                }
            }
        }
        
        bfs(sx, sy);
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int stamp = 1;

        q.offer(new int[]{sx, sy});
        visit[sx][sy] = stamp;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int val = matrix[x][y];

            if (val == 1_000_000) {
                System.out.println(lev >= K ? "O" : "X");
                return;
            }

            if (val > 0) {
                if (lev <= val) continue;

                exp += val;
                boolean up = false;
                while (exp >= lev) {
                    exp -= lev;
                    lev++;
                    up = true;
                }
                matrix[x][y] = 0;

                if (up) {
                    q.clear();
                    stamp++;
                    visit[x][y] = stamp;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (!inRange(nx, ny) || visit[nx][ny] == stamp) continue;
                if (matrix[nx][ny] == -100) continue;
                q.offer(new int[]{nx, ny});
                visit[nx][ny] = stamp;
            }
        }
        System.out.println("X");
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
