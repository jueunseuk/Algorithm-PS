package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main_6129_ObstacleCourse {
	static int size, min = Integer.MAX_VALUE;
	static char[][] matrix;
	static int[][][] cost;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        
        matrix = new char[size][size];
        cost = new int[size][size][4];
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++)
        		Arrays.fill(cost[i][j], Integer.MAX_VALUE);
        }
        
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = 0;
        for(int i = 0; i < size; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < size; j++) {
        		if(matrix[i][j] == 'A') {
        			x1 = i;
        			y1 = j;
        		} else if(matrix[i][j] == 'B') {
        			x2 = i;
        			y2 = j;
        		}
        	}
        }
        
        matrix[x1][y1] = '.';
        matrix[x2][y2] = '.';
        bfs(x1, y1, x2, y2);
	}

	private static void bfs(int x1, int y1, int x2, int y2) {
		Deque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {x1, y1, 0, 0});
		q.offer(new int[] {x1, y1, 0, 1});
		q.offer(new int[] {x1, y1, 0, 2});
		q.offer(new int[] {x1, y1, 0, 3});
		
		cost[x1][y1][0] = 0;
		cost[x1][y1][1] = 0;
		cost[x1][y1][2] = 0;
		cost[x1][y1][3] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == x2 && poll[1] == y2) {
				min = Math.min(min, poll[2]);
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && ny < size && nx < size && matrix[nx][ny] == '.' && cost[nx][ny][delta] > poll[2]) {
					if(poll[3] == delta) {
						q.offerFirst(new int[] {nx, ny, poll[2], delta});
						cost[nx][ny][delta] = poll[2];
					} else {
						q.offerLast(new int[] {nx, ny, poll[2]+1, delta});
						cost[nx][ny][delta] = poll[2]+1;
					}
				}
			}
		}
		
		System.out.println(min);
	}
}