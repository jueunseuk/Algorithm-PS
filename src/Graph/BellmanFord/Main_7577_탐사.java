package Graph.BellmanFord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_7577_탐사 {
    static class Edge {
        int u, v, w; Edge(int u, int v, int w){ this.u=u; this.v=v; this.w=w; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for(int i = 1; i <= K; i++) {
            edges.add(new Edge(i-1, i, 1));
            edges.add(new Edge(i, i-1, 0));
        }
        
        int[][] qs = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            qs[i] = new int[]{x, y, r};
            edges.add(new Edge(x-1, y, r));
            edges.add(new Edge(y, x-1, -r));
        }

        int V = K + 1;
        int[] d = new int[V];

        Arrays.fill(d, 0);

        boolean updated = false;
        for(int it = 0; it < V; it++) {
            updated = false;
            for(Edge e : edges) {
                if(d[e.v] > d[e.u] + e.w) {
                    d[e.v] = d[e.u] + e.w;
                    updated = true;
                }
            }
            if(!updated) break;
        }
        
        if(updated) {
            System.out.println("NONE");
            return;
        }

        char[] out = new char[K];
        for(int i = 1; i <= K; i++) {
            int diff = d[i] - d[i-1];
            if(diff != 0 && diff != 1) {
                System.out.println("NONE");
                return;
            }
            
            out[i-1] = (diff == 1) ? '#' : '-';
        }

        int[] pref = new int[K+1];
        for(int i = 1; i <= K; i++) pref[i] = pref[i-1] + (out[i-1] == '#' ? 1 : 0);
        for(int[] q : qs) {
            int x = q[0], y = q[1], r = q[2];
            if(pref[y] - pref[x-1] != r) {
                System.out.println("NONE");
                return;
            }
        }

        System.out.println(new String(out));
    }
}
