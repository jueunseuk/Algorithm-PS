package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6186_BestGraph {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static boolean visit[][];
	static char matrix[][];
	static int row, col, cnt = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
        			bfs(i, j);
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);

	}

	private static void bfs(int i, int j) {
		if(matrix[i][j] == '.') {
			return;
		}
		
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx < row && nx >= 0 && ny < col && ny >= 0 && !visit[nx][ny] && matrix[nx][ny] == '#') {
				bfs(nx, ny);
			}
		}
	}

}
