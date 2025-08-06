package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1486_등산 {
static final int INF = Integer.MAX_VALUE;
	
	static int row, col, T, D;
	static int[][] matrix;
	static int[][] cost;
	static int[][] cost2;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	Arrays.fill(cost[i], INF);
        	
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		if(input[j] - 'a' >= 0) {
        			matrix[i][j] = input[j] - 'A' - 6;
        		} else {
        			matrix[i][j] = input[j] - 'A';
        		}
        	}
        }
        
        dijkstra(0, 0);
        
        int maxHeight = 0;
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(cost[i][j] <= D) {
        			int[] search = specific(i, j);
        			
        			if(search == null) continue;
        			
        			if(search[2] + cost[i][j] <= D) {
        				maxHeight = Math.max(maxHeight, matrix[i][j]);
        			}
        		}
        	}
        }

        System.out.println(maxHeight);
	}

	private static int[] specific(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		cost2 = new int[row][col];
		
		q.offer(new int[] {i, j, 0});
		cost2[i][j] = 0;
		for(int idx = 0; idx < row; idx++) {
			Arrays.fill(cost2[idx], INF);
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == 0 && poll[1] == 0) {
				return poll;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
					int diff = matrix[nx][ny] - matrix[poll[0]][poll[1]];
					
					if(Math.abs(diff) > T) continue;
					
					if(diff > 0) {
						diff *= diff;
					} else {
						diff = 1;
					}
					
					if(cost2[nx][ny] > diff + poll[2]) {
						cost2[nx][ny] = diff + poll[2];
						q.offer(new int[] {nx, ny, diff+poll[2]});
					}
				}
			}
		}
		
		return null;
	}

	private static void dijkstra(int i, int j) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		q.offer(new int[] {i, j, 0});
		cost[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
					int diff = matrix[nx][ny] - matrix[poll[0]][poll[1]];
					
					if(Math.abs(diff) > T) continue;
					
					if(diff > 0) {
						diff *= diff;
					} else {
						diff = 1;
					}
					
					if(cost[nx][ny] > diff + poll[2]) {
						cost[nx][ny] = diff + poll[2];
						q.offer(new int[] {nx, ny, diff+poll[2]});
					}
				}
			}
		}
	}
}