package Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14461_소가길을건너간이유7 {
	static final int INF = Integer.MAX_VALUE/2;
	
	static int size, t;
	static int[][] matrix;
	static int[][][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		matrix = new int[size][size];
		cost = new int[size][size][3];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++)
			Arrays.fill(cost[i][j], INF);
		}

		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		djikstra();
	}

	private static void djikstra() {
		Queue<Section> q = new PriorityQueue<>();
		
		q.offer(new Section(0, 0, 0, 0));
		cost[0][0][0] = 0;
		
		size--;
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.w > cost[poll.x][poll.y][poll.dist]) continue;
			
			if(poll.x == size && poll.y == size) {
				System.out.println(poll.w);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				int nd = poll.dist + 1;
				nd %= 3;
				
				if(outOfRange(nx, ny)) continue;
				
				int nc = poll.w + t;
				if(nd == 0) {
					nc += matrix[nx][ny];
				}
				
				if(nc < cost[nx][ny][nd]) {
					q.offer(new Section(nx, ny, nd, nc));
					cost[nx][ny][nd] = nc;
				}
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx > size || ny > size;
	}

	public static class Section implements Comparable<Section> {
		int x, y, dist;
		int w;
		
		public Section(int x, int y, int dist, int w) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.w = w;
		}

		@Override
		public int compareTo(Section o) {
			return Integer.compare(this.w, o.w);
		}
	}
}