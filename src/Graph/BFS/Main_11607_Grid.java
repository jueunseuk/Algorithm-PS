package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11607_Grid {
	static int matrix[][];
	static boolean visit[][];
	static int row, col, min = Integer.MAX_VALUE;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		visit = new boolean[row][col];
		
		String input[];
		for(int i = 0; i < row; i++) {
			input = br.readLine().split("");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		bfs(0, 0);
		
		System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		
		visit[x][y] = true;
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int poll[] = q.poll();
			int pollX = poll[0];
			int pollY = poll[1];
			
			for(int i = 0; i < 4; i++) {
				int multi = matrix[pollX][pollY];
				int nx = pollX + dx[i] * multi;
				int ny = pollY + dy[i] * multi;
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					if(nx == row-1 && ny == col -1) {
						min = Math.min(min, poll[2]+1);
					}
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny, poll[2]+1});
				}
			}
		}
	}

}
