package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {
	static int row, col, spot;
	static int[][] matrix;
	static boolean[][][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	col = Integer.parseInt(st.nextToken());
        	row = Integer.parseInt(st.nextToken());
        	
        	if(row == 0 && col == 0) break;
        	
        	matrix = new int[row][col];
        	
        	int cnt = 0;
        	int sx = 0, sy = 0;
        	for(int i = 0; i < row; i++) {
        		char[] input = br.readLine().toCharArray();
        		for(int j = 0; j < col; j++) {
        			if(input[j] == '*') {
        				matrix[i][j] = ++cnt;
        			} else if(input[j] == 'x') {
        				matrix[i][j] = -1;
        			} else if(input[j] == 'o') {
        				sx = i;
        				sy = j;
        			}
        		}
        	}
        	
        	spot = cnt;
        	
        	int result = bfs(sx, sy);
        	sb.append(result+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static int bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col][1 << spot];
		
		q.offer(new int[] {sx, sy, 0, 0});
		visit[sx][sy][0] = true;
		
		int target = (1 << spot) - 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[2] == target) {
				return poll[3]-1;
			}
			
			if(matrix[poll[0]][poll[1]] > 0) {
				poll[2] |= 1 << (matrix[poll[0]][poll[1]] - 1);
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny][poll[2]]) continue;
				
				if(matrix[nx][ny] < 0) continue;
				
				q.offer(new int[] {nx, ny, poll[2], poll[3] + 1});
				visit[nx][ny][poll[2]] = true;
			}
		}
		
		return -1;
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}
}