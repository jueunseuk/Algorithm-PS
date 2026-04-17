package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_34218_숭고한마법학교 {
	static int row, col;
	static boolean[][] matrix;
	static int[][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        matrix = new boolean[row][col];
        cost = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j = 0; j < col; j++) {
        			if(st.nextToken().equals("1")) {
        				matrix[i][j] = true;
        			}
        		}
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine(), " ");
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;
        
        zeroOneBfs(sx, sy, ex ,ey);
	}

	private static void zeroOneBfs(int sx, int sy, int ex, int ey) {
		Deque<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < row; i++) {
			Arrays.fill(cost[i], 100000000);
		}
		
		q.offer(new int[] {sx, sy, 0, 0});
		cost[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.pollFirst();
			
			if(poll[3] >= cost[poll[0]][poll[1]]) continue;
			
			if(poll[0] == ex && poll[1] == ey) {
				System.out.println(poll[3]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx < 0 || ny < 0 || nx >= row || ny >= col) {
					continue;
				}
				
				int ns = matrix[nx][ny] == matrix[poll[0]][poll[1]] ? poll[3] : poll[3] + 1;
				int nc = matrix[nx][ny] ? poll[2] : poll[2] + 1;
				if(ns > 1 || cost[nx][ny] <= nc) continue;
				
				if(matrix[nx][ny] == matrix[poll[0]][poll[1]]) {
					if(matrix[nx][ny]) {
						q.offerFirst(new int[] {nx, ny, ns, nc});
					} else {
						q.offerLast(new int[] {nx, ny, ns, nc});
					}
				} else {
					if(matrix[nx][ny]) {
						q.offerFirst(new int[] {nx, ny, ns, nc});
					} else {
						q.offerLast(new int[] {nx, ny, ns, nc});
					}
				}
			}
		}
	}
}