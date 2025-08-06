package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21736_헌내기는친구가필요해 {
	static char[][] matrix;
	static boolean visit[][];
	static int col, row, cnt = 0, posX, posY;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'I') {
					posX = i;
					posY = j;
					matrix[i][j] = 'O';
				}
			}
		}
		
		dfs(posX, posY);
		
		System.out.println(cnt == 0 ? "TT" : cnt);
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		
		if(matrix[i][j] == 'P') {
			cnt++;
			matrix[i][j] = 'O';
		}
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 'X') {
				dfs(nx, ny);
			}
		}
		
	}

}
