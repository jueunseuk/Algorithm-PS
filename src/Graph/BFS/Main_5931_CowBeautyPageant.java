package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5931_CowBeautyPageant {
	static char[][] matrix;
    static boolean[][] visit;
    static int row, col, min = Integer.MAX_VALUE;
    
    static Queue<int[]> searchTarget = new ArrayDeque<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0 ; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        }
        
        // find first point
        escape:
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == 'X') {
        			onceDfs(i, j);
        			break escape;
        		}
        	}
        }
        
        // search queue
        for(int[] out : searchTarget) {
        	min = Math.min(min, bfs(out[0], out[1]));
		}
        
        System.out.println(min);
	}

	public static int bfs(int i , int j) {
		Queue<Section> q = new ArrayDeque<>();
		
		boolean[][] check = new boolean[row][col];
		
		q.offer(new Section(i, j, 0));
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			Section poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll.x + dx[delta];
				int ny = poll.y + dy[delta];
				
				if(nx >= 0 && ny >=0 && nx < row && ny < col && !visit[nx][ny] && !check[nx][ny]) {
					if(matrix[nx][ny] == 'X') {
						return poll.length;
					}
					q.offer(new Section(nx, ny, poll.length+1));
					check[nx][ny] = true;
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}

	public static void onceDfs(int i, int j) {
		visit[i][j] = true;
		
		searchTarget.offer(new int[] {i, j});
		
		for(int delta = 0; delta < 4; delta++) {
			int nx = i + dx[delta];
			int ny = j + dy[delta];
			
			if(nx >= 0 && ny >=0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == 'X') {
				onceDfs(nx, ny);
			}
		}
	}
	
	public static class Section {
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
