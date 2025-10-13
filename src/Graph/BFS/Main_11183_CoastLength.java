package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11183_CoastLength {
	static int n, m, result;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < m; j++) {
        		matrix[i][j] = input[j] - '0';
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	if(!visit[i][0] && matrix[i][0] == 0) {
        		bfs(i, 0);
        	}
        	if(!visit[i][m-1] && matrix[i][m-1] == 0) {
        		bfs(i, m-1);
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(!visit[0][i] && matrix[0][i] == 0) {
        		bfs(0, i);
        	}
        	if(!visit[n-1][i] && matrix[n-1][i] == 0) {
        		bfs(n-1, i);
        	}      
        }
        
        for(int i = 0; i < n; i++) {
        	if(matrix[i][0] == 1) {
        		result++;
        	}
        	if(matrix[i][m-1] == 1) {
        		result++;
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(matrix[0][i] == 1) {
        		result++;
        	}
        	if(matrix[n-1][i] == 1) {
        		result++;
        	}
        }

        System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny)) continue;
				
				if(matrix[nx][ny] == 1) {
					result++;
				}
				
				if(visit[nx][ny]) continue;
				
				if(matrix[nx][ny] == 0) {
					q.offer(new int[] {nx ,ny});
					visit[nx][ny] = true;
				}
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}

}
