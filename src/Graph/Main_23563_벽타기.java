package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_23563_벽타기 {
	static final int INF = 100000000;
	static int row, col;
    static char[][] matrix;
    static boolean[][] free;
    static int cost[][];
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        cost = new int[row][col];
        free = new boolean[row][col];
        
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = 0;
        for(int i = 0; i < row; i++) {
        	Arrays.fill(cost[i], INF);
        	
        	matrix[i] = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == 'S') {
        			x1 = i;
        			y1 = j;
        		} else if(matrix[i][j] == 'E') {
        			x2 = i;
        			y2 = j;
        		}
        	}
        }
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == '#') {
        			for(int delta = 0; delta < 4; delta++) {
        				int nx = i + dx[delta];
        				int ny = j + dy[delta];
        				
        				if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
        					free[nx][ny] = true;
        				}
        			}
        		}
        	}
        }
        
        matrix[x2][y2] = '.';
        
        bfs(x1, y1, x2, y2);
	}

	private static void bfs(int x1, int y1, int x2, int y2) {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.offerFirst(new int[] {x1, y1});
		cost[x1][y1] = 0;
		
		while(!dq.isEmpty()) {
			int[] poll = dq.poll();
			
			if(poll[0] == x2 && poll[1] == y2) {
			    System.out.println(cost[poll[0]][poll[1]]);
			    return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] == '.') {
					int c = (free[nx][ny] && free[poll[0]][poll[1]]) ? 0 : 1;
					
					if(cost[nx][ny] > cost[poll[0]][poll[1]] + c) {
						cost[nx][ny] = cost[poll[0]][poll[1]] + c;
						
						if(c == 0) {
							dq.offerFirst(new int[] {nx, ny});
						} else {
							dq.offerLast(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}