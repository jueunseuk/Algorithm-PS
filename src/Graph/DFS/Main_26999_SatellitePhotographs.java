package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26999_SatellitePhotographs {
	static char[][] matrix;
	static boolean visit[][];
	static int col, row, maxCnt = Integer.MIN_VALUE;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j] && matrix[i][j] == '*') {
					maxCnt = Math.max(dfs(i, j), maxCnt);
				}
			}
		}
		
		System.out.println(maxCnt);
	}
	
	private static int dfs(int i, int j) {
		visit[i][j] = true;
		int depth = 1;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == '*') {
				depth += dfs(nx, ny);
			}
		}
		
		return depth;
	}
}
