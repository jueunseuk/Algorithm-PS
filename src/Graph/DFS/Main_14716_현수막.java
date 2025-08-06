package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14716_현수막 {
	static boolean visit[][];
	static int matrix[][];
	static int row, col, cnt = 0;
	
	static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
	static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws Exception{
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
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j] && matrix[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
	
	private static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int k = 0; k < 8; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
		
	}

}
