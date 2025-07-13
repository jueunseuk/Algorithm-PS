package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int size, min, max, day = 0;
	static boolean flag;
	static int[][] matrix;
	static boolean[][] visit;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		
		matrix = new int[size][size];
		visit = new boolean[size][size];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			flag = false;
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(!visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			if(flag) {
				day++;
				visit = new boolean[size][size];
			}
			else break;
		}
		
		System.out.println(day);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		q.offer(new int[] {i, j});
		list.add(new int[] {i, j});
		visit[i][j] = true;
		
		int sum = matrix[i][j];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int delta = 0; delta < 4; delta++) {
				int nx = poll[0] + dx[delta];
				int ny = poll[1] + dy[delta];
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size && !visit[nx][ny]) {
					int sub = Math.abs(matrix[nx][ny] - matrix[poll[0]][poll[1]]);
					if(sub >= min && sub <= max) {
						q.offer(new int[] {nx, ny});
						list.add(new int[] {nx, ny});
						sum += matrix[nx][ny];
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		if(list.size() > 1) {
			flag = true;
			int div = sum / list.size();
			
			for(int[] out : list) {
				matrix[out[0]][out[1]] = div;
			}
		}
	}
}