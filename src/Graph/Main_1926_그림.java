package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1926_그림 {
	static int n, m, size, maxSize = 0;
	static int[][] pict;
	static int cnt = 0;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pict = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				pict[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(pict[i][j] == 1) {
					size = 1;
					cnt++;
					dfs(i, j);
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxSize);
	}
	
	public static void dfs(int i, int j) {
		pict[i][j] = 0;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m && pict[nx][ny] == 1) {
				dfs(nx, ny);
				size++;
			}
		}
		
	}

}
