package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4993_RedAndBlack {
	static boolean visit[][];
	static char matrix[][];
	static int row, col, cnt = 0;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			if(col == 0 && row == 0) {
				return;
			}
			
			matrix = new char[row][col];
			visit = new boolean[row][col];
			
			int posX = 0, posY = 0;
			for(int i = 0; i < row; i++) {
				matrix[i] = br.readLine().toCharArray();
				
				for(int j = 0; j < col; j++) {
					if(matrix[i][j] == '@') {
						posX = i;
						posY = j;
						matrix[i][j] = '.';
					}
				}
			}
			
			dfs(posX, posY);
	
			System.out.println(cnt);
			
			cnt = 0;
		}
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		cnt++;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == '.') {
				dfs(nx, ny);
			}
		}
		
	}

}
