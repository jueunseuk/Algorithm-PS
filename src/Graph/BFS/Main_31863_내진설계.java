package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_31863_내진설계 {
	static int row, col, building = 0, collapse = 0;
	static char[][] matrix;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        
        int sx = 0, sy = 0;
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == '#' || matrix[i][j] == '*') {
        			building++;
        		} else if(matrix[i][j] == '@') {
        			sx = i;
        			sy = j;
        			matrix[i][j] = '.';
        		}
        	}
        }
        
        bfs(sx, sy);
        
        System.out.println(collapse+" "+building);
	}

	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int delta = 0; delta < 4; delta++) {
			int nx = sx + dx[delta];
			int ny = sy + dy[delta];
			
			if(rangeCheck(nx, ny)) {
				if(matrix[nx][ny] == '|') {
					continue;
				} else if(matrix[nx][ny] == '*') {
					q.offer(new int[] {nx, ny});
					matrix[nx][ny] = '.';
					building--;
					collapse++;
				} else if(matrix[nx][ny] == '#') {
					matrix[nx][ny] = '*';
				}
			}
			
			nx += dx[delta];
			ny += dy[delta];
			
			if(rangeCheck(nx, ny)) {
				if(matrix[nx][ny] == '*') {
					q.offer(new int[] {nx, ny});
					matrix[nx][ny] = '.';
					building--;
					collapse++;
				} else if(matrix[nx][ny] == '#') {
					matrix[nx][ny] = '*';
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(rangeCheck(nx, ny)) {
					if(matrix[nx][ny] == '*') {
						q.offer(new int[] {nx, ny});
						matrix[nx][ny] = '.';
						building--;
						collapse++;
					} else if(matrix[nx][ny] == '#') {
						matrix[nx][ny] = '*';
					}
				}
			}
		}
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}