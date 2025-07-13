package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17220_마약수사대 {
	static int n, m, cnt = 0, root = 0;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	static int block[];
	static int top[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		top	= new int[n];
		
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = st.nextToken().charAt(0)-'A';
			int end = st.nextToken().charAt(0)-'A';
			list.get(start).add(end);
			top[end]++;
		}
		
		for(int out : top) {
			if(out == 0) root++;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int b = Integer.parseInt(st.nextToken());
		block = new int[b];
		
		for(int i = 0; i < b; i++) {
			block[i] = st.nextToken().charAt(0)-'A';
		}
		
		bfs();
		
		System.out.println(n-cnt-root);
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int idx = 0; idx < block.length; idx++) {
			q.offer(block[idx]);
			visit[block[idx]] = true;
			if(top[block[idx]] != 0) cnt++;
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(!visit[out] && --top[out] == 0) {
					q.offer(out);
					visit[out] = true;
					cnt++;
				}
			}
		}
	}
}