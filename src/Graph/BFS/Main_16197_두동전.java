package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16197_두동전 {
	static int row, col, cnt = 0;
	static char matrix[][];
	static boolean visit[][][][];
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken())+2;
        col = Integer.parseInt(st.nextToken())+2;
        
        matrix = new char[row][col];
        for(int i = 0; i < col; i++) {
        	matrix[0][i] = '.';
        	matrix[row-1][i] = '.';
        }
        
        visit = new boolean[row][col][row][col];
        
        StringBuilder input;
        int firstX = -1, firstY = -1, lastX = -1, lastY = -1;
        for(int i = 1; i < row-1; i++) {
        	input = new StringBuilder(br.readLine());
        	input.insert(0, '.').append('.');
        	
        	matrix[i] = input.toString().toCharArray();
        	
        	for(int j = 1; j < col-1; j++) {
        		if(matrix[i][j] == 'o') {
        			if(firstX == -1) {
        				matrix[i][j] = '.';
        				firstX = i;
        				firstY = j;
        			} else {
        				matrix[i][j] = '.';
        				lastX = i;
        				lastY = j;
        			}
        		}
        	}
        }
        
        bfs(firstX, firstY, lastX, lastY);
        
        System.out.println(-1);
	}

	public static void bfs(int firstX, int firstY, int lastX, int lastY) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {firstX, firstY, lastX, lastY, 0});
		visit[firstX][firstY][lastX][lastY] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[4] > 10){
				return;
			}
			
			if((poll[0] == 0 || poll[0] == row-1 || poll[1] == 0 || poll[1] == col-1) && (poll[2] > 0 && poll[2] < row-1 && poll[3] > 0 && poll[3] < col-1)) {
				System.out.println(poll[4]);
				System.exit(0);
			} else if((poll[2] == 0 || poll[2] == row-1 || poll[3] == 0 || poll[3] == col-1) && (poll[0] > 0 && poll[0] < row-1 && poll[1] > 0 && poll[1] < col-1)) {
				System.out.println(poll[4]);
				System.exit(0);
			}
			
			if(poll[0] == 0 || poll[0] == row-1 || poll[1] == 0 || poll[1] == col-1 || poll[2] == 0 || poll[2] == row-1 || poll[3] == 0 || poll[3] == col-1) {
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				int nnx = poll[2] + dx[delta];
				int nny = poll[3] + dy[delta];
				
				if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
				
				if(matrix[nx][ny] == '#') {
					nx = poll[0];
					ny = poll[1];
				}
				if(matrix[nnx][nny] == '#') {
					nnx = poll[2];
					nny = poll[3];
				}
				
				if(!visit[nx][ny][nnx][nny]) {
					q.offer(new int[] {nx, ny, nnx, nny, poll[4]+1});
					visit[nx][ny][nnx][nny] = true;
				}
			}
		}
	}
}