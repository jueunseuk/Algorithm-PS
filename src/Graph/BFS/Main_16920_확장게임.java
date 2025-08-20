package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16920_확장게임 {
	static int row, col, p;
	static int[][] matrix;
	static int[] range;
	static boolean[][] visit;
	static boolean flag;
	static Queue<int[]> q;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		range = new int[p+1];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= p; i++) {
			range[i] = Integer.parseInt(st.nextToken());
		}
		
		matrix = new int[row][col];
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < col; j++) {
				if(input[j] == '.') {
					matrix[i][j] = 0;
				} else if(input[j] == '#') {
					matrix[i][j] = -1;
				} else {
					matrix[i][j] = input[j] - '0';
				}
			}
		}

		Queue<int[]>[] qs = new ArrayDeque[p+1];
		for (int i = 1; i <= p; i++) qs[i] = new ArrayDeque<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] > 0) {
					qs[matrix[i][j]].offer(new int[]{i, j});
				}
			}
		}

		flag = true;
		while (flag) {
			flag = false;
			
			for (int i = 1; i <= p; i++) {
				for (int step = 0; step < range[i]; step++) {
					int size = qs[i].size();
					
					if (size == 0) break;
					
					for (int s = 0; s < size; s++) {
						int[] cur = qs[i].poll();
						
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							
							if (nx < 0 || ny < 0 || nx >= row || ny >= col || matrix[nx][ny] != 0) continue;
							
							matrix[nx][ny] = i;
							qs[i].offer(new int[]{nx, ny});
							flag = true;
						}
					}
				}
			}
		}
		
		int[] cnt = new int[p+1];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] > 0) {
					cnt[matrix[i][j]]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < p; i++) {
			sb.append(cnt[i]).append(' ');
		}
		sb.append(cnt[p]);
		
		System.out.println(sb.toString().trim());
	}
}
