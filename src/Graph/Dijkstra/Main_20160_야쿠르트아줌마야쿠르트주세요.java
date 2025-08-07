package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20160_야쿠르트아줌마야쿠르트주세요 {
	static final long INF = 10000000007l;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost;
	static int[] path = new int[11];
	static long[] take = new long[11];

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
			
			list.get(start).add(new int[] {end, c});
			list.get(end).add(new int[] {start, c});
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= 10; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
		
		long prefix = 0;
		Arrays.fill(take, -1);
		take[1] = 0;
		for(int i = 1; i < 10;) {
			boolean flag = false;
			
			for(int j = i+1; j <= 10; j++) {
				long temp = getDist(path[i], path[j]);
				if(temp != -1) {
					prefix += temp;
					take[j] = prefix;
					i = j;
					flag = true;
					break;
				}
			}
			
			if(!flag) break;
		}
		
		int start = Integer.parseInt(br.readLine());
		dijkstra(start);
		
		List<Integer> candidate = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			if(take[i] >= cost[path[i]]) {
				candidate.add(path[i]);
			}
		}
		
		if(candidate.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(candidate);
			System.out.println(candidate.get(0));
		}
	}

	private static long getDist(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		long[] temp = new long[n+1];
		Arrays.fill(temp, INF);
		
		q.offer(new int[] {i, 0});
		temp[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == j) {
				return temp[j];
			}
			
			if(poll[1] > temp[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(nc < temp[out[0]]) {
					q.offer(new int[] {out[0], nc});
					temp[out[0]] = nc;
				}
			}
		}
		
		return -1;
	}

	private static void dijkstra(int start) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new long[n+1];
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