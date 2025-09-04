package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12866_돌그룹 {
    static final int MAX = 1501;
    static boolean[][] visit = new boolean[MAX][MAX];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    private static void bfs(int a, int b, int c) {
        int sum = a + b + c;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {a, b});
        visit[a][b] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int z = sum - x - y;

            if (x == y && y == z) {
                System.out.println(1);
                return;
            }

            int[] result;

            if (x != y) {
                result = function(x, y);
                if (result != null && !visit[result[0]][result[1]]) {
                    q.offer(new int[] {result[0], result[1]});
                    visit[result[0]][result[1]] = true;
                }
            }

            if (x != z) {
                result = function(x, z);
                if (result != null) {
                    int nx = result[0];
                    int nz = result[1];
                    int ny = sum - nx - nz;
                    if (!visit[nx][ny]) {
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }

            if (y != z) {
                result = function(y, z);
                if (result != null) {
                    int ny = result[0];
                    int nz = result[1];
                    int nx = sum - ny - nz;
                    if (!visit[nx][ny]) {
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static int[] function(int i, int j) {
        if (i > j) {
            if (j << 1 >= MAX || i - j < 0) return null;
            i -= j;
            j <<= 1;
        } else {
            if (i << 1 >= MAX || j - i < 0) return null;
            j -= i;
            i <<= 1;
        }
        return new int[] {i, j};
    }
}
