package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23033_집에빨리가고싶어 {
	static final int INF = 1000000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int gap = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new int[] {end, c, gap});
		}
		
		dijkstra();

	}

	private static void dijkstra() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {1, 0});
		cost[1] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == n) {
				System.out.println(poll[1]);
				return;
			}
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				
				if(poll[1] != 0) {
					int gap = out[2];
					while(gap < poll[1]) {
						gap += out[2];
					}
					nc += gap-poll[1];
				}
				
				if(nc < cost[out[0]]) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
	}
}