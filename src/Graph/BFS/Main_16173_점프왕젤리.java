package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16173_점프왕젤리 {
	static boolean visit[][];
	static int matrix[][];
	static int n, cnt = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        matrix = new int[n][n];
        visit = new boolean[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
		bfs(0, 0);
        
        System.out.println(visit[n-1][n-1] ? "HaruHaru" : "Hing");
	}

	private static void bfs(int i, int j) {
		visit[i][j] = true;
		
		if(i == n-1 && j == n-1) {
			return;
		}
		
		if(i+matrix[i][j] < n && i+matrix[i][j] >= 0 && !visit[i+matrix[i][j]][j]) {
			bfs(i+matrix[i][j], j);
		}
		
		if(j+matrix[i][j] < n && j+matrix[i][j] >= 0 && !visit[i][j+matrix[i][j]]) {
			bfs(i, j+matrix[i][j]);
		}
	}

}
