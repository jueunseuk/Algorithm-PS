package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2917_늑대사냥꾼 {
	static final int INF = 100000000;
	
	static int row, col, result = 0;
	static char[][] matrix;
	static int[][] graph;
	static int[][] cost;

	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        graph = new int[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	Arrays.fill(graph[i], INF);
        	Arrays.fill(cost[i], -1);
        }
        
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = -1;
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = input[j];
        		
        		if(matrix[i][j] == 'V') {
        			x1 = i;
        			y1 = j;
        			matrix[i][j] = '.';
        		} else if(matrix[i][j] == 'J') {
        			x2 = i;
        			y2 = j;
        			matrix[i][j] = '.';
        		}
        	}
        }
        
        bfs();
        dijkstra(x1, y1, x2, y2);
	}
	
	private static void dijkstra(int x1, int y1, int x2, int y2) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]);
		
		q.offer(new int[] {x1, y1, graph[x1][y1]});
		cost[x1][y1] = graph[x1][y1];
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == x2 && poll[1] == y2) {
				System.out.println(cost[poll[0]][poll[1]]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] != '+') {
					int min = Math.min(poll[2], graph[nx][ny]);
					if(cost[nx][ny] < min) {
						cost[nx][ny] = min;
						q.offer(new int[] {nx, ny, min});
					}
				}
			}
		}
		
		System.out.println(0);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == '+') {
        			q.offer(new int[] {i, j, 0});
        			graph[i][j] = 0;
        		}
        	}
        }
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] != '+') {
					if(graph[nx][ny] > poll[2]+1) {
						q.offer(new int[] {nx, ny, poll[2]+1});
						graph[nx][ny] = poll[2]+1;
					}
				}
			}
		}
	}
}