package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1326_폴짝폴짝 {
	static int n;
	static int[] cost, input;
	
	static int dx[] = {1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n+1];
		cost = new int[n+1];
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		bfs(start, end);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == j) {
				System.out.println(poll[1]);
				System.exit(0);;
			}
			
			for(int delta = poll[0]+input[poll[0]]; delta <= n; delta+=input[poll[0]]) {
				if(cost[delta] > poll[1]+1) {
					cost[delta] = poll[1]+1;
					q.offer(new int[] {delta, poll[1]+1});
				}
			}
			
			for(int delta = poll[0]-input[poll[0]]; delta > 0; delta-=input[poll[0]]) {
				if(cost[delta] > poll[1]+1) {
					cost[delta] = poll[1]+1;
					q.offer(new int[] {delta, poll[1]+1});
				}
			}
		}
		
		System.out.println(-1);
	}
}