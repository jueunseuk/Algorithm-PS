package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2424_부산의해적 {
    static int row, col;
    static char[][] matrix;
    static int[][] sunDist, dead;
    
    static final int INF = 1_000_000_000;
    
    static final int[] dx = {1, -1, 0, 0, 0};
    static final int[] dy = {0, 0, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int suaX = 0, suaY = 0;
        matrix = new char[row][col];
        Queue<int[]> vq = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            matrix[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 'Y') {
                    suaX = i;
                    suaY = j;
                    matrix[i][j] = '.';
                } else if (matrix[i][j] == 'V') {
                    vq.offer(new int[]{i, j});
                    matrix[i][j] = '.';
                }
            }
        }

        sunDist = new int[row][col];
        for (int[] r : sunDist) Arrays.fill(r, INF);
        sunBfs(vq);

        dead = new int[row][col];
        for (int[] r : dead) Arrays.fill(r, INF);
        buildDead();

        System.out.println(suaBfs(suaX, suaY) ? "YES" : "NO");
    }

    static void sunBfs(Queue<int[]> vq) {
        Queue<int[]> q = new ArrayDeque<>(vq);
        for (int[] p : vq) sunDist[p[0]][p[1]] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int t = sunDist[cur[0]][cur[1]] + 1;
            for (int d = 0; d < 5; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (rangeCheck(nx, ny) && matrix[nx][ny] != 'I' && t < sunDist[nx][ny]) {
                    sunDist[nx][ny] = t;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void buildDead() {
        for (int i = 0; i < row; i++) {
            int best = INF;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 'I') best = INF;
                else {
                    best = Math.min(best, sunDist[i][j]);
                    dead[i][j] = Math.min(dead[i][j], best);
                }
            }
            best = INF;
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == 'I') best = INF;
                else {
                    best = Math.min(best, sunDist[i][j]);
                    dead[i][j] = Math.min(dead[i][j], best);
                }
            }
        }
        for (int j = 0; j < col; j++) {
            int best = INF;
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 'I') best = INF;
                else {
                    best = Math.min(best, sunDist[i][j]);
                    dead[i][j] = Math.min(dead[i][j], best);
                }
            }
            best = INF;
            for (int i = row - 1; i >= 0; i--) {
                if (matrix[i][j] == 'I') best = INF;
                else {
                    best = Math.min(best, sunDist[i][j]);
                    dead[i][j] = Math.min(dead[i][j], best);
                }
            }
        }
    }

    static boolean suaBfs(int sx, int sy) {
        if (sunDist[sx][sy] == 0) return false;
        boolean[][] vis = new boolean[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (matrix[cur[0]][cur[1]] == 'T') return true;
            int nt = cur[2] + 1;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (!rangeCheck(nx, ny) || matrix[nx][ny] == 'I' || vis[nx][ny]) continue;
                if (nt >= sunDist[nx][ny] || nt >= dead[nx][ny]) continue;
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny, nt});
            }
        }
        return false;
    }

    static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
