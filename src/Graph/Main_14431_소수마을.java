package Graph;
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

public class Main_14431_소수마을 {
	static final int MAX = 10000, INF = 1000000000;
	static boolean[] prime = new boolean[MAX+1];
	static int n, m, sx, sy, ex, ey;
	static List<List<int[]>> list = new ArrayList<>();
	static int cost[];
	static Map<Integer, int[]> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		preprocess();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		
		map.put(1, new int[] {sx, sy});
		map.put(2, new int[] {ex, ey});
		
		m = Integer.parseInt(br.readLine());
		n = m+2;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(map.size()+1, new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= n; i++) {
			int[] coor1 = map.get(i);
			for(int j = i+1; j <= n; j++) {
				int[] coor2 = map.get(j);
				int calc = (int) Math.sqrt((coor1[0]-coor2[0])*(coor1[0]-coor2[0]) + (coor1[1]-coor2[1])*(coor1[1]-coor2[1]));
				if(prime[calc]) {
					list.get(i).add(new int[] {j, calc});
					list.get(j).add(new int[] {i, calc});
				}
			}
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
			
			if(poll[0] == 2) {
				System.out.println(poll[1]);
				return;
			}
			
			if(cost[poll[0]] < poll[1]) continue;
			
			for(int[] out : list.get(poll[0])) {
				int nc = out[1] + poll[1];
				
				if(cost[out[0]] > nc) {
					q.offer(new int[] {out[0], nc});
					cost[out[0]] = nc;
				}
			}
		}
		
		System.out.println(-1);
	}

	private static void preprocess() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		int limit = (int) Math.sqrt(MAX);
		for(int i = 2; i <= limit; i++) {
			for(int j = i*i; j <= MAX; j+=i) {
				if(prime[j]) {
					prime[j] = false;
				}
			}
		}
	}
}