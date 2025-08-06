package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_9376_탈옥 {
    static int row, col;
    static char[][] matrix;
    static int[][] prisoners = new int[2][2];
    
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    static final int INF = 10000;
    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            row = h + 2;
            col = w + 2;
            matrix = new char[row][col];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    matrix[i][j] = '.';

            int idx = 0;
            for (int i = 1; i <= h; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 1; j <= w; j++) {
                    char ch = line[j - 1];
                    if (ch == '$') {
                        prisoners[idx][0] = i;
                        prisoners[idx][1] = j;
                        ch = '.';
                        idx++;
                    }
                    matrix[i][j] = ch;
                }
            }

            sb.append(bfs()).append('\n');
        }
        
        System.out.print(sb.toString().trim());
    }

    private static int bfs() {
        int[][][] dist = new int[3][row][col];
        for (int k = 0; k < 3; k++)
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    dist[k][i][j] = INF;

        zeroOneBfs(0, 0, 0, dist);
        zeroOneBfs(prisoners[0][0], prisoners[0][1], 1, dist);
        zeroOneBfs(prisoners[1][0], prisoners[1][1], 2, dist);

        int answer = INF;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '*') continue;
                int sum = dist[0][i][j] + dist[1][i][j] + dist[2][i][j];
                if (matrix[i][j] == '#') sum -= 2;
                answer = Math.min(answer, sum);
            }
        }
        return answer;
    }

    private static void zeroOneBfs(int sx, int sy, int idx, int[][][] dist) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{sx, sy});
        dist[idx][sx][sy] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (outOfRange(nx, ny) || matrix[nx][ny] == '*') continue;

                int w = (matrix[nx][ny] == '#') ? 1 : 0;
                if (dist[idx][nx][ny] > dist[idx][cur[0]][cur[1]] + w) {
                    dist[idx][nx][ny] = dist[idx][cur[0]][cur[1]] + w;
                    if (w == 1) dq.offerLast(new int[]{nx, ny});
                    else dq.offerFirst(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }
}
