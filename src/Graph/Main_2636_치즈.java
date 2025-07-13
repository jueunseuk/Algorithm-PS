package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int row, col, total = 0, time = 1;
    static int[][] matrix;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static Queue<Cheese> candidate = new LinkedList<>();

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
        		if(matrix[i][j] == 1) total++;
        	}
        }
        
        while(total > 0) {
        	bfs(0, 0);
        	time++;
        }
	}
    
    public static void bfs(int i , int j) {
    	boolean[][] visit = new boolean[row][col];
    	Queue<Cheese> q = new LinkedList<>();
    	
    	q.offer(new Cheese(i, j));
    	visit[i][j] = true;
    	
    	while(!q.isEmpty()) {
    		Cheese poll = q.poll();
    		
    		for(int delta = 0; delta < 4; delta++) {
    			int nx = poll.x + dx[delta];
    			int ny = poll.y + dy[delta];
    			
    			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
    				visit[nx][ny] = true;
    				if(matrix[nx][ny] == 1) {
    					candidate.offer(new Cheese(nx, ny));
    					total--;
    				} else {
    					q.offer(new Cheese(nx, ny));
    				}
    			}
    		}
    	}
    	
    	if(total == 0) {
    		int cnt = 0;
    		
    		for(int xi = 0; xi < row; xi++) {
    			for(int yj = 0; yj < col; yj++) {
    				if(matrix[xi][yj] == 1) cnt++;
    			}
    		}
    		
    		System.out.println(time);
    		System.out.println(cnt);
    	}
    	
    	int size = candidate.size();
    	for(int k = 0; k < size; k++) {
    		Cheese poll = candidate.poll();
    		matrix[poll.x][poll.y] = 0;
    	}
	}

	public static class Cheese {
		int x;
		int y;
		
		public Cheese(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}