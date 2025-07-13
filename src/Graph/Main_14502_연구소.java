package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int row, col, max = 0;
	static int[][] matrix;
	static boolean[][] visit;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static Queue<int[]> virus = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 2) {
        			virus.offer(new int[] {i, j});
        		}
        	}
        }
        
        for(int a = 0; a < row; a++) {
        	for(int b = 0; b < col; b++) {
        		if(matrix[a][b] == 0) {
        			matrix[a][b] = 1;
        			for(int c = 0; c < row; c++) {
        	        	for(int d = 0; d < col; d++) {
        	        		if(matrix[c][d] == 0) {
        	        			matrix[c][d] = 1;
        	        			for(int e = 0; e < row; e++) {
        	        	        	for(int f = 0; f < col; f++) {
        	        	        		if(matrix[e][f] == 0) {
        	        	        			matrix[e][f] = 1;
        	        	        			max = Math.max(bfs(), max);
        	        	        			matrix[e][f] = 0;
        	        	        		}
        	        	        	}
        	        	        }
        	        			matrix[c][d] = 0;
        	        		}
        	        	}
        	        }
        			matrix[a][b] = 0;
        		}
        	}
        }
        
        System.out.println(max);
	}

	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		for(int[] out : virus) {
			q.offer(new int[] {out[0], out[1]});
			visit[out[0]][out[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visit[i][j] && matrix[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}	
}