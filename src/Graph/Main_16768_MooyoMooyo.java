package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16768_MooyoMooyo {
	static int row, col = 10, k;
	static boolean flag = true;
	static int matrix[][];
	static boolean visit[][];
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		matrix = new int[row][col];
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				matrix[i][j] = input[j] - '0';
			}
		}
		
		while(flag) {
			flag = false;
			visit = new boolean[row][col];
			
			for(int i = row-1; i >= 0; i--) {
				for(int j = 0; j < col; j++) {
					if(!visit[i][j] && matrix[i][j] != 0) {
						bfs(i, j);
					}
				}
			}
			
			if(flag) {
				pull();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void pull() {
		for(int i = 0; i < col; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = row-1; j >= 0; j--) {
				if(matrix[j][i] != 0) {
					list.add(matrix[j][i]);
				}
				matrix[j][i] = 0;
			}
			int idx = row-1;
			for(int out : list) {
				matrix[idx--][i] = out;
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		list.add(new int[] {i, j});
		
		int target = matrix[i][j];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == target) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					list.add(new int[] {nx, ny});
				}
			}
		}
		
		if(list.size() >= k) {
			flag = true;
			for(int[] out : list) {
				matrix[out[0]][out[1]] = 0;
			}
		}
	}
}