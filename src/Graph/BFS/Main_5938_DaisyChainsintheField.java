package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_5938_DaisyChainsintheField {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	
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
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		bfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb.length() == 0 ? 0 : sb.toString().trim());
	}

	private static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(!visit[out]) {
					q.offer(out);
					visit[out] = true;
				}
			}
		}
	}
}