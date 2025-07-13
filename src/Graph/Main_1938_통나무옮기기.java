package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	static int size, endX, endY, endD;
	static char[][] matrix;
	static boolean[][][] visit;
	
	static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
	static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        
        matrix = new char[size][size];
        visit = new boolean[size][size][2];

        List<int[]> init = new ArrayList<>();
        List<int[]> end = new ArrayList<>();
        for(int i = 0; i < size; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < size; j++) {
        		if(matrix[i][j] == 'B') {
        			init.add(new int[] {i, j});
        			matrix[i][j] = '0';
        		} else if(matrix[i][j] == 'E') {
        			end.add(new int[] {i, j});
        			matrix[i][j] = '0';
        		}
        	}
        }
        
        // 1 => 세로, 2 => 가로
        // 종료점 판단
        endX = end.get(1)[0];
    	endY = end.get(1)[1];
        if(end.get(0)[0] != end.get(1)[0]) {
        	endD = 1;
        } else {
        	endD = 0;
        }
        
        // 시작점 판단
        if(init.get(0)[0] != init.get(1)[0]) {
        	bfs(init.get(1)[0], init.get(1)[1], 1);
        } else {
        	bfs(init.get(1)[0], init.get(1)[1], 0);
        }
        
        System.out.println(0);
	}
	
	private static void bfs(int i, int j, int k) {
		Queue<Log> q = new ArrayDeque<>();
		
		visit[i][j][k] = true;
		q.offer(new Log(i, j, k, 0));
		
		while(!q.isEmpty()) {
			Log poll = q.poll();
			
			if(poll.x == endX && poll.y == endY && poll.direction == endD) {
				System.out.println(poll.length);
				System.exit(0);
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(poll.direction == 1) {
					if(nx > 0 && nx < size-1 && ny >= 0 && ny < size && !visit[nx][ny][poll.direction] && matrix[nx][ny] == '0' && matrix[nx-1][ny] == '0' && matrix[nx+1][ny] == '0') {
						visit[nx][ny][poll.direction] = true;
						q.offer(new Log(nx, ny, poll.direction, poll.length+1));
					}
				} else {
					if(nx >= 0 && nx < size && ny > 0 && ny < size-1 && !visit[nx][ny][poll.direction] && matrix[nx][ny] == '0' && matrix[nx][ny-1] == '0' && matrix[nx][ny+1] == '0') {
						visit[nx][ny][poll.direction] = true;
						q.offer(new Log(nx, ny, poll.direction, poll.length+1));
					}
				}
			}
			
			// rotate
			if(poll.direction == 1) {
				if(poll.y > 0 && poll.y < size-1 && !visit[poll.x][poll.y][0]) {
					boolean flag = true;
					for(int delta = 0; delta < 8; delta++) {
						int tx = poll.x + dx[delta];
						int ty = poll.y + dy[delta];
						
						if(matrix[tx][ty] == '1') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						visit[poll.x][poll.y][0] = true;
						q.offer(new Log(poll.x, poll.y, 0, poll.length+1));
					}
				}
			} else {
				if(poll.x > 0 && poll.x < size-1 && !visit[poll.x][poll.y][1]) {
					boolean flag = true;
					for(int delta = 0; delta < 8; delta++) {
						int tx = poll.x + dx[delta];
						int ty = poll.y + dy[delta];
						
						if(matrix[tx][ty] == '1') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						visit[poll.x][poll.y][1] = true;
						q.offer(new Log(poll.x, poll.y, 1, poll.length+1));
					}
				}
			}
		}
		
	}

	public static class Log {
		int x;
		int y;
		int direction;
		int length;
		
		public Log(int x, int y, int direction, int length) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.length = length;
		}
	}
}