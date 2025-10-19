package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main_10473_인간대포 {
    static class Node implements Comparable<Node> {
        int idx;
        double dist;
        
        public Node(int idx, double dist) {
            this.idx = idx;
            this.dist = dist;
        }
        
        public int compareTo(Node o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        double sx = Double.parseDouble(st.nextToken());
        double sy = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double tx = Double.parseDouble(st.nextToken());
        double ty = Double.parseDouble(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        double[][] points = new double[n+2][2];
        points[0][0] = sx; points[0][1] = sy;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }
        points[n+1][0] = tx; points[n+1][1] = ty;

        int total = n + 2;
        double[][] cost = new double[total][total];
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    double dx = points[i][0] - points[j][0];
                    double dy = points[i][1] - points[j][1];
                    double d = Math.hypot(dx, dy);
                    double walkTime = d / 5.0;
                    double useCannonTime = Double.MAX_VALUE;

                    if (i != 0 && i != n+1) {
                        useCannonTime = 2.0 + Math.abs(d - 50.0) / 5.0;
                    }

                    cost[i][j] = Math.min(walkTime, useCannonTime);
                }
            }
        }

        double[] dist = new double[total];
        boolean[] visited = new boolean[total];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[0] = 0.0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0.0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.idx;
            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < total; v++) {
                if (!visited[v] && cost[u][v] < Double.MAX_VALUE) {
                    double nd = dist[u] + cost[u][v];
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        pq.add(new Node(v, nd));
                    }
                }
            }
        }

        System.out.printf("%.7f\n", dist[n+1]);
    }
}
