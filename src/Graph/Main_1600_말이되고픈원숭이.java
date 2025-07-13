package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static int row, col, k;
	static int[][] matrix;
	static boolean[][][] visit;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int[] ddx = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] ddy = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        k = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col][k+1];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs(0, 0);
	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j, k, 0});
		visit[i][j][k] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == row-1 && poll[1] == col-1) {
				System.out.println(poll[3]);
				return;
			}
			
			if(poll[2] > 0) {
				for(int delta = 0; delta < 8; delta++) {
					int nx = poll[0] + ddx[delta];
					int ny = poll[1] + ddy[delta];
					
					if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll[2]-1] && matrix[nx][ny] == 0) {
						q.offer(new int[] {nx, ny, poll[2]-1, poll[3]+1});
						visit[nx][ny][poll[2]-1] = true;
					}
				}
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll[2]] && matrix[nx][ny] == 0) {
					q.offer(new int[] {nx, ny, poll[2], poll[3]+1});
					visit[nx][ny][poll[2]] = true;
				}
			}
		}
		
		System.out.println(-1);
	}
}
