package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13565_침투 {
	static int row, col;
	static int matrix[][];
	static boolean visit[][];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	String[] input = br.readLine().split("");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(input[j]);
        	}
        }
        
        br.close();
        
        for(int i = 0; i < col; i++) {
        	dfs(0, i);
        }
        
        System.out.println("NO");
	}

	private static void dfs(int i, int j) {
		if(i == row - 1 && matrix[i][j] == 0) {
			System.out.println("YES");
			System.exit(0);
		}
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visit[nx][ny] && matrix[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}

}
