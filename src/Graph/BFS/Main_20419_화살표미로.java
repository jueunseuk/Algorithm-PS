package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20419_화살표미로 {
    static int row, col, set;
    static char[][] matrix;
    static boolean[][][][] visit;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int getDirection(char c) {
        if (c == 'D') return 0;
        if (c == 'L') return 1;
        if (c == 'U') return 2;
        return 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        set = Integer.parseInt(st.nextToken());

        matrix = new char[row][col];
        visit = new boolean[set + 1][set + 1][row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        br.close();

        System.out.println(bfs(0, 0) ? "Yes" : "No");
    }

    private static boolean bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j, 0, 0});
        visit[0][0][i][j] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1], lUsed = poll[2], rUsed = poll[3];

            if (x == row - 1 && y == col - 1) return true;

            int currentDir = getDirection(matrix[x][y]);

            for (int l = 0; l <= 3; l++) {
                for (int r = 0; r <= 3; r++) {
                    int nlUsed = lUsed + l, nrUsed = rUsed + r;
                    if (nlUsed > set || nrUsed > set) continue;

                    int newDir = (currentDir + r - l + 4) % 4;
                    int nx = x + dx[newDir], ny = y + dy[newDir];

                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || visit[nlUsed][nrUsed][nx][ny]) continue;

                    visit[nlUsed][nrUsed][nx][ny] = true;
                    q.offer(new int[]{nx, ny, nlUsed, nrUsed});
                }
            }
        }
        
        return false;
    }
}
