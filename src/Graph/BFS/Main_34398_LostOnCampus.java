package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_34398_LostOnCampus {
	static int row, col;
	static char[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        matrix = new char[row][col];
        
        int sx = 0, sy = 0;
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if(matrix[i][j] == '*') {
        			sx = i;
        			sy = j;
        			matrix[i][j] = '.';
        			break;
        		}
        	}
        }
        
        zeroOneBfs(sx, sy);

	}

	private static void zeroOneBfs(int sx, int sy) {
		Deque<int[]> deq = new ArrayDeque<>();
		visit = new boolean[row][col];
		
		deq.offerLast(new int[] {sx, sy, 0});
		visit[sx][sy] = true;
		
		while(!deq.isEmpty()) {
			int[] poll = deq.pollFirst();
			
			if(matrix[poll[0]][poll[1]] == 'E') {
				System.out.println(poll[2]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny] || matrix[nx][ny] == '#') continue;
				
				if(matrix[nx][ny] == 'D') {
					deq.offerLast(new int[] {nx, ny, poll[2]+1});
				} else {
					deq.offerFirst(new int[] {nx, ny, poll[2]});
				}
				visit[nx][ny] = true;
			}
		}
		
		System.out.println("NOT POSSIBLE");
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}
}