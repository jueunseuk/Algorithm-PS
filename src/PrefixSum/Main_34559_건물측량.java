package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_34559_건물측량 {
	static int row, col;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new int[row+1][col+1];
        visit = new boolean[row+1][col+1];
        
        for(int i = 1; i <= row; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 1; j <= col; j++) {
        		matrix[i][j] = input[j-1] - '0';
        	}
        }
        
        // check reachable
        for(int i = 1; i <= row; i++) {
        	if(!visit[i][1] && matrix[i][1] == 0) {
        		bfs(i, 1);
        	}
        	if(!visit[i][col] && matrix[i][col] == 0) {
        		bfs(i, col);
        	}
        }
        for(int i = 1; i <= col; i++) {
        	if(!visit[1][i] && matrix[1][i] == 0) {
        		bfs(1, i);
        	}
        	if(!visit[row][i] && matrix[row][i] == 0) {
        		bfs(row, i);
        	}
        }
        
        // conversion
        for(int i = 1; i <= row; i++) {
        	for(int j = 1; j <= col; j++) {
        		if(!visit[i][j]) {
        			matrix[i][j] = 1;
        		}
        	}
        }
        
        // prefix sum
        int[][] sum = new int[row+1][col+1];
        for(int i = 1; i <= row; i++) {
        	for(int j = 1; j <= col; j++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i][j] - sum[i-1][j-1];
        	}
        }
        
        // query
        StringBuilder sb = new StringBuilder();
        int query = Integer.parseInt(br.readLine());
        for(int q = 0; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int sx = Integer.parseInt(st.nextToken());
        	int sy = Integer.parseInt(st.nextToken());
        	int ex = Integer.parseInt(st.nextToken());
        	int ey = Integer.parseInt(st.nextToken());
        	
        	int partSum = sum[ex][ey] - sum[sx-1][ey] - sum[ex][sy-1] + sum[sx-1][sy-1];
        	
        	sb.append(partSum == 0 ? "Yes" : "No "+partSum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny] || matrix[nx][ny] == 1) {
					continue;
				}
				
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx <= 0 || ny <= 0 || nx > row || ny > col;
	}

}
