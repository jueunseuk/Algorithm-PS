package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25307_백화점 {
	static int row, col, k;
	static int[][] matrix;
	static boolean[][] visit;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static Queue<int[]> dummy = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        visit =new  boolean[row][col];
        
        int startX = 0, startY = 0;
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		
        		if(matrix[i][j] == 3) {
        			matrix[i][j] = 1;
        			dummy.offer(new int[] {i, j, k});
        		} else if(matrix[i][j] == 4) {
        			matrix[i][j] = 0;
        			startX = i;
        			startY = j;
        		}
        	}
        }
        
        dummyCheck();
        
        bfs(startX, startY);
        
        System.out.println(-1);
	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		
		visit[startX][startY] = true;
		q.offer(new int[] {startX, startY, 0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == 2) {
				System.out.println(poll[2]);
				System.exit(0);;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 1) {
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny, poll[2]+1});
				}
			}
		}
	}

	private static void dummyCheck() {
		while(!dummy.isEmpty()) {
			int[] poll = dummy.poll();
			
			if(poll[2] == 0) {
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					if(matrix[nx][ny] == 0 || matrix[nx][ny] == 1 || matrix[nx][ny] == 2) {
						visit[nx][ny] = true;
						matrix[nx][ny] = 1;
						dummy.offer(new int[] {nx, ny, poll[2]-1});
					}
				}
			}
		}
	}

}
