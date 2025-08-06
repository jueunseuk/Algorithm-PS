package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	static final int INF = 1000000;
	
	static int size, idx = 1;
	static int[][] matrix;
	static int[][] cost;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        while(true) {
        	size = Integer.parseInt(br.readLine());
        	
        	if(size == 0) {
        		break;
        	}
        	
        	matrix = new int[size][size];
        	cost = new int[size][size];
        	
        	for(int i = 0; i < size; i++) {
        		Arrays.fill(cost[i], INF);
        	}
        	
        	for(int i = 0; i < size; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j = 0; j < size; j++) {
        			matrix[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	bfs(0, 0);
        }

        System.out.println(sb.toString().trim());
	}
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		q.offer(new int[] {i, j, matrix[i][j]});
		cost[i][j] = matrix[i][j];
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(cost[poll[0]][poll[1]] < poll[2]) continue;
			
			if(poll[0] == size-1 && poll[1] == size-1) {
				appendResult(poll[2]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && nx < size && ny >= 0 && ny < size) {
					if(cost[nx][ny] > poll[2] + matrix[nx][ny]) {
						cost[nx][ny] = poll[2] + matrix[nx][ny];
						q.offer(new int[] {nx, ny, poll[2] + matrix[nx][ny]});
					}
				}
			}
		}
	}

	public static void appendResult(int cost) {
		sb.append("Problem ").append(idx++).append(": ").append(cost).append("\n");
	}

}
