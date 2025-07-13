package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static boolean matrix[][], visit[][];
	static int row, col, rec, cnt = 0;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		rec = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < rec; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int coor1Y = Integer.parseInt(st.nextToken());
			int coor1X = Integer.parseInt(st.nextToken());
			int coor2Y = Integer.parseInt(st.nextToken());
			int coor2X = Integer.parseInt(st.nextToken());
			
			for(int r = coor1X; r < coor2X; r++) {
				for(int c = coor1Y; c < coor2Y; c++) {
					matrix[r][c] = true;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j] && !matrix[i][j]) {
					list.add(dfs(i, j, 0));
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		
		StringBuilder sb = new StringBuilder();
		for(int out : list) {
			sb.append(out).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static int dfs(int i, int j, int div) {
		visit[i][j] = true;
		div = 1;
		
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && !matrix[nx][ny]) {
				div += dfs(nx, ny, 0);
			}
		}
		
		return div;
	}

}
