package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {
	static int start, end;
	static int trace[][];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Character> map = new HashMap<>();
		map.put(0, 'D');
		map.put(1, 'S');
		map.put(2, 'L');
		map.put(3, 'R');
		
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			visit = new boolean[10000];
			trace = new int[10000][2];
			for(int i = 0; i < 10000; i++) {
				Arrays.fill(trace[i], -1);
			}
			
			bfs();
			
			List<Integer> path = new ArrayList<>();
			for(int at = end; at != -1; at = trace[at][0]) {
				path.add(trace[at][1]);
			}
			
			path.remove(path.size()-1);
			Collections.reverse(path);
			
			for(int out : path) {
				sb.append(map.get(out));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(poll == end) {
				return;
			}
			
			// case D
			int nx = poll << 1;
			nx %= 10000;
			if(!visit[nx]) {
				q.offer(nx);
				visit[nx] = true;
				trace[nx] = new int[] {poll, 0};
			}
			
			// case S
			nx = poll-1;
			if(nx < 0) nx = 9999;
			if(!visit[nx]) {
				q.offer(nx);
				visit[nx] = true;
				trace[nx] = new int[] {poll, 1};
			}
			
			// case L
			int first = poll/1000;
			int second = (poll/100)%10;
			int third = (poll/10)%10;
			int fourth = poll%10;
			nx = second*1000 + third*100 + fourth*10 + first;
			if(!visit[nx]) {
				q.offer(nx);
				visit[nx] = true;
				trace[nx] = new int[] {poll, 2};
			}
			
			// case R
			nx = fourth*1000 + first*100 + second*10 + third;
			if(!visit[nx]) {
				q.offer(nx);
				visit[nx] = true;
				trace[nx] = new int[] {poll, 3};
			}
		}
	}
}