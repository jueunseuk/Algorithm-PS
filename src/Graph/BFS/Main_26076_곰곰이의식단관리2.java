package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_26076_곰곰이의식단관리2 {
	static int row, col;
	static boolean check = false;
	static int[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int isBlocked = bfs(0, 0);
        
        if(isBlocked > 0) {
        	System.out.println(0);
        	return;
        }
        
        if(row == 1 || col == 1) {
        	System.out.println(1);
        	return;
        }
        
		int start = countAround(0, 0);
		int end = countAround(row-1, col-1);
		
		if(start == 1 || end == 1) {
			System.out.println(1);
			return;
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(check) {
					System.out.println(1);
					return;
				} else {
					check = searchAround(i, j);
				}
			}
		}
		
		System.out.println(2);
	}
	
	private static int countAround(int i, int j) {
		int cnt = 0;
		if(i == 0 && j == 0) {
			if(matrix[1][0] == 1) cnt++;
			if(matrix[0][1] == 1) cnt++;
			return cnt;
		} else {
			if(matrix[row-2][col-1] == 1) cnt++;
			if(matrix[row-1][col-2] == 1) cnt++;
			return cnt;
		}
	}

	private static int bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		q.offer(new int[] {i, j, 0});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[0] == row-1 && poll[1] == col-1) {
				return poll[2];
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny]) {
					if(matrix[nx][ny] == 0) {
						q.offerFirst(new int[] {nx, ny, poll[2]});
						visit[nx][ny] = true;
					} else {
						q.offerLast(new int[] {nx, ny, poll[2]+1});
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		return 0;
	}
	
	private static boolean searchAround(int i, int j) {
		int up, down, right, left;
		
		if(i == 0) {
			up = 0;
			down = matrix[1][j] == 1 ? 1 : 2;
		} else if(i == row-1) {
			up = matrix[row-2][j] == 1 ? 1 : 2;
			down = 0;
		} else {
			up = matrix[i-1][j] == 1 ? 1 : 2;
			down = matrix[i+1][j] == 1 ? 1 : 2;
		}
		
		if(j == 0) {
			left = 0;
			right = matrix[i][1] == 1 ? 1 : 2;
		} else if(j == col-1) {
			left = matrix[i][col-2] == 1 ? 1 : 2;
			right = 0;
		} else {
			left = matrix[i][j-1] == 1 ? 1 : 2;
			right = matrix[i][j+1] == 1 ? 1 : 2;
		}
		
		if((up == 1 || up == 0) && (down == 1 || down == 0) && left == 2 && right == 2) {
			return true;
		} else if((left == 0 || left == 1) && (right == 0 || right == 1) && up == 2 && down == 2) {
			return true;
		} else {
			return false;
		}
	}
}