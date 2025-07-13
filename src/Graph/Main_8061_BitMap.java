package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_8061_BitMap {
	static int row, col;
	static int matrix[][];
	static int[][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		cost = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				matrix[i][j] = input[j] - '0';
			}
		}
		
		for(int i = 0; i < row; i++) {
			Arrays.fill(cost[i], 1000000);
		}
		
		bfs();
		
		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(cost[i][j]+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
					cost[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				int nc = poll[2] + 1;
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && cost[nx][ny] > nc) {
					q.offer(new int[] {nx, ny, nc});
					cost[nx][ny] = nc;
				}
			}
		}
	}
}