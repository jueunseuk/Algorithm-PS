package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_33578_누가이름안적고나갔어2 {
	static final int INF = 1000000000;
	
	static int row, col, min = INF;
	static char[][] matrix;
	static int[][] cost1;
	static int[][] cost2;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'J') {
					x1 = i;
					y1 = j;
				} else if(matrix[i][j] == 'S') {
					x2 = i;
					y2 = j;
				}
			}
		}
		
		cost1 = new int[row][col];
		cost2 = new int[row][col];
		
		bfs(cost1, x1, y1);
		if(cost1[x2][y2] != INF) {
			min = cost1[x2][y2];
		}
		
		bfs(cost2, x2, y2);
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'T' && cost1[i][j] != INF && cost2[i][j] != INF) {
					min = Math.min(min, cost1[i][j]+cost2[i][j]);
				}
			}
		}
		
		System.out.println(min == INF ? -1 : min);
	}

	private static void bfs(int[][] cost, int x1, int y1) {
		Queue<Node> q = new ArrayDeque<>();
		for(int i = 0; i < row; i++) {
			Arrays.fill(cost[i], INF);
		}
		
		q.offer(new Node(x1, y1, 0));
		cost[x1][y1] = 0;
		
		int currentCost = matrix[x1][y1] == 'J' ? 2 : 1;
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && cost[nx][ny] == INF && matrix[nx][ny] != '#') {
					q.offer(new Node(nx, ny, poll.c+currentCost));
					cost[nx][ny] = poll.c+currentCost;
				}
			}
		}
	}

	static class Node {
	    int x, y, c;

		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}