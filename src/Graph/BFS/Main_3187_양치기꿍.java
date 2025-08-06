package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3187_양치기꿍 {
	static int row, col, wolf = 0, sheep = 0;
    static char[][] matrix;
    static boolean[][] visit;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
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
        		if(!visit[i][j] && matrix[i][j] != '#') {
        			bfs(i, j);
        		}
        	}
        }
        
        System.out.println(sheep+" "+wolf);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		int w = 0, s = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == 'v') w++;
			else if(matrix[poll[0]][poll[1]] == 'k') s++;
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != '#') {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
		
		if(s > w) {
			sheep += s;
		} else {
			wolf += w;
		}
	}
}