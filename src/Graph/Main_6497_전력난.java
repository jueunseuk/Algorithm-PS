package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6497_전력난 {
	static int n, m, origin, total;
	static List<List<int[]>> list;
	static boolean visit[];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			origin = total = 0;
			
			if(n == 0) {
				break;
			}
			
			list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
			
			visit = new boolean[n];
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.get(start).add(new int[] {end, c});
				list.get(end).add(new int[] {start, c});
				
				origin += c;
			}
			
			prim();
			
			sb.append(origin-total).append("\n");
		}

		System.out.println(sb.toString().trim());
	}

	private static void prim() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		q.addAll(list.get(0));
		visit[0] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			total += poll[1];
			visit[poll[0]] = true;
			
			if(cnt++ == n-1) break;
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
	}
}