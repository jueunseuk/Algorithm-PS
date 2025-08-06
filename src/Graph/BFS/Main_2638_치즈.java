package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static int row, col, total = 0, time = 0;
    static Cheese[][] matrix;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static Queue<Cheese> candidate = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new Cheese[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = new Cheese(i, j, Integer.parseInt(st.nextToken()));
        		if(matrix[i][j].status == 1) {
        			matrix[i][j].setHP(2);
        			total++;
        		} else {
        			matrix[i][j].setHP(0);
        		}
        	}
        }
        
        while(total > 0) {
        	bfs(0, 0);
        	time++;
        }
        
        System.out.println(time);
	}
    
    public static void bfs(int i , int j) {
    	boolean[][] visit = new boolean[row][col];
    	Queue<Cheese> q = new LinkedList<>();
    	
    	q.offer(matrix[i][j]);
    	visit[i][j] = true;
    	
    	while(!q.isEmpty()) {
    		Cheese poll = q.poll();
    		
    		for(int delta = 0; delta < 4; delta++) {
    			int nx = poll.x + dx[delta];
    			int ny = poll.y + dy[delta];
    			
    			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
    				if(matrix[nx][ny].status == 0) {
    					visit[nx][ny] = true;
        				q.offer(matrix[nx][ny]);
    				} else {
    					candidate.offer(matrix[nx][ny]);
    					if(matrix[nx][ny].hp > 0) matrix[nx][ny].hp--;
    				}
    			}
    		}
    	}
    	
    	int size = candidate.size();
    	for(int k = 0; k < size; k++) {
    		Cheese poll = candidate.poll();
    		
    		if(poll.status == 1) {
	    		if(poll.hp <= 0) {
	    			poll.status = 0;
	    			total--;
	    		} else {
	    			poll.hp = 2;
	    		}
    		}
    	}
	}

	public static class Cheese {
		int x;
		int y;
		int status;
		int hp;
		
		public Cheese(int x, int y, int status) {
			this.x = x;
			this.y = y;
			this.status = status;
		}
		
		public void setHP(int hp) {
			this.hp = hp;
		}
	}
}