package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_22944_죽음의비 {
	static int size, hp, durability, min = Integer.MAX_VALUE;
	static char[][] matrix;
	static int[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        hp = Integer.parseInt(st.nextToken());
        durability = Integer.parseInt(st.nextToken());
        
        matrix = new char[size][size];
        visit = new int[size][size];
        
        int startX = 0, startY = 0;
        for(int i = 0; i < size; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < size; j++) {
        		if(matrix[i][j] == 'S') {
        			matrix[i][j] = '.';
        			startX = i;
        			startY = j;
        		}
        	}
        }
        
        bfs(startX, startY);
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);        
	}

	private static void bfs(int i, int j) {
		Queue<User> q = new ArrayDeque<>();
		
		visit[i][j] = hp;
		q.offer(new User(i, j, hp, 0, 0));
		
		while(!q.isEmpty()) {
			User poll = q.poll();
			
			if(poll.chp <= 0) {
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size) {
					if(poll.chp+poll.cd > visit[nx][ny]) {
						visit[nx][ny] = poll.chp + poll.cd;
						
						if(matrix[nx][ny] == 'U') {
							q.offer(new User(nx, ny, poll.chp, poll.length+1, durability-1));
						} else if(matrix[nx][ny] == 'E') {
							min = poll.length+1;
							return;
						} else {
							if(poll.cd > 0) {
								q.offer(new User(nx, ny, poll.chp, poll.length+1, poll.cd-1));
							} else {
								q.offer(new User(nx, ny, poll.chp-1, poll.length+1, poll.cd));
							}
						}
					}
				}
			}
		}
	}
	
	public static class User {
		int x;
		int y;
		int chp;
		int length;
		int cd;
		
		public User(int x, int y, int chp, int length, int cd) {
			this.x = x;
			this.y = y;
			this.chp = chp;
			this.length = length;
			this.cd = cd;
		}		
	}
}
