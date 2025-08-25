package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_1035_조각움직이기 {
	static int size = 5, cnt;
	static int[][] matrix = new int[size][size];
	static boolean[][] makeVisit = new boolean[size][size];
	static boolean[][][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < size; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < size; j++) {
        		if(input[j] == '.') {
        			matrix[i][j] = -1;
        		} else {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(matrix[i][j] == 0) {
        			check(i, j, ++cnt);
        		}
        	}
        }
        
        for(int i = 0; i < size; i++) {
        	System.out.println(Arrays.toString(matrix[i]));
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(matrix[i][j] >= 0) {
        			int result = bfs(i, j);
        			min = Math.min(min, result);
        			System.out.println(min);
        		}
        	}
        }
        
        System.out.println(min);
	}

	private static void check(int i, int j, int idx) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j});
		makeVisit[i][j] = true;
		matrix[i][j] = idx;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || makeVisit[nx][ny] || matrix[nx][ny] != 0) continue;
				
				q.offer(new int[] {nx, ny});
				makeVisit[nx][ny] = true;
				matrix[nx][ny] = idx;
			}
		}
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[size][size][1 << cnt];
		
		q.offer(new int[] {i, j, 0, 0});
		visit[i][j][1 << (matrix[i][j]-1)] = true;
		
		int target = (1 << cnt) - 1;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[2] == target) {
				return poll[3];
			}
			
			if(matrix[poll[0]][poll[1]] >= 0) {
				poll[2] |= 1 << (matrix[poll[0]][poll[1]] - 1);
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(outOfRange(nx, ny) || visit[nx][ny][poll[2]]) continue;
				
				q.offer(new int[] {nx, ny, poll[2], poll[3] + 1});
				visit[nx][ny][poll[2]] = true;
			}
		}
		
		return -1;
	}

	private static boolean outOfRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= size || ny >= size;
	}

}
