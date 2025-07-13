package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_33933_인덕이와산책 {

    private static final int INF = 1_000_000_000;

    static int N, M, T;
    static List<List<Integer>> adj;
    static int[] cycle;
    static int[] distToN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        cycle = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) cycle[i] = Integer.parseInt(st.nextToken());

        precomputeDistToN();

        System.out.println(bfs());
    }

    private static void precomputeDistToN() {
        distToN = new int[T];
        int posN = -1;
        for (int i = 0; i < T; i++) if (cycle[i] == N) { posN = i; break; }
        for (int i = 0; i < T; i++) distToN[i] = (posN - i + T) % T;
    }

    private static int bfs() {
        if (cycle[0] == 1) return distToN[0];

        int[][] best = new int[N + 1][T];
        for (int i = 1; i <= N; i++) Arrays.fill(best[i], INF);

        Deque<State> q = new ArrayDeque<>();
        best[1][0] = 0;
        q.offer(new State(1, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int spent = best[cur.v][cur.t];

            int nextT = (cur.t + 1) % T;
            int nextSpent = spent + 1;

            int ans = tryMove(cur.v, nextT, nextSpent, best, q);
            if (ans != -1) return ans;

            for (int nxt : adj.get(cur.v)) {
                ans = tryMove(nxt, nextT, nextSpent, best, q);
                if (ans != -1) return ans;
            }
        }
        return -1;
    }

    private static int tryMove(int nextV, int nextT, int nextSpent,
                               int[][] best, Deque<State> q) {
        if (nextV == cycle[nextT]) return nextSpent + distToN[nextT];
        if (nextV == N) return nextSpent;
        if (best[nextV][nextT] > nextSpent) {
            best[nextV][nextT] = nextSpent;
            q.offer(new State(nextV, nextT));
        }
        return -1;
    }

    private static class State {
        int v, t;
        State(int v, int t) { this.v = v; this.t = t; }
    }
}
