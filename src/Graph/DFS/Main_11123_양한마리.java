package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11123_양한마리 {
	static int row, col, cnt = 0;
	static char matrix[][];
	static boolean visit[][];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");

	        row = Integer.parseInt(st.nextToken());
	        col = Integer.parseInt(st.nextToken());

	        matrix = new char[row][col];
	        visit = new boolean[row][col];

	        for(int i = 0; i < row; i++) {
	        	matrix[i] = br.readLine().toCharArray();
	        }

	        for(int i = 0; i < row; i++) {
	        	for(int j = 0; j < col; j++) {
	        		if(!visit[i][j] && matrix[i][j] == '#') {
	        			dfs(i, j);
	        			cnt++;
	        		}
	        	}
	        }
	        
	        System.out.println(cnt);
	        cnt = 0;
        }
        
        br.close();
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visit[nx][ny] && matrix[nx][ny] == '#') {
				dfs(nx, ny);
			}
		}
	}

}
