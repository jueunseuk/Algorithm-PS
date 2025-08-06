package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int row, col, max = 0;
	static int matrix[][];
	static boolean visit[][];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, matrix[i][j]);
				visit[i][j] = false;
				checkT(i, j);
			}
		}
		
		System.out.println(max);
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
			if(!visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx, ny, depth + 1, sum + matrix[nx][ny]);
				visit[nx][ny] = false;
			}
		}
	}

	private static void checkT(int x, int y) {
		int c = matrix[x][y];
		for(int k = 0; k < 4; k++) {
			int temp = c;
			int cnt = 0;
			for(int t = 0; t < 4; t++) {
				if(t == k) continue;
				int nx = x + dx[t];
				int ny = y + dy[t];
				if(nx < 0 || ny < 0 || nx >= row || ny >= col) {
					cnt = 0;
					break;
				}
				temp += matrix[nx][ny];
				cnt++;
			}
			if(cnt == 3) max = Math.max(max, temp);
		}
	}
}
