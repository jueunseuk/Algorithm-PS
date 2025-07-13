package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14621_나만안되는연애 {
	static int n, m, total = 0, cnt = 0;
	static List<List<int[]>> list = new ArrayList<>();
	static boolean visit[];
	static byte gender[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		gender = new byte[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			if(st.nextToken().charAt(0) == 'W') {
				gender[i] = 1;
			} else {
				gender[i] = 0;
			}
		}
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(gender[start] == gender[end]) {
				continue;
			}
			
			list.get(start).add(new int[] {end, c});
			list.get(end).add(new int[] {start, c});
		}
		
		prim();
		
		System.out.println(cnt == n-1 ? total : -1);
	}

	private static void prim() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		visit = new boolean[n+1];
		
		q.addAll(list.get(1));
		visit[1] = true;
		
		cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(visit[poll[0]]) continue;
			
			total += poll[1];
			visit[poll[0]] = true;
			
			if(++cnt == n-1) break;
			
			for(int[] out : list.get(poll[0])) {
				if(!visit[out[0]]) {
					q.offer(out);
				}
			}
		}
	}
}