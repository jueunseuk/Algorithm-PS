package Graph.Dijkstra;
import java.io.*;
import java.util.*;

public class Main_1916_최소비용구하기 {
    static int N, E, K;
    static List<Node>[] adj;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node> {
        int v, w;
        
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        
        dijkstra(K);
        
        System.out.println(dist[Integer.parseInt(st.nextToken())]);
    }
    
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cv = cur.v;
            int cw = cur.w;
            
            if(dist[cv] < cw) continue;
            
            for(Node nx : adj[cv]){
                int nv = nx.v;
                int nw = cw + nx.w;
                
                if(dist[nv] > nw){
                    dist[nv] = nw;
                    pq.offer(new Node(nv, nw));
                }
            }
        }
    }
}
