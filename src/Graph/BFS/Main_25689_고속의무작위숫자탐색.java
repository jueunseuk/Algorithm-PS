package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25689_고속의무작위숫자탐색 {
	static int size = 5;
	static int[][] matrix = new int[size][size];
	static boolean[][][] visit = new boolean[size][size][64];
	
	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		
		bfs(sx, sy);
	}

	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {sx, sy, 0, 0});
		visit[sx][sy][0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			int curr = matrix[poll[0]][poll[1]]-1;
			if(curr >= 0 && curr < 6) {
				poll[2] |= 1 << curr;
			}
			
			if(poll[2] == 63) {
				System.out.println(poll[3]);
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(!rangeCheck(nx, ny) || matrix[nx][ny] == -1) continue;
				
				if(!visit[nx][ny][poll[2]]) {
					q.offer(new int[] {nx, ny, poll[2], poll[3]+1});
					visit[nx][ny][poll[2]] = true;
				}
				
				nx = poll[0];
				ny = poll[1];
				while(true) {
					int nnx = nx + dx[delta];
					int nny = ny + dy[delta];
					
					if(!rangeCheck(nnx, nny)) break;
					
					if(matrix[nnx][nny] == -1) {
						break;
					} else if(matrix[nnx][nny] == 7) {
						nx = nnx;
						ny = nny;
						break;
					}
					
					nx = nnx;
					ny = nny;
				}
				
				if(!visit[nx][ny][poll[2]]) {
					q.offer(new int[] {nx, ny, poll[2], poll[3]+1});
					visit[nx][ny][poll[2]] = true;
				}
			}
		}
		
		System.out.println(-1);
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < size && ny < size;
	}
}