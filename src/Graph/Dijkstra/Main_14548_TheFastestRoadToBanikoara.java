package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14548_TheFastestRoadToBanikoara {
	static final int INF = 1000000000;
	
	static int n;
	static List<List<int[]>> list;
	static Map<String, Integer> nameToNode;
	static int cost[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			list = new ArrayList<>();
			nameToNode = new HashMap<>();
			
			String depart = st.nextToken();
			list.add(new ArrayList<>());
			nameToNode.put(depart, idx++);
			
			String arrive = st.nextToken();
			list.add(new ArrayList<>());
			nameToNode.put(arrive, idx++);
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String start = st.nextToken();
				String end = st.nextToken();
				int c = Integer.parseInt(st.nextToken());
				
				if(!nameToNode.containsKey(start)) {
					list.add(new ArrayList<>());
					nameToNode.put(start, idx++);
				}
				
				if(!nameToNode.containsKey(end)) {
					list.add(new ArrayList<>());
					nameToNode.put(end, idx++);
				}
				
				list.get(nameToNode.get(start)).add(new int[] {nameToNode.get(end), c});
				list.get(nameToNode.get(end)).add(new int[] {nameToNode.get(start), c});
			}
			
			int result = dijkstra(0, 1);
			sb.append(depart+" ").append(arrive+" ").append(result+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static int dijkstra(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new int[list.size()];
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == j) {
				return poll[1];
			}
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(nc < cost[out[0]]) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
		
		return -1;
	}
}