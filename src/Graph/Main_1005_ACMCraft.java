package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1005_ACMCraft {
    static int n, m;
    static List<List<Integer>> list;
    static int[] req, indeg, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            req   = new int[n + 1];
            indeg = new int[n + 1];
            dp    = new int[n + 1];
            list  = new ArrayList<>();
            for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) req[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                indeg[b]++;
            }

            sb.append(topologicalSort(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.print(sb.toString().trim());
    }

    private static int topologicalSort(int target) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                dp[i] = req[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) break;

            for (int out : list.get(cur)) {
                dp[out] = Math.max(dp[out], dp[cur] + req[out]);
                if (--indeg[out] == 0) q.offer(out);
            }
        }
        return dp[target];
    }
}