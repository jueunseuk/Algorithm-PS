package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_33906_점심나가서먹기2 {
	static final int INF = 100000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];
	static int cost2[];
	static Pair rice[];
	static Pair cafe[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		rice = new Pair[n];
		cafe = new Pair[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			rice[i] = new Pair(i+1, Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			cafe[i] = new Pair(i+1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(rice);
		Arrays.sort(cafe);
		
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
		
		dijkstra(1);
		
		int cafeX = 0;
		for(int i = 1; i <= n; i++) {
			if(cost[i] != INF && cafe[i-1].price > 0) {
				cafeX = cafe[i-1].idx;
				break;
			}
		}
		
		int riceX = 0;
		for(int i = 1; i <= n; i++) {
			if(cost[i] != INF && rice[i-1].price > 0) {
				riceX = rice[i-1].idx;
				break;
			}
		}
		
		subDijkstra(cafeX, riceX);
		
		long result = (long) cost[riceX] + cost[cafeX] + cost2[cafeX];
		System.out.println(result);
	}

	private static void subDijkstra(int cafeX, int riceX) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost2 = new int[n+1];
		Arrays.fill(cost2, INF);
		
		q.offer(new int[] {riceX, 0});
		cost2[riceX] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost2[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(cost2[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost2[out[0]] = nc;
				}
			}
		}
		
	}

	private static void dijkstra(int i) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] > cost[poll[0]]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = poll[1] + out[1];
				if(cost[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int idx;
		int price;
		
		public Pair(int idx, int price) {
			this.idx = idx;
			this.price = price;
		}

		@Override
		public int compareTo(Pair o) {
			return this.price - o.price;
		}
	}
}