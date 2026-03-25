package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_35417_최단시간 {
	static int n, T;
	static int[] matrix;
	static int[][] limit;
	static boolean[][] visit;
	
	static final int INF = 1000000000;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        
        matrix = new int[n+1];
        limit = new int[T+1][2];
        
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	limit[i+1][0] = Integer.parseInt(st.nextToken());
        	limit[i+1][1] = Integer.parseInt(st.nextToken());
        }
        
        bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[T+n+2][n+1];
		
		q.offer(new int[] {1, 0});
		visit[0][1] = true;
		
		while (!q.isEmpty()) {
	        int[] poll = q.poll();

	        for (int nx : new int[]{poll[0] - 1, poll[0], poll[0] + 1}) {
	            if (nx < 1 || nx > n) continue;
	            int nt = poll[1] + 1;

	            if (nx == n) {
	                System.out.println(nt);
	                return;
	            }

	            if (nt <= T && limit[nt][0] <= nx && nx <= limit[nt][1]) continue;

	            if (visit[nt][nx]) continue;

	            visit[nt][nx] = true;
	            q.offer(new int[]{nx, nt});
	        }
	    }
		
		System.out.println(-1);
	}
}