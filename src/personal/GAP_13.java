package personal;

import java.util.ArrayDeque;
import java.util.Queue;

public class GAP_13 {
	static int row = 100;
	static int col = 100;
	static int[][] matrix = new int[row][col];
	static boolean[][] visit = new boolean[row][col];
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) {
		int sx = 0, sy = 0;
		int ex = row-1, ey = col-1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy, 1});
		visit[sx][sy] = true;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			if(poll[0] == ex && poll[1] == ey) {
				System.out.println(poll[2]); return;
			}
			for(int idx = 0; idx < 4; idx++) {
				int nx = poll[0] + dx[idx];
				int ny = poll[1] + dy[idx];
				
				if(!isOutOfRange(nx, ny)) continue;
				if(visit[nx][ny]) continue;
				if(matrix[nx][ny] == 0) continue;
				
				q.offer(new int[] {nx, ny, poll[2] + 1});
				visit[nx][ny] = true;
			}
		}
	}
	private static boolean isOutOfRange(int nx, int ny) {
		return nx < 0 || nx >= row || ny < 0 || ny <= col;
	}
}