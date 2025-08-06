package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12851_숨바꼭질2 {
    static final int MAX = 200000;
    static int cnt = 0, minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

        System.out.println(minTime);
        System.out.println(cnt);
    }

    private static void bfs(int start, int end) {
        int[] visitedTime = new int[MAX + 1];
        Arrays.fill(visitedTime, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});
        visitedTime[start] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == end) {
                if (time < minTime) {
                    minTime = time;
                    cnt = 1;
                } else if (time == minTime) {
                    cnt++;
                }
                continue;
            }

            for (int next : new int[]{pos - 1, pos + 1, pos * 2}) {
                if (next >= 0 && next <= MAX) {
                    if (visitedTime[next] == -1 || visitedTime[next] == time + 1) {
                        visitedTime[next] = time + 1;
                        q.offer(new int[]{next, time + 1});
                    }
                }
            }
        }
    }
}
