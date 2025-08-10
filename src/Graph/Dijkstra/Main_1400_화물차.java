package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1400_화물차 {
	static final int INF = 1000000000;
	
	static int row, col, inter;
	static char[][] matrix;
	static int[][] cost;
	static Blinker[] blinker;
	
	static StringBuilder sb = new StringBuilder();
	
	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			if(row == 0 && col == 0) {
				br.readLine();
				break;
			}
			
			int interMax = -1;
			int sx = 0, sy = 0, ex = 0, ey = 0;
			matrix = new char[row][col];
			for(int i = 0; i < row; i++) {
				matrix[i] = br.readLine().toCharArray();
				for(int j = 0; j < col; j++) {
					if(matrix[i][j] >= '0' && matrix[i][j] <= '9') {
						interMax = Math.max(interMax, matrix[i][j]-'0');
					} else if(matrix[i][j] == 'A') {
						sx = i;
						sy = j;
						matrix[i][j] = '.';
					} else if(matrix[i][j] == 'B') {
						ex = i;
						ey = j;
						matrix[i][j] = '#';
					}
				}
			}
			
			inter = interMax;
			
			blinker = new Blinker[inter+1];
			for(int i = 0; i <= inter; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken());
				int status = st.nextToken().charAt(0) == '-' ? 0 : 1;
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				blinker[i] = new Blinker(idx, status, a, b, a+b);
			}
			
			int result = dijkstra(sx, sy, ex, ey);
			
			sb.append(result == -1 ? "impossible" : result).append("\n");
			
			br.readLine();
		}
		
		System.out.println(sb.toString().trim());
	}

	private static int dijkstra(int sx, int sy, int ex, int ey) {
		Queue<Node> q = new PriorityQueue<>();
		cost = new int[row][col];
		for(int i = 0; i < row; i++) {
			Arrays.fill(cost[i], INF);
		}
		
		q.offer(new Node(sx, sy, 0));
		cost[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.x == ex && poll.y == ey) {
				return poll.w;
			}
			
			if(poll.w > cost[poll.x][poll.y]) continue;
			
			for(int delta = 0; delta < 4; delta++) {
			    int nx = poll.x + dx[delta];
			    int ny = poll.y + dy[delta];

			    if(outOfRange(nx, ny)) continue;

			    int nc = poll.w;
			    if(matrix[nx][ny] >= '0' && matrix[nx][ny] <= '9') {
			        Blinker idx = blinker[matrix[nx][ny]-'0'];
			        int temp = poll.w % idx.sumCycle;
			        boolean wantEW = (delta <= 1);

			        int wait = 0;
			        if(idx.status == 0) {
			            boolean ewNow = (temp < idx.aCycle);
			            if(wantEW) {
			                wait = ewNow ? 0 : (idx.sumCycle - temp);
			            } else {
			                wait = ewNow ? (idx.aCycle - temp) : 0;
			            }
			        } else {
			            boolean nsNow = (temp < idx.bCycle);
			            if(wantEW) {
			                wait = nsNow ? (idx.bCycle - temp) : 0;
			            } else {
			                wait = nsNow ? 0 : (idx.sumCycle - temp);
			            }
			        }

			        nc = poll.w + wait + 1;
			        if(nc < cost[nx][ny]) {
			            q.offer(new Node(nx, ny, nc));
			            cost[nx][ny] = nc;
			        }
			    } else if(matrix[nx][ny] == '#') {
			        nc += 1;
			        if(nc < cost[nx][ny]) {
			            q.offer(new Node(nx, ny, nc));
			            cost[nx][ny] = nc;
			        }
			    }
			}

		}
		
		return -1;
	}
	
	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}

	public static class Node implements Comparable<Node> {
		int x, y, w;

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static class Blinker {
		int idx, status, aCycle, bCycle, sumCycle;

		public Blinker(int idx, int status, int aCycle, int bCycle, int sumCycle) {
			this.idx = idx;
			this.status = status;
			this.aCycle = aCycle;
			this.bCycle = bCycle;
			this.sumCycle = sumCycle;
		}
	}
}