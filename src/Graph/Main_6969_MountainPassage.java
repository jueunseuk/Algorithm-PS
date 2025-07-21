package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main_6969_MountainPassage {
	static int size;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		int T = rd.nextInt();
		
		for(int t = 0; t < T; t++) {
			size = rd.nextInt();
			
			matrix = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					matrix[i][j] = rd.nextInt();
				}
			}
			
			zeroOneBfs();
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void zeroOneBfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		visit = new boolean[size][size];
		
		int ox = matrix[0][0];
		dq.offer(new int[] {0, 0, 0});
		visit[0][0] = true;
		
		int ex = size-1, ey = size-1;
		while(!dq.isEmpty()) {
			int[] poll = dq.poll();
			
			if(poll[0] == ex && poll[1] == ey) {
				sb.append(poll[2]+"\n\n");
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny] || Math.abs(matrix[nx][ny] - matrix[poll[0]][poll[1]]) > 2) {
					continue;
				}
				
				if(matrix[poll[0]][poll[1]] > ox || matrix[nx][ny] > ox) {
					dq.offerLast(new int[] {nx, ny, poll[2]+1});
				} else {
					dq.offerFirst(new int[] {nx, ny, poll[2]});
				}
				
				visit[nx][ny] = true;
			}
		}
		
		sb.append("CANNOT MAKE THE TRIP\n\n");
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= size || ny >= size;
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
