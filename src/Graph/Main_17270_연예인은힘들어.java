package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17270_연예인은힘들어 {
	static final int INF = 1000000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost1;
	static int[] cost2;

	public static void main(String[] args) throws IOException{
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
			
			list.get(start).add(new int[] {end, c});
			list.get(end).add(new int[] {start, c});
		}
		
		cost1 = new int[n+1];
		cost2 = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		int ji = Integer.parseInt(st.nextToken());
		int su = Integer.parseInt(st.nextToken());
		
		dijkstra(ji, cost1);
		dijkstra(su, cost2);
		
		int minSum = INF;
		for (int i = 1; i <= n; i++) {
		    if (i == ji || i == su) continue;
		    if (cost1[i] == INF || cost2[i] == INF) continue;
		    minSum = Math.min(minSum, cost1[i] + cost2[i]);
		}

		int best = -1;
		int bestDist = INF;
		for (int i = 1; i <= n; i++) {
		    if (i == ji || i == su) continue;
		    if (cost1[i] == INF || cost2[i] == INF) continue;
		    if (cost1[i] + cost2[i] != minSum) continue;
		    if (cost1[i] > cost2[i]) continue;

		    if (cost1[i] < bestDist || (cost1[i] == bestDist && i < best)) {
		        bestDist = cost1[i];
		        best = i;
		    }
		}

		System.out.println(best);
	}

	private static void dijkstra(int start, int[] cost) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {start, 0});
		cost[start] = 0;
		
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