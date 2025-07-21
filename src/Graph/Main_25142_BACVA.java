package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_25142_BACVA {
	static int row, col;
	static char[][] matrix;
	static boolean[][][] visit;
	
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		zeroOneBfs();
	}

	private static void zeroOneBfs() {
		int sx = 0, sy = 0;
		out:
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 'S') {
					sx = i;
					sy = j;
					matrix[i][j] = '.';
					break out;
				}
			}
		}
		
		Deque<Cylinder> dq = new ArrayDeque<>();
		visit = new boolean[row][col][3];
		
		dq.offer(new Cylinder(sx, sy, 0, 0));
		visit[sx][sy][0] = true;
		
		while(!dq.isEmpty()) {
	        Cylinder cur = dq.poll();
	        if (matrix[cur.x][cur.y] == 'F') {
	            System.out.println(cur.dist);
	            return;
	        }

	        if (cur.state == 0) {
	            for (int d = 0; d < 4; d++) {
	                int nx = cur.x + dx[d];
	                int ny = cur.y + dy[d];
	                
	                if (outOfRange(nx, ny) || matrix[nx][ny] == '#') continue;
	                
	                int ns = d <= 1 ? 2 : 1;
	                if (visit[nx][ny][ns]) continue;
	                
	                visit[nx][ny][ns] = true;
	                dq.offerLast(new Cylinder(nx, ny, cur.dist + 1, ns));
	            }
	        } else if (cur.state == 1) {
	            for (int d = 2; d < 4; d++) {
	                int nx = cur.x;
	                int ny = cur.y + dy[d];
	                
	                if (outOfRange(nx, ny) || matrix[nx][ny] == '#' || visit[nx][ny][0]) continue;
	                
	                visit[nx][ny][0] = true;
	                dq.offerLast(new Cylinder(nx, ny, cur.dist + 1, 0));
	            }
	            
	            int nx = cur.x - 1;
	            while (nx >= 0 && matrix[nx][cur.y] != '#' && !visit[nx][cur.y][1]) {
	                visit[nx][cur.y][1] = true;
	                dq.offerFirst(new Cylinder(nx, cur.y, cur.dist, 1));
	                nx--;
	            }
	            
	            nx = cur.x + 1;
	            while (nx < row && matrix[nx][cur.y] != '#' && !visit[nx][cur.y][1]) {
	                visit[nx][cur.y][1] = true;
	                dq.offerFirst(new Cylinder(nx, cur.y, cur.dist, 1));
	                nx++;
	            }
	        } else {
	            for (int d = 0; d < 2; d++) {
	                int nx = cur.x + dx[d];
	                int ny = cur.y;
	                
	                if (outOfRange(nx, ny) || matrix[nx][ny] == '#' || visit[nx][ny][0]) continue;
	                
	                visit[nx][ny][0] = true;
	                dq.offerLast(new Cylinder(nx, ny, cur.dist + 1, 0));
	            }
	            
	            int ny = cur.y - 1;
	            while (ny >= 0 && matrix[cur.x][ny] != '#' && !visit[cur.x][ny][2]) {
	                visit[cur.x][ny][2] = true;
	                dq.offerFirst(new Cylinder(cur.x, ny, cur.dist, 2));
	                ny--;
	            }
	            
	            ny = cur.y + 1;
	            while (ny < col && matrix[cur.x][ny] != '#' && !visit[cur.x][ny][2]) {
	                visit[cur.x][ny][2] = true;
	                dq.offerFirst(new Cylinder(cur.x, ny, cur.dist, 2));
	                ny++;
	            }
	        }
	    }
		
	    System.out.println(-1);
	}
	
	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}

	public static class Cylinder {
		int x, y, dist, state;
		
		public Cylinder(int x, int y, int dist, int state) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.state = state;
		}
	}
}