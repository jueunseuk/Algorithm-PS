package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1445_일요일아침의데이트 {
	static final int INF = 1000000000;
	
	static int row, col;
	static char origin[][];
	static int matrix[][];
	static int cost[][];
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		origin = new char[row][col];
		matrix = new int[row][col];
		
		int sx = 0, sy = 0, ex = 0, ey = 0;
		for(int i = 0; i < row; i++) {
			origin[i] = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				if(origin[i][j] == 'S') {
					sx = i;
					sy = j;
				} else if(origin[i][j] == 'F') {
					ex = i;
					ey = j;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(origin[i][j] == 'g') {
					marking(i, j);
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(origin[i][j] == '.') {
					matrix[i][j] = 0;
				} else if(origin[i][j] == 'h') {
					matrix[i][j] = 1;
				} else if(origin[i][j] == 'g') {
					matrix[i][j] = 10000;
				}
			}
		}
		
		dijkstra(sx, sy, ex, ey);
	}

	private static void dijkstra(int sx, int sy, int ex, int ey) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		cost = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			Arrays.fill(cost[i], INF);
		}
		
		q.offer(new int[] {sx, sy, 0});
		cost[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(cost[poll[0]][poll[1]] < poll[2]) continue;
			
			if(poll[0] == ex && poll[1] == ey) {
				StringBuilder sb = new StringBuilder();
				sb.append(poll[2]/10000);
				sb.append(" ");
				sb.append(poll[2]%10000);
				System.out.println(sb.toString().trim());
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny)) continue;
				
				int nc = poll[2] + matrix[nx][ny];
				if(nc < cost[nx][ny]) {
					q.offer(new int[] {nx, ny, nc});
					cost[nx][ny] = nc;
				}
			}
		}
	}

	private static void marking(int i, int j) {
		for(int delta = 0; delta < 4; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(outOfRange(nx, ny)) {
				continue;
			}
			
			if(origin[nx][ny] == '.') {
				origin[nx][ny] = 'h';
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}
}