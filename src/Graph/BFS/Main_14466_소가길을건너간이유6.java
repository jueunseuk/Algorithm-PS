package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14466_소가길을건너간이유6 {
    static int N, K, R;
    static List<Integer>[] adj;
    static Set<Integer>[] block;
    static boolean[] vis;
    static int[] comp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int idx(int r, int c) { return (r - 1) * N + (c - 1); }
    static boolean in(int r, int c) { return 1 <= r && r <= N && 1 <= c && c <= N; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int V = N * N;
        block = new HashSet[V];
        for (int i = 0; i < V; i++) block[i] = new HashSet<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            int a = idx(r1, c1), b = idx(r2, c2);
            
            block[a].add(b);
            block[b].add(a);
        }

        int[] cows = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cows[i] = idx(r, c);
        }

        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int a = idx(r, c);
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (!in(nr, nc)) continue;
                    int b = idx(nr, nc);
                    if (!block[a].contains(b)) adj[a].add(b);
                }
            }
        }

        vis = new boolean[V];
        comp = new int[V];
        
        int cid = 0;
        for (int v = 0; v < V; v++) {
            if (!vis[v]) {
                cid++;
                bfs(v, cid);
            }
        }

        int[] cnt = new int[cid + 1];
        
        for (int i = 0; i < K; i++) cnt[comp[cows[i]]]++;

        long ans = 0, pref = 0;
        for (int i = 1; i <= cid; i++) {
            ans += pref * cnt[i];
            pref += cnt[i];
        }
        
        System.out.println(ans);
    }

    static void bfs(int s, int id) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        vis[s] = true;
        comp[s] = id;
        q.add(s);
        
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : adj[v]) {
                if (!vis[u]) {
                    vis[u] = true;
                    comp[u] = id;
                    q.add(u);
                }
            }
        }
    }
}
