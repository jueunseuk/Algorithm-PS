package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_16954_움직이는미로탈출 {
    static final int N = 8;
    static char[][][] board = new char[9][N][N];
    static boolean[][][] visited = new boolean[9][N][N];

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {0, -1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < N; c++) {
                board[0][r][c] = line.charAt(c);
            }
        }

        for (int t = 1; t <= 8; t++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    board[t][r][c] = '.';
                }
            }
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[t - 1][r][c] == '#') {
                        int nr = r + 1;
                        if (nr < N) {
                            board[t][nr][c] = '#';
                        }
                    }
                }
            }
        }

        System.out.println(bfs() ? 1 : 0);
    }

    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{7, 0, 0});
        visited[0][7][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];

            if (r == 0 && c == 7) {
                return true;
            }

            int nt = Math.min(t + 1, 8);

            for (int i = 0; i < 9; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if (board[t][nr][nc] == '.' && board[nt][nr][nc] == '.') {
                    if (!visited[nt][nr][nc]) {
                        visited[nt][nr][nc] = true;
                        q.offer(new int[]{nr, nc, nt});
                    }
                }
            }
        }
        return false;
    }
}
