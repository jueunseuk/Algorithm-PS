package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14923_미로탈출 {
	static int row, col, min = Integer.MAX_VALUE;
	static int matrix[][];
	static boolean visit[][][];
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		visit = new boolean[row][col][2];
		
		st = new StringTokenizer(br.readLine(), " ");
		int startX = Integer.parseInt(st.nextToken())-1;
		int startY = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine(), " ");
		int endX = Integer.parseInt(st.nextToken())-1;
		int endY = Integer.parseInt(st.nextToken())-1;
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		bfs(startX, startY, endX, endY);
		
		System.out.println(min);
	}

	private static void bfs(int startX, int startY, int endX, int endY) {
		Queue<Section> q = new ArrayDeque<>();
		
		visit[startX][startY][0] = true;
		q.offer(new Section(startX, startY, 0, false));
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.x == endX && poll.y == endY) {
				min = Math.min(min, poll.dist);
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
					if(!poll.use) {
						if(!visit[nx][ny][0] && matrix[nx][ny] == 0) {
							visit[nx][ny][0] = true;
							q.offer(new Section(nx, ny, poll.dist+1, false));
						} else if(!visit[nx][ny][1] && matrix[nx][ny] == 1) {
							visit[nx][ny][1] = true;
							q.offer(new Section(nx, ny, poll.dist+1, true));
						}
					} else {
						if(!visit[nx][ny][1] && matrix[nx][ny] == 0) {
							visit[nx][ny][1] = true;
							q.offer(new Section(nx, ny, poll.dist+1, true));
						}
					}
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
	}
	
	public static class Section {
		int x, y, dist;
		boolean use;
		
		public Section(int x, int y, int dist, boolean use) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.use = use;
		}
	}
}