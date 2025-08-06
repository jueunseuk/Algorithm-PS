package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6080_BadGrass {
	static int row, col;
	static int matrix[][];
	static boolean visit[][];
	
	static final int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
	static final int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j] && matrix[i][j] > 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 8; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] > 0) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
	}
}