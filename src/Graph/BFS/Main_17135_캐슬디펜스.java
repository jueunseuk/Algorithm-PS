package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int row, col, range, max = 0, cnt = 0;
	static int[][] matrix;
	static int[][] origin;
	static boolean[][] visit;
	
	static final int dx[] = {0, -1, 0};
	static final int dy[] = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		
		origin = new int[row][col];
		matrix = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < col; i++) {
			for(int j = i+1; j < col; j++) {
				for(int k = j+1; k < col; k++) {
					copy();
					
					cnt = 0;
					for(int turn = 0; turn < row; turn++) {
						int[] result1 = bfs(i);
						int[] result2 = bfs(j);
						int[] result3 = bfs(k);
						if(result1 != null) {
							matrix[result1[0]][result1[1]] = 0;
							cnt++;
						}
						if(result2 != null && matrix[result2[0]][result2[1]] == 1) {
							matrix[result2[0]][result2[1]] = 0;
							cnt++;
						}
						if(result3 != null && matrix[result3[0]][result3[1]] == 1) {
							matrix[result3[0]][result3[1]] = 0;
							cnt++;
						}
						
						pulling();
					}
					
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(max);
	}

	private static void copy() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = origin[i][j];
			}
		}
	}

	private static void pulling() {
		for(int i = row-1; i > 0; i--) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = matrix[i-1][j];
			}
		}
		Arrays.fill(matrix[0], 0);
	}

	private static int[] bfs(int i) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		q.offer(new int[] {row-1, i, 1});
		visit[row-1][i] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == 1) {
				return poll;
			}
			
			if(poll[2] >= range) continue;
			
			for(int delta = 0; delta < 3; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && ny < col && !visit[nx][ny]) {
					q.offer(new int[] {nx, ny, poll[2] + 1});
					visit[nx][ny] = true;
				}
			}
		}
		
		return null;
	}
}