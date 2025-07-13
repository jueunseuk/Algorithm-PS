package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16933_벽부수고이동하기3 {
	static int row, col, k;
	static int[][] matrix;
	static boolean[][][][] visit;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col][k+1][2];
        
        for(int i = 0; i < row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = input[j] - '0';
        	}
        }
        
        bfs(0, 0);
	}

	public static void bfs(int i, int j) {
		Queue<Section> q = new ArrayDeque<>();
		
		q.offer(new Section(i, j, k, true, 1));
		visit[i][j][k][0] = true;
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.x == row-1 && poll.y == col-1) {
				System.out.println(poll.dist);
				return;
			}
			
			if(poll.isDay) {
				if(!visit[poll.x][poll.y][poll.k][1]) {
					q.offer(new Section(poll.x, poll.y, poll.k, false, poll.dist+1));
					visit[poll.x][poll.y][poll.k][1] = true;
				}
				
				if(poll.k > 0) {
					for(int delta = 0; delta < 4; delta++) { // 낮에 기회 남았다면 벽 부수고 이동
						int nx = poll.x+ dx[delta];
						int ny = poll.y + dy[delta];
						
						if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll.k-1][1] && matrix[nx][ny] == 1) {
							q.offer(new Section(nx, ny, poll.k-1, false, poll.dist+1));
							visit[nx][ny][poll.k-1][1] = true;
						}
					}
				}
				
				for(int delta = 0; delta < 4; delta++) { // 낮에 일반 이동도 가능
					int nx = poll.x + dx[delta];
					int ny = poll.y + dy[delta];
					
					if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll.k][1] && matrix[nx][ny] == 0) {
						q.offer(new Section(nx, ny, poll.k, false, poll.dist+1));
						visit[nx][ny][poll.k][1] = true;
					}
				}
			} else {
				if(!visit[poll.x][poll.y][poll.k][0]) {
					q.offer(new Section(poll.x, poll.y, poll.k, true, poll.dist+1));
					visit[poll.x][poll.y][poll.k][0] = true;
				}
				
				for(int delta = 0; delta < 4; delta++) { // 밤엔 일반 이동만 가능
					int nx = poll.x + dx[delta];
					int ny = poll.y + dy[delta];
					
					if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny][poll.k][0] && matrix[nx][ny] == 0) {
						q.offer(new Section(nx, ny, poll.k, true, poll.dist+1));
						visit[nx][ny][poll.k][0] = true;
					}
				}
			}
			
		}
		
		System.out.println(-1);
	}
	
	static class Section {
		int x;
		int y;
		int k;
		boolean isDay;
		int dist;
		
		public Section(int x, int y, int k, boolean isDay, int dist) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.isDay = isDay;
			this.dist = dist;
		}		
	}
}