package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2 {
	static int row, col, k;
	static int[][] matrix;
	static boolean[][][] visit;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col][k+1];
        
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = input[j] - '0';
        	}
        }
        
        bfs(0, 0);
	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j, k, 1});
		visit[i][j][k] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == row-1 && poll[1] == col-1) {
				System.out.println(poll[3]);
				return;
			}
			
			if(poll[2] > 0) {
				for(int delta = 0; delta < 4; delta++) {
					int nx = poll[0] + dx[delta];
					int ny = poll[1] + dy[delta];
					
					if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll[2]-1]) {
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