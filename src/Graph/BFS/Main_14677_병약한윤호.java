package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_14677_병약한윤호 {
    static int n, total;
    static char[] pills;
    static boolean[][] visited;
    static final char[] order = {'B', 'L', 'D'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        total = 3 * n;

        pills = br.readLine().toCharArray();
        visited = new boolean[total][total];

        Deque<int[]> q = new ArrayDeque<>();
        visited[0][total-1] = true;
        q.offer(new int[] {0, total-1});

        int ans = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int l = cur[0];
            int r = cur[1];

            int len = r - l + 1;
            int eaten = total - len;
            ans = Math.max(ans, eaten);

            char need = order[eaten % 3];

            if(pills[l] == need) {
                if(l == r) {
                    ans = Math.max(ans, total);
                } else if(!visited[l+1][r]) {
                    visited[l+1][r] = true;
                    q.offer(new int[] {l+1, r});
                }
            }

            if(pills[r] == need) {
                if(l == r) {
                    ans = Math.max(ans, total);
                } else if(!visited[l][r-1]) {
                    visited[l][r-1] = true;
                    q.offer(new int[] {l, r-1});
                }
            }
        }

        System.out.println(ans);
    }
}