package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1388_바닥장식 {
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
        		if(!visit[i][j]) {
        			bfs(i, j);
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);

	}

	private static void bfs(int i, int j) {
		visit[i][j] = true;
		
		if (matrix[i][j] == '-') {
            for (int k = -1; k < 2; k += 2) {
                int ny = j + k;
                if (ny >= 0 && ny < col && !visit[i][ny] && matrix[i][j] == matrix[i][ny]) {
                    bfs(i, ny);
                }
            }
        } else if (matrix[i][j] == '|') {
            for (int k = -1; k < 2; k += 2) {
                int nx = i + k;
                if (nx >= 0 && nx < row && !visit[nx][j] && matrix[i][j] == matrix[nx][j]) {
                    bfs(nx, j);
                }
            }
        }
	}

}
