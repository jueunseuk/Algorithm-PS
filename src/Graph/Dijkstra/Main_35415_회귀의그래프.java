package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_35415_회귀의그래프 {
    static final long INF = Long.MAX_VALUE / 4;

    static int N, M, K;
    static long T;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, c));
            graph.get(v).add(new Edge(u, c));
        }

        long[] d1 = dijkstra(1);
        long[] dK = dijkstra(K);
        long[] dN = dijkstra(N);

        long ans = INF;

        if (d1[K] < INF && dK[N] < INF) {
            ans = d1[K] + dK[N];
        }

        for (int v = 1; v <= N; v++) {
            if (d1[v] >= INF || dN[v] >= INF) continue;
            if (dK[v] > T) continue;

            ans = Math.min(ans, d1[v] + T + dN[v]);
        }

        System.out.println(ans >= INF ? -1 : ans);
    }

    static long[] dijkstra(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist > dist[cur.idx]) continue;

            for (Edge next : graph.get(cur.idx)) {
                long nd = cur.dist + next.cost;
                if (dist[next.to] > nd) {
                    dist[next.to] = nd;
                    pq.offer(new Node(next.to, nd));
                }
            }
        }

        return dist;
    }

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        long dist;

        Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }
}