package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1175_배달 {
    static int row, col;
    static char[][] matrix;
    static int ans = Integer.MAX_VALUE;

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new char[row][col];
        int sx = 0, sy = 0;
        for (int i = 0; i < row; i++) {
            matrix[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visit = new boolean[row][col][4];

        q.offer(new int[]{sx, sy, -1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], dist = cur[3];

            if (matrix[x][y] == 'C') {
                int extra = innerBfs(x, y, dir);
                if (extra != -1) ans = Math.min(ans, dist + extra);
            }

            for (int d = 0; d < 4; d++) {
                if (d == dir) continue;
                
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (!outOfRange(nx, ny) || matrix[nx][ny] == '#' || visit[nx][ny][d]) continue;
                
                visit[nx][ny][d] = true;
                q.offer(new int[]{nx, ny, d, dist + 1});
            }
        }
    }

    private static int innerBfs(int sx, int sy, int prevDir) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visit = new boolean[row][col][4];

        q.offer(new int[]{sx, sy, prevDir, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], dist = cur[3];

            if (matrix[x][y] == 'C' && (x != sx || y != sy)) return dist;

            for (int d = 0; d < 4; d++) {
                if (d == dir) continue;
                int nx = x + dx[d], ny = y + dy[d];
                if (!outOfRange(nx, ny) || matrix[nx][ny] == '#' || visit[nx][ny][d]) continue;
                visit[nx][ny][d] = true;
                q.offer(new int[]{nx, ny, d, dist + 1});
            }
        }
        return -1;
    }

    private static boolean outOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}