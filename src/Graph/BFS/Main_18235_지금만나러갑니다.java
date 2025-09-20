package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18235_지금만나러갑니다 {
    static int n, f, s;
    static int[][] result1, result2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        result1 = new int[n + 1][21];
        result2 = new int[n + 1][21];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(result1[i], -1);
            Arrays.fill(result2[i], -1);
        }

        bfs(f, result1);
        bfs(s, result2);

        for (int day = 0; day <= 20; day++) {
            for (int i = 1; i <= n; i++) {
                if (result1[i][day] != -1 && result2[i][day] != -1) {
                    System.out.println(day);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private static void bfs(int start, int[][] result) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});
        result[start][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int day = cur[1];

            int move = 1 << day;
            int nextDay = day + 1;
            if (nextDay > 20) continue;

            int nx = pos + move;
            if (nx <= n && result[nx][nextDay] == -1) {
                result[nx][nextDay] = nextDay;
                q.offer(new int[]{nx, nextDay});
            }

            nx = pos - move;
            if (nx > 0 && result[nx][nextDay] == -1) {
                result[nx][nextDay] = nextDay;
                q.offer(new int[]{nx, nextDay});
            }
        }
    }
}
