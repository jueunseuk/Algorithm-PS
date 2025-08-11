package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23817_포항항 {
	static int row, col, fish, min = Integer.MAX_VALUE;
	static int[][] matrix;
	static boolean[][][] visit;
	
	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		
		int sx = -1, sy = -1, idx = 0;
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				if(input[j] == '.') {
					matrix[i][j] = 0;
				} else if(input[j] == 'K') {
					matrix[i][j] = ++idx;
				} else if(input[j] == 'X') {
					matrix[i][j] = -1;
				} else if(input[j] == 'S') {
					sx = i;
					sy = j;
					matrix[i][j] = 0;
				}
			}
		}
		
		fish = idx;
		
		bfs(sx, sy);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[row][col][1 << fish];
		
		q.offer(new int[] {sx, sy, 0, 0});
		visit[sx][sy][0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			int curr = matrix[poll[0]][poll[1]]-1;
			if(curr >= 0 && curr < fish) {
				poll[2] |= 1 << curr;
			}
			
			if(Integer.bitCount(poll[2]) == 5) {
				min = Math.min(min, poll[3]);
				continue;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(!rangeCheck(nx, ny) || matrix[nx][ny] == -1) continue;
				
				if(!visit[nx][ny][poll[2]]) {
					q.offer(new int[] {nx, ny, poll[2], poll[3]+1});
					visit[nx][ny][poll[2]] = true;
				}
			}
		}
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}