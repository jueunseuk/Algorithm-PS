package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31804_Chance {
	static int start, end;
	static int[] matrix;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        matrix = new int[end+1];
        visit = new boolean[end+1][2];
        
        bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0, 0});
		visit[start][0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == end) {
				System.out.println(poll[2]);
				return;
			}
			
			int nx = poll[0] + 1;
			if(nx <= end && !visit[nx][poll[1]]) {
				q.offer(new int[] {nx, poll[1], poll[2]+1});
				visit[nx][poll[1]] = true;
			}
			
			nx = poll[0] << 1;
			if(nx <= end && !visit[nx][poll[1]]) {
				q.offer(new int[] {nx, poll[1], poll[2]+1});
				visit[nx][poll[1]] = true;
			}
			
			nx = poll[0] * 10;
			if(poll[1] == 0 && nx <= end && !visit[nx][1]) {
				q.offer(new int[] {nx, 1, poll[2]+1});
				visit[nx][1] = true;
			}
		}
	}
}