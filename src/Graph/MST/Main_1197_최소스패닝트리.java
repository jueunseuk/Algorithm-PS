package Graph.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	static int n, m, total = 0;
	static List<Edge> list = new ArrayList<>();
	static int parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(start, end, cost));
		}
		
		Collections.sort(list);
		
		int cnt = 0;
		for(Edge out : list) {
			if(find(out.start) != find(out.end)) {
				union(out.start, out.end);
				total += out.w;
				if(++cnt == n-1) break;
			}
		}
		
		System.out.println(total);
	}
	
	private static int find(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
	
	private static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		
		if(rx != ry) {
			parent[rx] = ry;
		}
	}

	static class Edge implements Comparable<Edge>{
		int start, end, w;

		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
