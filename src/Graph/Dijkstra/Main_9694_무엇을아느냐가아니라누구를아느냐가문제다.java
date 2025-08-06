package Graph.Dijkstra;

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

public class Main_9694_무엇을아느냐가아니라누구를아느냐가문제다 {
	static final int INF = 1000000000;
	static final String PRINT = "Case #";
	
	static int n, m;
	static List<List<int[]>> list;
	static int[] cost;
	static int[] back;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	m = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	
        	list = new ArrayList<>();
        	for(int i = 0; i < n; i++) {
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
        	
        	dijkstra(0, n-1, t);
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void dijkstra(int i, int j, int idx) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		
		cost = new int[n];
		Arrays.fill(cost, INF);
		
		back = new int[n];
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == j) {
				print(0, j, true, idx);
				return;
			}
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = out[1] + poll[1];
				if(cost[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
					back[out[0]] = poll[0];
				}
			}
		}
		
		print(0, 0, false, idx);
	}
	
	private static void print(int start, int end, boolean flag, int idx) {
		sb.append(PRINT+idx+":");
		
		if(!flag) {
			sb.append(" "+-1).append("\n");
			return;
		}
		
		List<Integer> path = new ArrayList<>();
		
		for (int v = end;; v = back[v]) {
            path.add(v);
            if (v == start) break;
        }
		
        Collections.reverse(path);
        for (int v : path) sb.append(" "+v);
        sb.append("\n");
	}
}