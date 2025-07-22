package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_22255_호석사우루스 {
	static final int INF = 1000000000;
	
	static int row, col;
	static int[][] matrix;
	static int[][][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		row = rd.nextInt();
		col = rd.nextInt();
		
		int sx = rd.nextInt()-1;
		int sy = rd.nextInt()-1;
		int ex = rd.nextInt()-1;
		int ey = rd.nextInt()-1;
		
		matrix = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = rd.nextInt();
			}
		}
		
		dijkstra(sx, sy, ex, ey);
	}

	private static void dijkstra(int sx, int sy, int ex, int ey) {
		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		cost = new int[row][col][3];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				Arrays.fill(cost[i][j], INF);
			}
		}
		
		q.offer(new int[] {sx, sy, 0, 1});
		cost[sx][sy][1] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			switch(poll[3]) {
				case 0: {
					for(int delta = 0; delta < 4; delta++) {
						int nx = poll[0] + dx[delta];
						int ny = poll[1] + dy[delta];
						
						if(outOfRange(nx, ny) || matrix[nx][ny] == -1) {
							continue;
						}
						
						int nc = poll[2] + matrix[nx][ny];
						int nd = (poll[3] + 1) % 3;
						if(nc < cost[nx][ny][nd]) {
							q.offer(new int[] {nx, ny, nc, nd});
							cost[nx][ny][nd] = nc;
						}
					}
					break;
				}
				case 1: {
					for(int delta = 0; delta < 2; delta++) {
						int nx = poll[0] + dx[delta];
						int ny = poll[1] + dy[delta];
						
						if(outOfRange(nx, ny) || matrix[nx][ny] == -1) {
							continue;
						}
						
						int nc = poll[2] + matrix[nx][ny];
						int nd = (poll[3] + 1) % 3;
						if(nc < cost[nx][ny][nd]) {
							q.offer(new int[] {nx, ny, nc, nd});
							cost[nx][ny][nd] = nc;
						}
					}
					break;
				}
				case 2: {
					for(int delta = 2; delta < 4; delta++) {
						int nx = poll[0] + dx[delta];
						int ny = poll[1] + dy[delta];
						
						if(outOfRange(nx, ny) || matrix[nx][ny] == -1) {
							continue;
						}
						
						int nc = poll[2] + matrix[nx][ny];
						int nd = (poll[3] + 1) % 3;
						if(nc < cost[nx][ny][nd]) {
							q.offer(new int[] {nx, ny, nc, nd});
							cost[nx][ny][nd] = nc;
						}
					}
					break;
				}
			}
		}
		
		int min = INF;
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, cost[ex][ey][i]);
		}
		
		System.out.println(min == INF ? -1 : min);
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}

	static class Reader {
	    private final int SIZE = 1 << 13;
	    private byte[] buffer = new byte[SIZE];
	    private int index, size;
	    
	    int nextInt() throws Exception {
	        int lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }

	    private boolean isnumber(byte c) {
	        return 47 < c && c < 58;
	    }

	    private byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}
