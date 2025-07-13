package Graph;
import java.io.*;
import java.util.*;

public class Main_1238_파티 {
    static int N, M, X;
    static List<Node>[] adj;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        
        int maxCost = 0;
        for(int i = 1; i <= N; i++) {
        	int cost = dijkstra(i, X) + dijkstra(X, i);
        	maxCost = Math.max(maxCost, cost);
        }
        
        System.out.println(maxCost);
    }
    
    static int dijkstra(int start, int end){
    	int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
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
        
        return dist[end];
    }
    
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
}