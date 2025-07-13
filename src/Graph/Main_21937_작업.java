package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21937_작업 {
	static int n, m, target;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n ;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(end).add(start);
		}
		
		target = Integer.parseInt(br.readLine());
		
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		visit = new boolean[n+1];
		
		q.offer(target);
		visit[target] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(!visit[out]) {
					visit[out] = true;
					q.offer(out);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}