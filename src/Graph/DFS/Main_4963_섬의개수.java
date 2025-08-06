package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
	static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
	static int matrix[][];
	static int row, col, cnt = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        while(true) {
	        st = new StringTokenizer(br.readLine(), " ");
	        col = Integer.parseInt(st.nextToken());
	        row = Integer.parseInt(st.nextToken());
	        
	        if(row == 0 && col == 0) {
	        	return;
	        }
	        
	        matrix = new int[row][col];
	        
	        for(int i = 0; i < row; i++) {
	        	st = new StringTokenizer(br.readLine(), " ");
	        	for(int j = 0; j < col; j++) {
	        		matrix[i][j] = Integer.parseInt(st.nextToken());
	        	}
	        }
	        
	        for(int i = 0; i < row; i++) {
	        	for(int j = 0; j < col; j++) {
	        		if(matrix[i][j] == 1) {
	        			dfs(i, j);
	        			cnt++;
	        		}
	        	}
	        }
	        
	        System.out.println(cnt);
	        
	        cnt = 0;
        }

	}

	private static void dfs(int i, int j) {
		matrix[i][j] = 2;
		
		for(int k = 0; k < 8; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx < row && nx >= 0 && ny < col && ny >= 0 && matrix[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}

}
