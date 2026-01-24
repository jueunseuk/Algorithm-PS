package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {
	static int matrix[][];
	static int result[][];
	static int row, col;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		result = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			Arrays.fill(result[i], -1);
		}
		
		int x = 0, y = 0;
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 2) {
					x = i;
					y = j;
				} else if(matrix[i][j] == 0) {
					result[i][j] = 0;
				} else if(matrix[i][j] == 1) {
					matrix[i][j] = -1;
				}
				
			}
		}
		
		bfs(x, y);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(result[i][j]);
				if(j < col - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		
		result[x][y] = 0;
		matrix[x][y] = 1;
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int poll[] = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == -1) {
					q.add(new int[] {nx, ny, poll[2]+1});
					matrix[nx][ny] = 1;
					result[nx][ny] = poll[2]+1;
				}
			}
		}
	}
}