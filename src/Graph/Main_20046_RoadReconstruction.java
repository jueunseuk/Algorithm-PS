package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20046_RoadReconstruction {
	static final int INF = 100000000;
	
	static int row, col;
	static int[][] matrix;
	static int[][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	Arrays.fill(cost[i], INF);
        }
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        if(matrix[0][0] == -1 || matrix[row-1][col-1] == -1) {
        	System.out.println(-1);
        	return;
        }
        
        dijkstra(0, 0);
        
        System.out.println(cost[row-1][col-1] == INF ? -1 : cost[row-1][col-1]);
	}

	private static void dijkstra(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);
		
		q.offer(new int[] {i, j, matrix[i][j]});
		cost[i][j] = matrix[i][j];
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(cost[poll[0]][poll[1]] < poll[2]) continue;
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] != -1) {
					int sum = matrix[nx][ny] + poll[2];
					if(cost[nx][ny] > sum) {
						q.offer(new int[] {nx, ny, sum});
						cost[nx][ny] = sum;
					}
				}
			}
		}
	}
}