package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16974_서울지하철2호선 {
	static final int INF = 300;
	
	static int me, target;
	static boolean visit[][];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			me = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			
			visit = new boolean[INF+1][INF+1];
			
			bfs();
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {me, target, 0});
		visit[me][target] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == poll[1]) {
				sb.append(poll[2]+"\n");
				return;
			}
			
			int nx = poll[0] << 1;
			if(nx <= INF && poll[1]+3 <= INF && !visit[nx][poll[1]+3]) {
				q.offer(new int[] {nx, poll[1]+3, poll[2]+1});
				visit[nx][poll[1]+3] = true;
			}
			
			nx = poll[0]+1;
			if(nx <= INF && !visit[nx][poll[1]]) {
				q.offer(new int[] {nx, poll[1], poll[2]+1});
				visit[nx][poll[1]] = true;
			}
		}
	}
}