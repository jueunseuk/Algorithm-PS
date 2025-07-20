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

public class Main_18402_RUN2 {
	static final int INF = 1000000000;
	
	static int n, time, escape, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		escape = Integer.parseInt(br.readLine());
		time = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(end).add(new int[] {start, c});
		}

		dijkstra(escape);
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(i == escape) continue;
			if(cost[i] <= time) {
				result++;
			}
		}
		
		System.out.println(result+1);
	}

	private static void dijkstra(int i) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		cost = new int[n+1];
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