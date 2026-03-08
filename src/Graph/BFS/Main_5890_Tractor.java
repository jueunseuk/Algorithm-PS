package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5890_Tractor {
	static final int INF = 100000000;
	
	static int size = 1002, n, sx, sy;
	static int[][] matrix;
	static int[][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};	
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        
        matrix = new int[size][size];
        cost = new int[size][size];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        
        for(int i = 0; i <= 1001; i++) {
        	Arrays.fill(cost[i], INF);
        }
        
        zobfs();
	}

	private static void zobfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {sx, sy, 0});
		cost[sx][sy] = 0;
		
		while(!dq.isEmpty()) {
			int[] poll = dq.poll();
			
			if(poll[2] > cost[poll[0]][poll[1]]) continue;
			
			if(poll[0] == 0 || poll[1] == 0 || poll[0] == 1001 || poll[1] == 1001) {
				System.out.println(poll[2]);
				return;
			}			
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size && matrix[nx][ny] + poll[2] < cost[nx][ny]) {
					if(matrix[nx][ny] == 0) {
						dq.offerFirst(new int[] {nx, ny, poll[2]});
						cost[nx][ny] = poll[2];
					} else {
						dq.offerLast(new int[] {nx, ny, poll[2]+1});
						cost[nx][ny] = poll[2] + matrix[nx][ny];
					}
				}
			}
		}
	}
}