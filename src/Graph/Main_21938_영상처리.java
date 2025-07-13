package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21938_영상처리 {
	static int row, col, T, cnt = 0;
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
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < col; j++) {
        		int input1 = Integer.parseInt(st.nextToken());
        		int input2 = Integer.parseInt(st.nextToken());
        		int input3 = Integer.parseInt(st.nextToken());
        		
        		matrix[i][j] = (input1+input2+input3)/3;
        	}
        }
        
        T = Integer.parseInt(br.readLine());
        
        br.close();
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(!visit[i][j] && matrix[i][j] >= T) {
        			dfs(i , j);
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visit[nx][ny] && matrix[nx][ny] >= T) {
				dfs(nx, ny);
			}
		}
	}

}
