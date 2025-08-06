package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23352_방탈출 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int row, col, maxL = 0, maxS = 0;
    static int[][] matrix;
    static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
        
        for(int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if(matrix[i][j] != 0) {
	        		visit = new boolean[row][col];
	        		bfs(i, j);
        		}
        	}
        }
        
        System.out.println(maxS);
    }

	public static void bfs(int i, int j) {
		Queue<Room> q = new ArrayDeque<>();
		int start = matrix[i][j];
		
		q.offer(new Room(i, j, 1));
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			Room poll = q.poll();
			
			if(poll.length > maxL) {
				maxL = poll.length;
				maxS = start + matrix[poll.x][poll.y];
			} else if(poll.length == maxL) {
				maxS = Math.max(maxS, start+matrix[poll.x][poll.y]);
			}
			
			for(int delta = 0; delta < 4; delta++){
                int nx = poll.x + dx[delta];
                int ny = poll.y + dy[delta];
                
                if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 0) {
                	q.offer(new Room(nx, ny, poll.length+1));
                	visit[nx][ny] = true;
                }
            }
		}
	}
	
	static class Room {
		int x;
		int y;
		int length;
		
		public Room(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
}