package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5986_3DSpaceExploration {
	static char matrix[][][];
	static boolean visit[][][];
	static int size, cnt = 0;
	
	static int dz[] = {1, -1, 0, 0, 0, 0};
	static int dx[] = {0, 0, 1, -1, 0, 0};
	static int dy[] = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		
		matrix = new char[size][size][size];
		visit = new boolean[size][size][size];		
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = br.readLine().toCharArray();
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					if(!visit[i][j][k] && matrix[i][j][k] == '*') {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

	private static void dfs(int i, int j, int k) {
		visit[i][j][k] = true;
		
		for(int delta = 0; delta < 6; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			int nz = k + dz[delta];
			
			if(nx >= 0 && nx < size && ny >= 0 && ny < size && nz >= 0 && nz < size && !visit[nx][ny][nz] && matrix[nx][ny][nz] == '*') {
				dfs(nx, ny, nz);
			}
		}
		
	}

}
