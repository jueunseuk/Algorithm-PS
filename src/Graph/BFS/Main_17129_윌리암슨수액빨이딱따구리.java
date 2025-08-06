package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17129_윌리암슨수액빨이딱따구리 {
	static int row, col, min;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		visit = new boolean[row][col];
		
		int x1 = 0, y1 = 0;
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				switch(input[j]) {
					case '0':{
						matrix[i][j] = 0;
						break;
					}
					case '1':{
						matrix[i][j] = 1;
						break;
					}
					case '2':{
						matrix[i][j] = 0;
						x1 = i;
						y1 = j;
						break;
					}
					default:{
						matrix[i][j] = 3;
						break;
					}
				}
			}
		}
		
		bfs(x1, y1);
		
		if(min == 0) {
			System.out.println("NIE");
		} else {
			System.out.println("TAK");
			System.out.println(min);
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {i, j, 0});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(matrix[poll[0]][poll[1]] == 3) {
				min = poll[2];
				return;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] != 1) {
					q.offer(new int[] {nx, ny, poll[2]+1});
					visit[nx][ny] = true;
				}
			}
		}
	}
}