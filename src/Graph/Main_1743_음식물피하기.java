package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743_음식물피하기 {
	static int row, col, max = 0;
	static boolean[][] matrix;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        matrix = new boolean[row][col];
        
        for(int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	matrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j]) {
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.println(max);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		matrix[i][j] = false;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny]) {
					q.offer(new int[] {nx, ny});
					matrix[nx][ny] = false;
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}
}