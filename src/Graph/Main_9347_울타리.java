package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_9347_울타리 {
	static int row, col;
	static int[][] matrix;
	static boolean[][] visit;
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	row = Integer.parseInt(st.nextToken());
        	col = Integer.parseInt(st.nextToken());
        	
        	matrix = new int[row][col];
        	visit = new boolean[row][col];
        	
        	for(int i = 0; i < row; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j = 0; j < col; j++) {
        			matrix[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[] result = bfs();
        	sb.append(result[0]+" "+result[1]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static int[] bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < row; i++) {
			if(!visit[i][0]) {
				if(matrix[i][0] == 0) {
					q.offerFirst(new int[] {i, 0, 0});
				} else {
					q.offerLast(new int[] {i, 0, 1});
				}
				visit[i][0] = true;
			}
			if(!visit[i][col-1]) {
				if(matrix[i][col-1] == 0) {
					q.offerFirst(new int[] {i, col-1, 0});
				} else {
					q.offerLast(new int[] {i, col-1, 1});
				}
				visit[i][col-1] = true;
			}
		}
		
		for(int i = 0; i < col; i++) {
			if(!visit[0][i]) {
				if(matrix[0][i] == 0) {
					q.offerFirst(new int[] {0, i, 0});
				} else {
					q.offerLast(new int[] {0, i, 1});
				}
				visit[0][i] = true;
			}
			if(!visit[row-1][i]) {
				if(matrix[row-1][i] == 0) {
					q.offerFirst(new int[] {row-1, i, 0});
				} else {
					q.offerLast(new int[] {row-1, i, 1});
				}
				visit[row-1][i] = true;
			}
		}
		
		int currentMax = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(currentMax < poll[2] && matrix[poll[0]][poll[1]] == 0) {
				currentMax = poll[2];
				cnt = 0;
			}
			if(matrix[poll[0]][poll[1]] == 0) {
				cnt++;
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
		
		return new int[] {currentMax, cnt};
	}
}