package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static String matrix[][];
	static int max = 0, n, m;
	static Set<String> set;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new String[n][m];
		for(int i = 0 ; i < n; i++) {
			matrix[i] = br.readLine().split("");
		}
		
		set = new HashSet<>();
		
		bfs(0, 0, 1);
		
		System.out.println(max);
		
	}
	
	public static void bfs(int x, int y, int length) {
		String alpha = matrix[x][y];
		set.add(alpha);
		
		max = Math.max(length, max);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m && !set.contains(matrix[nx][ny])) {
				bfs(nx, ny, length+1);
			}
		}
		
		set.remove(alpha);
	}

}
