package Graph.Dijkstra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_18402_RUN {
	static final int INF = 1000000000;
	
	static int n, time, escape, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost;

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		escape = sc.nextInt();
		time = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int c = sc.nextInt();
			
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
		
		sc.close();
		
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