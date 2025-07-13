package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main_2665_미로만들기 {
	static final int INF = 1000000;
	static int row, col;
    static char[][] matrix;
    static int cost[][];
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        col = size;
        row = size;
        
        matrix = new char[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	Arrays.fill(cost[i], INF);
        }
        
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        bfs(0, 0);
	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		cost[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.pollFirst();
			
			if(poll[0] == row-1 && poll[1] == col-1) {
				System.out.println(cost[poll[0]][poll[1]]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
					int c = matrix[nx][ny] == '0' ? 1 : 0;
					if(cost[nx][ny] > cost[poll[0]][poll[1]] + c) {
						cost[nx][ny] = cost[poll[0]][poll[1]] + c;
						
						if(c == 0) {
							q.offerFirst(new int[] {nx, ny});
						} else {
							q.offerLast(new int[] {nx, ny});
						}
					}
				}
			}
		}
	}
}