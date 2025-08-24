package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11965_BessieDream {
	static final int INF = 1000000000;
	
	static int row, col;
	static int[][] matrix;
	static int[][][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dijkstra(0, 0, row-1, col-1);
	}

	private static void dijkstra(int sx, int sy, int ex, int ey) {
		PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
	    int[][][] dist = new int[row][col][2];
	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	            dist[i][j][0] = INF;
	            dist[i][j][1] = INF;
	        }
	    }
	    
	    dist[sx][sy][0] = 0;
	    pq.offer(new Person(sx, sy, 0, false));
	    
	    while (!pq.isEmpty()) {
	        Person cur = pq.poll();
	        int smell = cur.yellow ? 1 : 0;
	        
	        if (cur.w != dist[cur.x][cur.y][smell]) continue;
	        
	        if (cur.x == ex && cur.y == ey) {
	            System.out.println(cur.w);
	            return;
	        }
	        
	        for (int d = 0; d < 4; d++) {
	            int nx = cur.x + dx[d];
	            int ny = cur.y + dy[d];
	            
	            if (outOfRange(nx, ny)) continue;
	            
	            int c = matrix[nx][ny];
	            if (c == 0) continue;
	            if (c == 1) {
	                if (cur.w + 1 < dist[nx][ny][smell]) {
	                    dist[nx][ny][smell] = cur.w + 1;
	                    pq.offer(new Person(nx, ny, cur.w + 1, cur.yellow));
	                }
	            } else if (c == 2) {
	                if (cur.w + 1 < dist[nx][ny][1]) {
	                    dist[nx][ny][1] = cur.w + 1;
	                    pq.offer(new Person(nx, ny, cur.w + 1, true));
	                }
	            } else if (c == 3) {
	                if (cur.yellow && cur.w + 1 < dist[nx][ny][1]) {
	                    dist[nx][ny][1] = cur.w + 1;
	                    pq.offer(new Person(nx, ny, cur.w + 1, true));
	                }
	            } else if (c == 4) {
	                int sx2 = nx, sy2 = ny;
	                int steps = 1;
	                while (true) {
	                    int tx = sx2 + dx[d];
	                    int ty = sy2 + dy[d];
	                    if (outOfRange(tx, ty) || matrix[tx][ty] == 0 || (matrix[tx][ty] == 3)) {
	                        if (cur.w + steps < dist[sx2][sy2][0]) {
	                            dist[sx2][sy2][0] = cur.w + steps;
	                            pq.offer(new Person(sx2, sy2, cur.w + steps, false));
	                        }
	                        break;
	                    }
	                    if (matrix[tx][ty] == 4) {
	                        sx2 = tx;
	                        sy2 = ty;
	                        steps++;
	                        continue;
	                    }
	                    if (matrix[tx][ty] == 1) {
	                        if (cur.w + steps + 1 < dist[tx][ty][0]) {
	                            dist[tx][ty][0] = cur.w + steps + 1;
	                            pq.offer(new Person(tx, ty, cur.w + steps + 1, false));
	                        }
	                        break;
	                    }
	                    if (matrix[tx][ty] == 2) {
	                        if (cur.w + steps + 1 < dist[tx][ty][1]) {
	                            dist[tx][ty][1] = cur.w + steps + 1;
	                            pq.offer(new Person(tx, ty, cur.w + steps + 1, true));
	                        }
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    
	    System.out.println(-1);
	}


	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}

	static class Person {
		int x, y, w;
		boolean yellow;
		
		public Person(int x, int y, int w, boolean yellow) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.yellow = yellow;
		}
	}
}
