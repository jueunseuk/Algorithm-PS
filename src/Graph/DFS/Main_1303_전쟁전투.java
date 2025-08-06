package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {
	static boolean visit[][], matrix[][];
	static int row, col, mine = 0, yours = 0;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				if(input[j] == 'W') {
					matrix[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j]) {
					if(matrix[i][j]) {
						int score = dfsMine(i, j);
						mine += score*score;
					} else {
						int score = dfsYours(i, j);
						yours += score*score;
					}
				}
			}
		}
		
		System.out.println(mine+" "+yours);

	}

	private static int dfsMine(int i, int j) {
		visit[i][j] = true;
		int cnt = 1;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny]) {
				cnt += dfsMine(nx, ny);
			}
		}
		
		return cnt;
	}
	
	private static int dfsYours(int i, int j) {
		visit[i][j] = true;
		int cnt = 1;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && !matrix[nx][ny]) {
				cnt += dfsYours(nx, ny);
			}
		}
		
		return cnt;
	}

}
