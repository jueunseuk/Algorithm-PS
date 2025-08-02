package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_22865_가장먼곳 {
	static final int INF = 1100000000;
	
	static int n, m, a, b, c;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] costa, costb, costc;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cc = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new int[] {end, cc});
        	list.get(end).add(new int[] {start, cc});
        }
        
        costa = new int[n+1];
        dijkstra(a, costa);
        costb = new int[n+1];
        dijkstra(b, costb);
        costc = new int[n+1];
        dijkstra(c, costc);
        
        int max = 0;
        int idx = -1;
        for(int i = 1; i <= n; i++) {
        	if(i == a || i == b || i == c) continue;
        	
        	int min = Math.min(Math.min(costa[i], costb[i]), costc[i]);
        	if(min > max) {
        		max = min;
        		idx = i;
        	}
        }
        
        System.out.println(idx);
	}

	private static void dijkstra(int i, int[] cost) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = out[1] + poll[1];
				if(nc < cost[out[0]]) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
	}
}