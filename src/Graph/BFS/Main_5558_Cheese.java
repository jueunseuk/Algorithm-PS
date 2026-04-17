package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5558_Cheese {
	static int row, col, cnt;
	static char[][] matrix;
	static boolean[][] visit;
	
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        
        int sx = 0;
        int sy = 0;
        for(int i = 0; i < row; i++) {
        		matrix[i] = br.readLine().toCharArray();
        		for(int j = 0; j < col; j++) {
        			if(matrix[i][j] == 'S') {
        				sx = i;
        				sy = j;
        			}
        		}
        }
        
        int time = 0;
        for(int i = 1; i <= cnt; i++) {
        		int[] result = bfs(sx, sy, i);
        		time += result[2];
        		sx = result[0];
        		sy = result[1];
        }
        
        System.out.println(time);
	}

	private static int[] bfs(int sx, int sy, int target) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		q.offer(new int[] {sx, sy, 0});
		visit[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == target+'0') {
				matrix[poll[0]][poll[1]] = '.';
				return new int[] {poll[0], poll[1], poll[2]};
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 'X') {
					q.offer(new int[] {nx, ny, poll[2]+1});
					visit[nx][ny] = true;
				}
			}
		}
		
		return null;
	}
}