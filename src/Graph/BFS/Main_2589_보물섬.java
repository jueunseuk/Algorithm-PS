package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int row, col, maxL = 0;
	static char[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        
        for(int i = 0; i < row; i++) {
        	String input = br.readLine();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = input.charAt(j);
        	}
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0 ; j< col; j++) {
        		if(matrix[i][j] == 'L') {
        			visit = new boolean[row][col];
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.println(maxL);
	}

	public static void bfs(int i, int j) {
		Queue<Land> q = new ArrayDeque<>();
		
		q.offer(new Land(i, j, 0));
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			Land poll = q.poll();
			
			maxL = Math.max(maxL, poll.length);
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == 'L') {
					visit[nx][ny] = true;
					q.offer(new Land(nx, ny, poll.length + 1));
				}
			}
		}
	}
	
	static class Land {
		int x;
		int y;
		int length;
		
		public Land(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
}
