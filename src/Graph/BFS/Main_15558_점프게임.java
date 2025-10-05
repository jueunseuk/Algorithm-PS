package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15558_점프게임 {
	static int n, k;
	static int[][] matrix;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[2][n+k];
        
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < n; i++) {
        	matrix[0][i] = input[i] - '0';
        }
        
        input = br.readLine().toCharArray();
        for(int i = 0; i < n; i++) {
        	matrix[1][i] = input[i] - '0';
        }
        
        for(int i = n; i < n+k; i++) {
        	matrix[0][i] = 1;
        	matrix[1][i] = 1;
        }
        
        bfs(0, 0);
        
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[2][n+k];
		
		q.offer(new int[] {i, j, 0});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] >= n-1) {
				System.out.println(1);
				return;
			}
			
			int nx = poll[1] + 1;
			if (nx < n+k && nx > poll[2] && !visit[poll[0]][nx] && matrix[poll[0]][nx] == 1) {
			    q.offer(new int[] {poll[0], nx, poll[2] + 1});
			    visit[poll[0]][nx] = true;
			}

			nx = poll[1] - 1;
			if (nx >= 0 && nx > poll[2] && !visit[poll[0]][nx] && matrix[poll[0]][nx] == 1) {
			    q.offer(new int[] {poll[0], nx, poll[2] + 1});
			    visit[poll[0]][nx] = true;
			}

			nx = poll[1] + k;
			int ny = 1 - poll[0];
			if (nx < n+k && nx > poll[2] && !visit[ny][nx] && matrix[ny][nx] == 1) {
			    q.offer(new int[] {ny, nx, poll[2] + 1});
			    visit[ny][nx] = true;
			}
		}
		
		System.out.println(0);
	}

}
