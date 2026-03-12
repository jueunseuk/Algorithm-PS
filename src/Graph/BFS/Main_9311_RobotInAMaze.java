package Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9311_RobotInAMaze {
	static int row, col;
	static char[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        	row = Integer.parseInt(st.nextToken());
	        	col = Integer.parseInt(st.nextToken());
	        	
	        	matrix = new char[row][col];
	        	visit = new boolean[row][col];
	        	
	        	int sx = 0;
	        	int sy = 0;
	        	for(int i = 0; i < row; i++) {
	        		matrix[i] = br.readLine().toCharArray();
	        		for(int j = 0; j < col; j++) {
	        			if(matrix[i][j] == 'S') {
	        				sx = i;
	        				sy = j;
	        				matrix[i][j] = 'O';
	        			}
	        		}
	        	}
	        	
	        	bfs(sx, sy);
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy, 0});
		visit[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == 'G') {
				sb.append("Shortest Path: ").append(poll[2]).append("\n");
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 'X') {
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny, poll[2]+1});
				}
			}
		}
		
		sb.append("No Exit\n");
	}
}