package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15730_수영장사장님 {
	static int row, col;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		for(int i = 0; i < row; i++) {
			q.offer(new int[] {i, 0, matrix[i][0]});
			visit[i][0] = true;
			q.offer(new int[] {i, col-1, matrix[i][col-1]});
			visit[i][col-1] = true;
		}
		for(int i = 1; i < col-1; i++) {
			q.offer(new int[] {0, i, matrix[0][i]});
			visit[0][i] = true;
			q.offer(new int[] {row-1, i, matrix[row-1][i]});
			visit[row-1][i] = true;			
		}
		
		int amount = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					if(matrix[nx][ny] < poll[2]) {
						amount += poll[2] - matrix[nx][ny];
						q.offer(new int[] {nx, ny, poll[2]});
					} else {
						q.offer(new int[] {nx, ny, matrix[nx][ny]});
					}
					
					visit[nx][ny] = true;
				}
			}
		}
		
		System.out.println(amount);
	}
}