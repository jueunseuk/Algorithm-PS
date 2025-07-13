package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11060_점프점프 {
	static int n;
	static int[] cost, input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n];
		cost = new int[n];
		
		Arrays.fill(cost, 10000);
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs(0);
	}

	private static void bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, 0});
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < input[poll[0]]; delta++) {
				int nx = poll[0] + delta + 1;
				
				if(nx < n && cost[nx] > poll[1]+1) {
					q.offer(new int[] {nx, poll[1]+1});
					cost[nx] = poll[1]+1;
				}
			}
		}
		
		System.out.println(cost[n-1] == 10000 ? -1 : cost[n-1]);
	}
}