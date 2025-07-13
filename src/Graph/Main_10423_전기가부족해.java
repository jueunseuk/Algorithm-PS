package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10423_전기가부족해 {
	static int n, m, power, total = 0;
	static List<List<int[]>> list = new ArrayList<>();
	static boolean visit[];
	static int[] powerStation;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		power = Integer.parseInt(st.nextToken());
		
		powerStation = new int[power];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < power; i++) {
			powerStation[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= n ;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new int[] {end, cost});
			list.get(end).add(new int[] {start, cost});
		}
		
		visit = new boolean[n+1];

		prim();
		
		System.out.println(total);
	}

	private static void prim() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		for(int i = 0; i < power; i++) {
			q.addAll(list.get(powerStation[i]));
			visit[powerStation[i]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			total += poll[1];
			visit[poll[0]] = true;
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
	}
}