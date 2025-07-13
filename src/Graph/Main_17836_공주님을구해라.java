package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {
	static int row, col, limit, minT = Integer.MAX_VALUE;
	static int knifeX, knifeY;
	static int[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 2) {
        			knifeX = i;
        			knifeY = j;
        		}
        	}
        }
        
        bfs(0, 0);
        
        System.out.println(minT <= limit ? minT : "Fail");
	}
	
	private static void bfs(int i, int j) {
		Queue<Section> q = new ArrayDeque<>();
		
		visit[i][j] = true;
		q.offer(new Section(i, j, 0));
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			if(poll.x == knifeX && poll.y == knifeY) {
				int deltaX = row-1-poll.x;
				int deltaY = col-1-poll.y;
				
				minT = Math.min(minT, poll.length+deltaX+deltaY);
				
				continue;
			}
			
			if(poll.x == row-1 && poll.y == col-1) {
				minT = Math.min(minT, poll.length);
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 1) {
					visit[nx][ny] = true;
					q.offer(new Section(nx, ny, poll.length+1));
				}
			}
		}
		
	}

	static class Section {
		int x;
		int y;
		int length;
		
		public Section(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}

}
